package com.bootdo.testDemo;

import com.alibaba.fastjson.JSON;
import com.bootdo.common.utils.ExcelUtil;
import com.bootdo.entity.AttenEntity;
import com.bootdo.entity.CwaEntity;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.bootdo.common.utils.ExcelUtil.getWorkbok;


public class TestDemo {


    /**
     * 读取POI excel
     */
    @Test
    public void testPoiReadExcel(){
        try {
            // 同时支持Excel 2003、2007
            File excelFile = new File("d:/员工出勤.xlsx"); // 创建文件对象
            FileInputStream in = new FileInputStream(excelFile); // 文件流
            ExcelUtil.checkExcelVaild(excelFile);
            Workbook workbook = ExcelUtil.getWorkbok(in,excelFile);
            //Workbook workbook = WorkbookFactory.create(is); // 这种方式 Excel2003/2007/2010都是可以处理的

            int sheetCount = workbook.getNumberOfSheets(); // Sheet的数量

            System.out.println("sheetCount:"+sheetCount);
            //月份
            String month=null;
            //人员姓名
            String name=null;
            //出勤
            AttenEntity attenEntity=null;

            CwaEntity cwaEntity=null;

            List<CwaEntity> cwaEntityList=new ArrayList();
            for(int x=0;x<sheetCount;x++) {

                Sheet sheet = workbook.getSheetAt(x);

                for (Row row : sheet) {
                    if(row.getRowNum()==0){
                        //读月份
                        month =(String)ExcelUtil.getValue(row.getCell(1));

                        System.out.println("month:"+month);
                    }else{

                        attenEntity=new AttenEntity();
                        attenEntity.setMonth(month);
                        //读次数
                        attenEntity.setCount((Double)ExcelUtil.getValue(row.getCell(1)));
                        name=ExcelUtil.getValue(row.getCell(0)).toString();

                        boolean tf=false;
                        for(int i=0;i<cwaEntityList.size();i++){
                            // 如果整个人存在list中，只加出勤对象
                            if(cwaEntityList.get(i).getSname().equals(name)){
                                cwaEntityList.get(i).getAttenList().add(attenEntity);
                                tf=true;
                            }
                        }

                        if(tf==false){
                            cwaEntity=new CwaEntity();
                            //读人员
                            cwaEntity.setSname(ExcelUtil.getValue(row.getCell(0)).toString());
                            cwaEntity.getAttenList().add(attenEntity);
                            cwaEntityList.add(cwaEntity);
                        }

                    }
                }
            }

            String json= JSON.toJSONString(cwaEntityList);

            System.out.println(json);

            //创建 title
            Sheet sheet = workbook.createSheet();
            Row row = sheet.createRow(0);
            row.createCell(0).setCellValue("姓名");





            //动态创建 月份头
            Integer monthsize=cwaEntityList.get(0).getAttenList().size();
            for(int i=0;i<monthsize;i++){
                row.createCell(i+1).setCellValue(cwaEntityList.get(0).getAttenList().get(i).getMonth());
            }
            //动态创建姓名数据,动态创建月份数据

            //动态创建姓名

            for(int i=0;i<cwaEntityList.size();i++){
                //动态创建姓名
                row = sheet.createRow(i+1);
                row.createCell(0).setCellValue(cwaEntityList.get(i).getSname());

                for(int x=0;x<cwaEntityList.get(i).getAttenList().size();x++) {

                    //动态创建月次数
                    row.createCell(x+1).setCellValue(cwaEntityList.get(i).getAttenList().get(x).getCount());

                }


            }


            //workbook.setSheetName(2, "信息");
            try {
                File file = new File("d:/员工出勤.xlsx");
                FileOutputStream fileoutputStream = new FileOutputStream(file);
                workbook.write(fileoutputStream);
                fileoutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }




        } catch (Exception e) {
            e.printStackTrace();
        }



    }



}
