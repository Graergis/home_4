package ru.grishin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> list2 = new ArrayList<>();
        java.io.File f = new java.io.File("INPUT.TXT");
        if (!f.exists()) {
            System.out.println("Входящий файл не найден.");
        } else {
            Scanner in = new Scanner(new File("INPUT.TXT"));
            while (in.hasNextLine()) {
                list2.add(in.nextInt());
            }
            Set<Character> set = new HashSet<>();
            List<String> list = new ArrayList<>();
            Integer[] arr = new Integer[list2.get(0)];
            for (int i8 = 0; i8 < arr.length; i8++) {
                arr[i8] = i8 + 1;
            }
            int br = list2.get(1);
            String sd;
            String sd2 = "";
            int re = 0;
            String in1 = "";
            String in2 = "";
            int factorial = arr[0];
            int t1 = 0;
            for (int ii = 1; ii < arr.length; ii++) {
                factorial *= arr[ii];
            }
            System.out.println("Factorial " +factorial);
            for (int ii = 0; ii < arr.length; ii++) {
                in1 += arr[ii];
            }
            Integer in11 = new Integer(in1);
            for (int i2 = arr.length-1; i2 >= 0; i2--) {
                in2 += arr[i2];
            }
            Integer in12 = new Integer(in2);
            for (int i6 = in11; i6 <= in12; i6++) {
                sd = "" + i6;
                char[] ch =  sd.toCharArray();
                for (int i4 = 0; i4 < ch.length; i4++) {
                    if (Character.getNumericValue(ch[i4]) <= arr.length & Character.getNumericValue(ch[i4]) >= arr[0]){
                        sd2 += "" + ch[i4];
                        re += 1;
                    }
                    if (re == ch.length){
                        char[] ch2 =  sd2.toCharArray();
                        for (int i3 = 0; i3 < ch2.length; i3++) {
                            set.add(ch2[i3]);
                            if (Character.getNumericValue(ch[i3]) == (i3+1)){
                                t1 += 1;
                            }
                        }
                        if (ch2.length != set.size()){
                            t1 = -1;
                        }
                        if (t1 == br){
                            list.add(sd2);
                        }
                        t1 = 0;
                    }
                }
                sd2 = "";
                re = 0;
                set.clear();
            }
            int out = list.size();
            System.out.println(out);
            File fil = new File("OUTPUT.TXT");
            FileWriter wrt = new FileWriter(fil);
            wrt.write(out + "");
            wrt.flush();
        }
    }
}