package com.example.patch.service.util;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class QueryLog {
    public static void main(String[] args) throws Exception {
//        String pathtxt = "F:\\GZOU\\考务\\test\\number.txt";
//        List<String> scanListPath = readFile02(pathtxt);
        Scanner input = new Scanner(System.in);
        System.out.println("this functionality will rename all files in package");
        System.out.println("please input file dir path:");
        String s = input.next();
        System.out.println("please input file dist path:");
        String dist = input.next();
        File path = new File(s);
        if (path.isDirectory()) {
            System.out.println("the prefix is,please input: ");
            String pre = input.next();
            File[] files = path.listFiles();
            int cnt = 0;
            for (int i = 0; i < files.length; i++) {
                cnt++;
                File file = files[i];
                if (file.isFile()) {
                    String realName = file.getName();
                    System.out.println(realName);
                }
            }
        }
    }
}
