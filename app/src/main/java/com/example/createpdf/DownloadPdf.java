package com.example.createpdf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadPdf extends AppCompatActivity {

    Button download_pdf;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_pdf);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        download_pdf = findViewById(R.id.download_pdf);


        download_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DownloadPdf.this, "Please wait file is downloading.", Toast.LENGTH_LONG).show();

                downloadPdfContent();

            }
        });

    }

    public void downloadPdfContent() {

        try {
            String urlToDownload = "https://app.saudigerman.com/LabReport?DocId=MDAzODE2OTJfT1JEMDAwOTAwNzA0NDFfRFhC";

//           download pdf file.

            URL url = new URL(urlToDownload);
            HttpURLConnection c = (HttpURLConnection) url.openConnection();

            c.connect();

            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
            File file = new File(path, "abc.pdf");
            FileOutputStream fos = new FileOutputStream(file);
            InputStream is = c.getInputStream();
            byte[] buffer = new byte[1024];
            int len1 = 0;
            while ((len1 = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len1);
            }
            fos.close();
            is.close();
            Log.e("main", "--pdf downloaded--ok--" + urlToDownload);

            viewPdf(file);

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("main", "error " + e.toString());

        }
    }

    private void viewPdf(File file) {

        Uri path = FileProvider.getUriForFile(DownloadPdf.this,
                BuildConfig.APPLICATION_ID + ".provider", file);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        pdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        pdfIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);


        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toast.makeText(DownloadPdf.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }

    }

}