package com.example.patch.service.util;

import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ReName {
    public static void main(String[] args)throws Exception {
        String pathtxt = "F:\\GZOU\\考务\\test\\number.txt";
        List<String> scanListPath = readFile02(pathtxt);
        Scanner input=new Scanner(System.in);
        System.out.println("this functionality will rename all files in package");
        System.out.println("please input file dir path:");
        String s=input.next();
        System.out.println("please input file dist path:");
        String dist=input.next();
        File path=new File(s);
        if(path.isDirectory()){
            System.out.println("the prefix is,please input: ");
            String pre=input.next();
            File[] files=path.listFiles();
            int cnt=0;
            for (int i = 0; i < files.length; i++) {
                cnt++;
                File file=files[i];
                if(file.isFile()){
                    String realName=file.getName();
                    for(String a:scanListPath){
                        if(realName.contains(a)){
                            String Postfix=realName.substring(realName.indexOf('.'));
                            //File dest=new File(s+"/"+pre+"["+cnt+"]"+Postfix);
                            //File dest=new File(s+"/"+pre+realName+Postfix);
                            File dest=new File(dist+"/"+realName);
                            System.out.println(a);
                            file.renameTo(dest);
                            break;
                        }else {
                            continue;
                        }
                    }
//                    String Postfix=realName.substring(realName.indexOf('.'));
//                    //File dest=new File(s+"/"+pre+"["+cnt+"]"+Postfix);
//                    File dest=new File(realName+"/"+"["+cnt+"]"+Postfix);
//                    file.renameTo(dest);
                }
            }
            System.out.println("rename finish");
        }else{
            System.out.println("please input correct path");
        }
    }

    /**
     * 读取一个文本 一行一行读取
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static List<String> readFile02(String path) throws IOException {
        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
        List<String> list = new ArrayList<String>();
        FileInputStream fis = new FileInputStream(path);
        // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = "";
        while ((line = br.readLine()) != null) {
            // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
//            if (line.lastIndexOf("---") < 0) {
            list.add(line);
//            }
        }
        br.close();
        isr.close();
        fis.close();
        return list;
    }
}
