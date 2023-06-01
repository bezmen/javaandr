package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    SeekBar  seekBar;
    TextView MyTv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner =findViewById(R.id.spinner);
        Spinner spinner1=findViewById(R.id.spinner2);


        ArrayAdapter<CharSequence> adapter1=ArrayAdapter.createFromResource(this,R.array.numbers2, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.numbers, android.R.layout.simple_spinner_item);


        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



        seekBar=findViewById(R.id.seekBar);
        seekBar.setMax(100000);
        MyTv=findViewById(R.id.MyTv);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MyTv.setVisibility(View.VISIBLE);
                MyTv.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void Onclik(View view)
    {

        TextView resultText = findViewById(R.id.MyTv);
        TextView priceText = findViewById(R.id.editTextText);
        TextView textView6 = findViewById(R.id.textView6);
        Spinner spiner2= findViewById(R.id.spinner2);
        double price = Double.parseDouble(priceText.getText().toString()) * ((double) Integer.parseInt(resultText.getText().toString()) * 12) * 365;
        textView6.setText("Рублей в месяц: " +Double.toString(price)+" Под: "+priceText.getText().toString()+"%"+" На: "+spiner2.getSelectedItem().toString());
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}



