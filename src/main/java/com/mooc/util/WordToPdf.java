package com.mooc.util;

//import com.aspose.words.Document;
//import com.aspose.words.SaveFormat;

public class WordToPdf {
    /**
     * 将word转换为pdf
     * @param docPath
     * @param pdfPath
     */
    public static void docToPdf (String docPath, String pdfPath) {
//        try {
//            Document doc = new Document(docPath);
//            doc.save(pdfPath,SaveFormat.PDF);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        String docPath = "D:\\work_files\\excel\\zhuanli.docx";
        String pdfPath = "D:\\\\work_files\\\\excel\\\\zhuanli.PDF";
        docToPdf(docPath,pdfPath);
    }
}
