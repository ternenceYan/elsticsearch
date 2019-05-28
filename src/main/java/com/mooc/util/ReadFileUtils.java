package com.mooc.util;

import java.io.*;

public class ReadFileUtils {

    /**字节输入、输出流
     * 复制文件(该形式复制的图片打不开)
     * 先从inPath路径中读取文件，再将文件读入到outPath路径文件
     * @param inPath
     * @param outPath
     */
    public static void readFile (String inPath, String outPath) {
        try {
            File file = new File(inPath);
            InputStream in = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(in);
            BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
            String line;

            File fileO = new File(outPath);
            if (!fileO.exists()) {
                fileO.createNewFile();
            }
            OutputStream out = new FileOutputStream(fileO);
            while ((line = bufferedReader.readLine()) != null) {
                line = line + "\n";
                byte[] bytes = line.getBytes();
                out.write(bytes);
            }
            out.close();
            bufferedReader.close();
            inputStreamReader.close();
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 复制文件(复制的图片能打开)
     * @param inPath
     * @param outPath
     */
    public static void copyPicture (String inPath, String outPath) {
        try {
            System.out.println("###########开始复制##########");
            FileInputStream in = new FileInputStream(inPath);
            FileOutputStream out = new FileOutputStream(outPath);
            System.out.println("文件大小："+in.available());
            // 保存字节
            byte[] b = new byte[in.available()];
            in.read(b);
            System.out.println("in.read:"+in.read());
            out.write(b);
            System.out.println("##########成功复制##########");
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流读取数据
     * @param inPath
     * @param outPath
     */
    public static void readFile2 (String inPath, String outPath) {
        System.out.println("##########开始字符流读取文件###########");
        try {
            File file = new File(inPath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader fr = new FileReader(file);
            char[] data = new char[50];
            int len;

            while ((len = fr.read()) != -1) {
//                String str = new String(data,0,len);
                System.out.print((char) len);
            }
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 字符流读取数据，输入数据
     * @param inPaht
     * @param outPath
     */
    public static void readFile3 (String inPaht, String outPath) {

        try {
            FileReader fr = new FileReader(inPaht);
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter(outPath);
            BufferedWriter bw = new BufferedWriter(fw);

            String str ;
            while ((str = br.readLine()) != null) {
                bw.write(str+"\n");
            }
            bw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        String inPath = "D:\\work_files\\excel\\1.jpg";
        String outPath = "D:\\work_files\\excel\\2.jpg";
//        readFile(inPath,outPath);
//        readFile2(inPath,outPath);
//        readFile3(inPath,outPath);
        copyPicture(inPath,outPath);
    }
}
