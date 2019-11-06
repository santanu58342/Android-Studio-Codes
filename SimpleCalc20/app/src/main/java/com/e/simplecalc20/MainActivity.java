package com.e.simplecalc20;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,div,mul,add,sub,equal,zero,clear,dot,ca;
    TextView screen,output;
    String exp;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen=findViewById(R.id.input);
        output=findViewById(R.id.output);
        b1=findViewById(R.id.btnOne);
        b2=findViewById(R.id.btnTwo);
        b3=findViewById(R.id.btnThree);
        b4=findViewById(R.id.btnFour);
        b5=findViewById(R.id.btnFive);
        b6=findViewById(R.id.btnSix);
        b7=findViewById(R.id.btnSeven);
        b8=findViewById(R.id.btnEight);
        b9=findViewById(R.id.btnNine);
        div=findViewById(R.id.btnDivide);
        mul=findViewById(R.id.btnMultiply);
        add=findViewById(R.id.btnAdd);
        sub=findViewById(R.id.btnSubtract);
        equal=findViewById(R.id.btnEqual);
        zero=findViewById(R.id.btnZero);
        clear=findViewById(R.id.btnClear);
        dot=findViewById(R.id.btnDot);
        ca=findViewById(R.id.ca);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(b1.getText());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(b2.getText());
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(b3.getText());
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(b4.getText());
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(b5.getText());
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(b6.getText());
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(b7.getText());
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(b8.getText());
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(b9.getText());
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screen.getText().length()!=0)
                {
                    screen.append(add.getText());
                }

            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screen.getText().length()!=0)
                {
                    screen.append(sub.getText());
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screen.getText().length()!=0)
                {
                    screen.append(mul.getText());
                }

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screen.getText().length()!=0)
                {
                    screen.append(div.getText());
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(dot.getText());
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(zero.getText());
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    output.setText(null);
                String str = screen.getText().toString();
                if (str.length() > 1)
                {
                    str = str.substring(0, str.length() - 1);
                    screen.setText(str);
                }
                else if (str.length() <= 1)
                {
                    screen.setText(null);
                }
            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                try {
                    if (screen.getText().length() != 0)
                        {
                        exp = screen.getText().toString();
                        Expression expression = new ExpressionBuilder(exp).build();
                        double result = expression.evaluate();
                        output.setText(Double.toString(result));
                        }
                    }
                    catch (IllegalArgumentException i)
                    {
                        Toast.makeText(MainActivity.this, "Invalid Syntax", Toast.LENGTH_SHORT).show();
                    }
                    catch (ArithmeticException e)
                    {
                        Toast.makeText(MainActivity.this, ""+e, Toast.LENGTH_SHORT).show();
                    }
            }
        });

        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exp=exp+output.getText();
                screen.setText(output.getText());
            }
        });
    }

}
