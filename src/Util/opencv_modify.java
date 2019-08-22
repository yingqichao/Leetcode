package Util;

import java.io.*;
import java.util.*;

public class opencv_modify {

    public static void main(String[] args)throws Exception{
        write(read("src//Util//opencv3.4_install.lib.txt"));

    }


    public static List<String> read(String filename){
//        String str = null;
        List<String> list = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filename)),
                    "UTF-8"));
            String lineTxt = null;
            while ((lineTxt = br.readLine()) != null) {
                list.add(lineTxt);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("read errors :" + e);
        }
        return list;
    }

    public static void write(List<String> list) throws IOException {
        File fout = new File("src//Util//out.txt");
        FileOutputStream fos = new FileOutputStream(fout);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        for (String value:list) {
            bw.write(value.trim()+";");
        }
        bw.close();
        System.out.println("Finish.");
    }
}
