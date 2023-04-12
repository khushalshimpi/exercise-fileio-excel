package org.example;

import jxl.*;
import jxl.write.*;

import java.io.File;
import java.io.IOException;

class Student{
    String name;
    String subject;
    int marks;
    public Student(String name, String subject, int marks){
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }
}
public class ExcelExample {

    public static void main(String[] args) {
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("File1.xls"));
            WritableSheet sheet = workbook.createSheet("Sheet 1", 0);

            WritableCell cellName = new Label(0, 0, "Name");
            WritableCell cellSubject = new Label(1, 0, "Subject");
            WritableCell cellMarks = new Label(2, 0, "Marks");

            Student s1 = new Student("Khushal", "Math", 90);

            WritableCell cell1 = new Label(0, 1, s1.name);
            WritableCell cell2 = new Label(1, 1, s1.subject);
            WritableCell cell3 = new Label(2, 1, ""+s1.marks);


            sheet.addCell(cellName);
            sheet.addCell(cellSubject);
            sheet.addCell(cellMarks);

            sheet.addCell(cell1);
            sheet.addCell(cell2);
            sheet.addCell(cell3);


            workbook.write();
            workbook.close();


        } catch (IOException | WriteException e) {
            throw new RuntimeException(e);
        }

    }

}