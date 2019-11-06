package com.example.santanu.day9_4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button ten;
    Button plus;
    Button minus;
    Button divide;
    Button multiply;
    Button equal;
    EditText data;

    boolean flag=true;

    float data1;
    float data2;
    float data3;
    float data4;
    float data5;
    float data6;
    float data7;
    float data8;
    float data9;
    float data0;
    float value1;
    float value2;

    String lastButton;

    private void numberHandler(String num){
        if (flag)
            data.append(num);
        else{
            data.setText(num);
            flag=true;
        }
    }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = (EditText) findViewById(R.id.editText1);
        one = (Button) findViewById(R.id.button9);
        two = (Button) findViewById(R.id.button8);
        three = (Button) findViewById(R.id.button7);
        four = (Button) findViewById(R.id.button6);
        five = (Button) findViewById(R.id.button5);
        six = (Button) findViewById(R.id.button4);
        seven = (Button) findViewById(R.id.button3);
        eight = (Button) findViewById(R.id.button2);
        nine = (Button) findViewById(R.id.button1);
        ten = (Button) findViewById(R.id.button10);
        plus = (Button) findViewById(R.id.button11);
        minus = (Button) findViewById(R.id.button12);
        divide = (Button) findViewById(R.id.button14);
        multiply = (Button) findViewById(R.id.button13);
        equal = (Button) findViewById(R.id.button15);

        one.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//				data.append("1");
                numberHandler("1");
            }
        });

        two.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//				data.append("2");
                numberHandler("2");
            }
        });
        three.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//				data.append("3");
                numberHandler("3");
            }
        });
        four.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//				data.append("4");
                numberHandler("4");
            }
        });
        five.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//				data.append("5");
                numberHandler("5");
            }
        });
        six.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//				data.append("6");
                numberHandler("6");
            }
        });
        seven.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//				data.append("7");
                numberHandler("7");
            }
        });
        eight.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//				data.append("8");
                numberHandler("8");
            }
        });
        nine.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//				data.append("9");
                numberHandler("9");
            }
        });
        ten.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
//				data.append("0");
                numberHandler("0");
            }
        });
        plus.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                lastButton = (String) plus.getText();
                value1 = Float.valueOf(data.getText().toString());
                data.setText("");
            }
        });
        minus.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                lastButton = (String) minus.getText();
                value1 = Float.valueOf(data.getText().toString());
                data.setText("");
            }
        });
        divide.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                lastButton = (String) divide.getText();
                value1 = Float.valueOf(data.getText().toString());
                data.setText("");
            }
        });
        multiply.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                lastButton = (String) multiply.getText();
                value1 = Float.valueOf(data.getText().toString());
                data.setText("");
            }
        });

        equal.setOnClickListener(new OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                value2 = Float.valueOf(data.getText().toString());
                float info;
                if (lastButton.equals("+")) {
                    info = value1 + value2;
                    data.setText(String.valueOf(info));
                }
                if (lastButton.equals("-")) {
                    info = value1 - value2;
                    data.setText(String.valueOf(info));
                }
                if (lastButton.equals("X")) {
                    info = value1 * value2;
                    data.setText(String.valueOf(info));
                }
                if (lastButton.equals("/")) {
                    info = value1 / value2;
                    data.setText(String.valueOf(info));
                }
                flag=false;
            }
        });
    }
}