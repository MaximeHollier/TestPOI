package com.afpa;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Excell {

    private String fileName;

    public Excell(String url)
    {
        this.fileName = url;
    }

    public ArrayList<Integer> compterPr() throws IOException
    {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(new File(this.fileName));

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.rowIterator();

        Integer cpt ;
        while (rowIterator.hasNext())
        {
            cpt=0;
            Row row = rowIterator.next();

            Iterator<Cell> cellIterator = row.cellIterator();

            while(cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                String cellValue = new DataFormatter().formatCellValue(cell);
                if(cellValue.equals("PR")){cpt++;}

            }
            arrayList.add(cpt);

        }
        return arrayList;
    }
}
