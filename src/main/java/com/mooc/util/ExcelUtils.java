package com.mooc.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public static void exportExcel (String fileName) throws Exception{
        //创建工作簿
        XSSFWorkbook wb = new XSSFWorkbook();
        //创建一个sheet
        XSSFSheet sheet = wb.createSheet();

        // 创建单元格样式
        XSSFCellStyle style =  wb.createCellStyle();
//        style.setFillForegroundColor((short)4); //设置要添加表格北京颜色
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND); //solid 填充
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER); //文字水平居中
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//文字垂直居中
        style.setBorderBottom(BorderStyle.THIN); //底边框加黑
        style.setBorderLeft(BorderStyle.THIN);  //左边框加黑
        style.setBorderRight(BorderStyle.THIN); // 有边框加黑
        style.setBorderTop(BorderStyle.THIN); //上边框加黑
        //为单元格添加背景样式
        for (int i = 0; i < 6; i++) { //需要6行表格
            Row row =	sheet.createRow(i); //创建行
            for (int j = 0; j < 6; j++) {//需要6列
                row.createCell(j).setCellStyle(style);
            }
        }


        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, 0));//合并单元格，cellRangAddress四个参数，第一个起始行，第二终止行，第三个起始列，第四个终止列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 1, 5));
        sheet.addMergedRegion(new CellRangeAddress(6,6,0,5));

        //tian入数据
        XSSFRow row = sheet.getRow(0); //获取第一行
        row.getCell(1).setCellValue("2018期末考试"); //在第一行中创建一个单元格并赋值
        XSSFRow row1 = sheet.getRow(1); //获取第二行，为每一列添加字段
        row1.getCell(1).setCellValue("语文");
        row1.getCell(2).setCellValue("数学");
        row1.getCell(3).setCellValue("英语");
        row1.getCell(4).setCellValue("物理");
        row1.getCell(5).setCellValue("化学");
        XSSFRow row2 = sheet.getRow(2); //获取第三行
        row2.getCell(0).setCellValue("张三");
        XSSFRow row3 = sheet.getRow(3); //获取第四行
        row3.getCell(0).setCellValue("张三");
        XSSFRow row4 = sheet.getRow(4); //获取第五行
        row4.getCell(0).setCellValue("张三");
        XSSFRow row5 = sheet.getRow(5); //获取第五行
        row5.getCell(0).setCellValue("张三");
        XSSFRow row6 = sheet.getRow(6);
        row6.getCell(1).setCellValue("END");
        //将数据写入文件
        String excelPath = "D:\\work_files\\excel\\score.xls";
        FileOutputStream out = new FileOutputStream(excelPath);
        wb.write(out);
    }

    /**
     * 获取Workbook对象
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkBook (File file) throws IOException {
        Workbook wk = null;
        FileInputStream inputStream = new FileInputStream(file);
        if (file.getName().endsWith("xls")) {
            wk = new HSSFWorkbook(inputStream);
        } else if (file.getName().endsWith("xlsl")) {
            wk = new XSSFWorkbook(inputStream);
        }
        return wk;
    }

    /**
     * 从Excel中读取数据
     * @param inFilePath
     * @param outFilePath
     * @throws Exception
     */
    public static void readExcel (String inFilePath, String outFilePath) throws Exception {
        File file = new File(inFilePath);
        Workbook wk =getWorkBook(file);
        // getSheetAt(0)根据索引来指定使用哪一个sheet;
        // getSheet("sheetname"):根据sheet名称来指定哪一个sheet
//        Sheet sheet = wk.getSheetAt(0);
        Sheet sheet = wk.getSheet("score");
        // 获取Excel的行数
        int rowsNum = sheet.getLastRowNum();
        System.out.println(rowsNum);
        for (int i = 1; i <= rowsNum; i++) {
            // 获取当前行
            Row row = sheet.getRow(i);
            // 获取最后一列的索引，就是列数
            int colsNum = row.getLastCellNum();
            //获取一行数据中的哪一列
//            for (int j = 0; j < colsNum; j++) {
//                Cell cell = row.getCell(j);
//                String value = String.valueOf(cell);
//                System.out.print(value+" ");
//            }
//            System.out.println();
            Cell cell = row.getCell(1);
            String value = String.valueOf(cell);
            System.out.println(value);
            // 将值插入到Excel
            Cell cell2 = row.getCell(2);
            if (cell2 == null) {
                // 如果获取到的列为空，则新建一列
                cell2 = row.createCell(2);
            }
            cell2.setCellValue(value+"abc");
            FileOutputStream out = new FileOutputStream(inFilePath);
            wk.write(out);
        }
    }

    public static void writeExcel (String colum) throws Exception {
        XSSFWorkbook wk = new XSSFWorkbook();
        XSSFSheet sheet = wk.createSheet();
    }


    public static void main(String[] args) {
        String inFilePath = "D:\\work_files\\score.xls";
        try {
//            exportExcel("n");
            readExcel(inFilePath,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
