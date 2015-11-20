package com.example.anhvu.t124996_nguyenanhvu_ass6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    EditText edtText;
    TextView txtView;
    Button btnre,btnin,btnout;
    private String Chuoi;
    private int size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtText=(EditText)findViewById(R.id.editText);
        txtView=(TextView)findViewById(R.id.textView2);
        btnre=(Button)findViewById(R.id.button);
        btnin=(Button)findViewById(R.id.button2);
        btnout=(Button)findViewById(R.id.button3);
        btnin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream in = getAssets().open("FileRead.txt");
                    size = in.available();
                    byte[]buffer=new byte[size];
                    in.read(buffer);
                    Chuoi=new String(buffer);
                    edtText.setText(Chuoi);
                    in.close();
                }catch (Exception e)
                {
                    edtText.setText("Invalid Input");
                }
            }
        });
        btnre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    int sum=0;
                    String[] num;
                    num=new String[size];
                    num=Chuoi.split("[\n,]");
                    for(int i=0;i<num.length;i++)
                    {
                        sum+=Integer.parseInt(num[i].trim().toString());
                    }
                    txtView.setText("" + sum);
            }
        });
    }
}
