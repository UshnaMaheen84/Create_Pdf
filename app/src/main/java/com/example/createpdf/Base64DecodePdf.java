package com.example.createpdf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class Base64DecodePdf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base64_decode_pdf);

        String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(path, "test.pdf");

        try {
            FileOutputStream fos = new FileOutputStream(file);
//
//            String b64 = "MDAzODE2OTJfT1JEMDAwOTAwNzA0NDFfRFhC";
//
//            byte[] decoder = Base64.getDecoder().decode(b64);
//
//            fos.write(decoder);

            String b64 = "00381692_ORD00090070441_DXB";

            Base64.Encoder enc = Base64.getEncoder();
            Base64.Decoder dec = Base64.getDecoder();

            // encode data using BASE64
            String encoded = enc.encodeToString(b64.getBytes());
            Log.e("main", "encoded value is \t" + encoded);

            // Decode data
            String decoded = new String(dec.decode(encoded));
            System.out.println("decoded value is \t" + decoded);
            System.out.println("original value is \t" + b64);
            Log.e("main", "decoded value is \t" + decoded);
            Log.e("main", "original value is \t" + b64);

            Toast.makeText(this, "PDF File Saved", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("main", "error " + e.toString());

        }
    }

}