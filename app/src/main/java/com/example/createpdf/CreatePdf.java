package com.example.createpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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

            PdfPTable table = new PdfPTable();
            float [] pointColumnWidths = {150F, 150F, 150F};
            Table table = new Table(pointColumnWidths);

            // Adding cells to the table
            table.addCell(new Cell().add("Name"));
            table.addCell(new Cell().add("Rimsha"));
            table.addCell(new Cell().add("Id"));
            table.addCell(new Cell().add("1001"));
            table.addCell(new Cell().add("Designation"));
            table.addCell(new Cell().add("Programmer"));

        } catch (DocumentException e) {
            e.printStackTrace();
    }

//    private void createPdfa() throws FileNotFoundException {
//
//        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString() ;
//        File file = new File(path,"myPdf.pdf");
//        OutputStream outputStream = new FileOutputStream(file);
//
//        PdfWriter writer = new PdfWriter(file);
//        PdfDocument pdfDocument = new PdfDocument(writer);
//        Document document = new Document(pdfDocument);
//    }
}
}