package com.mooc.tools;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.*;

public class StringTest {

    @Test
    public void test () {
        String password = "123456";
        String md5Password = DigestUtils.md5Hex(password);
        System.out.println(md5Password);
        // 402849d0675894d301675d3aa5f50170
        // e10adc3949ba59abbe56e057f20f883e

    }

    @Test
    public void test2 () {
        try {
            File file = new File("D:\\work_files\\excel\\test.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            InputStream in = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(in,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
