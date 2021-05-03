package com.example.createpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CreatePdf extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pdf);


        try {
            createPdf();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void createPdf() throws FileNotFoundException {

        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() ;
        File file = new File(path,"myPdf.pdf");
        OutputStream outputStream = new FileOutputStream(file);
        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document,outputStream);
            document.open();

            float [] pointColumnWidths = {150F, 150F, 150F};
            Table table = new Table(pointColumnWidths);

            // Adding cells to the table
            table.addCell(new Cell().add(new Paragraph("Name")));
            table.addCell(new Cell().add(new Paragraph("Rimsha")));
            table.addCell(new Cell().add(new Paragraph("Id")));
            table.addCell(new Cell().add(new Paragraph("1001")));
            table.addCell(new Cell().add(new Paragraph("Designation")));
            table.addCell(new Cell().add(new Paragraph("Programmer")));


        } catch (DocumentException e) {
            e.printStackTrace();
    }


}
}