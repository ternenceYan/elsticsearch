package com.mooc.util;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.xwpf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;

public class PDFUtils {

    private static Logger log = LoggerFactory.getLogger(PDFUtils.class);

    /**
     * PDF 生成
     *
     * @param filePath 生成文件路径
     */
    public static void createPdf(String filePath) {
        log.info("########开始生成PDF#########");
        com.itextpdf.text.Document document = new com.itextpdf.text.Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();
            document.add(new Paragraph("hello world!!!"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        log.info("########生成PDF结束#########");

    }

    /**
     * 生成word
     * @param filePath
     */
    public static void createWord(String filePath) {
        log.info("######=开始生成word########");
        try {

            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            XWPFDocument doc = new XWPFDocument();
            XWPFParagraph xp = doc.createParagraph();
            xp.setAlignment(ParagraphAlignment.CENTER);
            xp.setBorderBottom(Borders.DOUBLE);
            xp.setBorderTop(Borders.DOUBLE);

            xp.setBorderRight(Borders.DOUBLE);
            xp.setBorderLeft(Borders.DOUBLE);
            xp.setBorderBetween(Borders.SINGLE);

            xp.setVerticalAlignment(TextAlignment.TOP);

            XWPFRun r1 = xp.createRun();
            r1.setBold(true);
            r1.setText("The quick brown fox");
            r1.setBold(true);
            r1.setFontFamily("Courier");
            r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
            r1.setTextPosition(100);

            XWPFParagraph p2 = doc.createParagraph();
            p2.setAlignment(ParagraphAlignment.RIGHT);

            //BORDERS
            p2.setBorderBottom(Borders.DOUBLE);
            p2.setBorderTop(Borders.DOUBLE);
            p2.setBorderRight(Borders.DOUBLE);
            p2.setBorderLeft(Borders.DOUBLE);
            p2.setBorderBetween(Borders.SINGLE);

            XWPFRun r2 = p2.createRun();
            r2.setText("jumped over the lazy dog");
//            r2.setStrike(true);
            r2.setFontSize(20);

            XWPFRun r3 = p2.createRun();
            r3.setText("and went away");
            r3.setStrike(true);
            r3.setFontSize(20);
            r3.setSubscript(VerticalAlign.SUPERSCRIPT);


            XWPFParagraph p3 = doc.createParagraph();
            p3.setWordWrap(true);
            p3.setPageBreak(true);

            //p3.setAlignment(ParagraphAlignment.DISTRIBUTE);
            p3.setAlignment(ParagraphAlignment.BOTH);
            p3.setSpacingLineRule(LineSpacingRule.EXACT);

            p3.setIndentationFirstLine(600);


            XWPFRun r4 = p3.createRun();
            r4.setTextPosition(20);
            r4.setText("我很帅啊");
            r4.addBreak(BreakType.PAGE);
            r4.setText("信息接口");
            r4.setItalic(true);
            //This would imply that this break shall be treated as a simple line break, and break the line after that word:

            XWPFRun r5 = p3.createRun();
            r5.setTextPosition(-10);
            r5.setText("有这里吧");
            r5.addCarriageReturn();
            r5.setText("测试");
            r5.addBreak();
            r5.setText("地方");

            r5.addBreak(BreakClear.ALL);
            r5.setText("呀,最后一页");

            FileOutputStream out = new FileOutputStream(filePath);
            doc.write(out);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("######=生成word结束########");
    }

    public static void main(String[] args) {
//        createPdf("D:\\work_files\\excel\\helloWord.PDF");
        createWord("D:\\work_files\\excel\\helloWord.docx");
    }
}
