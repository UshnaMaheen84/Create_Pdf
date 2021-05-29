package com.example.createpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Text;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
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

        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(path, "myPdf.pdf");
        OutputStream outputStream = new FileOutputStream(file);
        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();


            float[] columnWidths1 = {50, 50};

            PdfPTable table1 = new PdfPTable(columnWidths1);

            PdfPCell c4 = new PdfPCell(new Phrase("HOSPITAL NAME"));
            c4.setHorizontalAlignment(Element.ALIGN_LEFT);
            c4.setBorder(Rectangle.NO_BORDER);
            table1.addCell(c4);
            c4 = new PdfPCell(new Phrase("INVOICE"));
            c4.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c4.setBorder(Rectangle.NO_BORDER);
            table1.addCell(c4);
            c4 = new PdfPCell(new Phrase(" "));
            c4.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c4.setBorder(Rectangle.NO_BORDER);
            table1.addCell(c4);
            c4 = new PdfPCell(new Phrase("Invoice #: [1234]"));
            c4.setHorizontalAlignment(Element.ALIGN_RIGHT);
            c4.setBorder(Rectangle.NO_BORDER);
            table1.addCell(c4);

            float[] columnWidths = {90, 120, 90, 120};

            PdfPTable table = new PdfPTable(columnWidths);
            PdfPCell c1 = new PdfPCell(new Phrase("PATIENT AND HOSPITAL DETAILS"));
            c1.setColspan(4);
            PdfPCell c2 = new PdfPCell(new Phrase(" "));
            c2.setColspan(3);

            table.addCell(c1);
            table.addCell("Patient Name");
            table.addCell(" ");
            table.addCell("Consultant");
            table.addCell(" ");
            table.addCell("Patient Age");
            table.addCell(" ");
            table.addCell("Bed No");
            table.addCell(" ");
            table.addCell("Address");
            table.addCell(c2);
            table.addCell("Addmission Date");
            table.addCell(" ");
            table.addCell("Discharge Date");
            table.addCell(" ");

            float[] columnWidths2 = {50, 150, 90, 100, 100};

            PdfPTable table2 = new PdfPTable(columnWidths2);
            table2.addCell("SR#");
            table2.addCell("PARTICULARS");
            table2.addCell("RATE");
            table2.addCell("DISCOUNT");
            table2.addCell("AMOUNT");

            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");

            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");

            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");

            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");

            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");

            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");

            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");

            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");
            table2.addCell(" ");


            float[] columnWidths3 = {50, 100, 90, 100, 100};

            PdfPTable table3 = new PdfPTable(columnWidths3);
            PdfPCell c3 = new PdfPCell(new Phrase(" "));
            c3.setColspan(3);
            c3.setBorder(Rectangle.RIGHT);

            table3.addCell(c3);
            table3.addCell("SUBTOTAL");
            table3.addCell(" ");
            table3.addCell(c3);
            table3.addCell("TAX RATE");
            table3.addCell(" ");
            table3.addCell(c3);
            table3.addCell("TAX");
            table3.addCell(" ");
            table3.addCell(c3);
            table3.addCell("TOTAL");
            table3.addCell(" ");

            table3.addCell(c3);


            document.add(table1);
            document.add(new Paragraph("\n\n"));

            document.add(table);
            document.add(new Paragraph("\n"));

            document.add(table2);
            document.add(table3);

            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
}