
package com.example.apoorva.myapplicationcalc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.*;
import android.os.*;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        final Button b1, b2, b3, bmul, b5;

        final Button b6, b7, bsub, b9, b4, b8, badd, bdiv, bdec, b0, beql;
        final TextView edt1;
        edt1 = findViewById(R.id.ed1);
        b7 = findViewById(R.id.but1);
        b8 = findViewById(R.id.but2);
        b9 = findViewById(R.id.but3);
        bmul = findViewById(R.id.but4);
        b4 = findViewById(R.id.but5);
        b5 = findViewById(R.id.but6);
        b6 = findViewById(R.id.but7);
        bsub = findViewById(R.id.but8);
        b1 = findViewById(R.id.but9);
        b2 = findViewById(R.id.but10);
        b3 = findViewById(R.id.but11);
        badd = findViewById(R.id.but12);
        bdiv = findViewById(R.id.but13);
        b0 = findViewById(R.id.but14);
        bdec = findViewById(R.id.but15);
        beql = findViewById(R.id.but16);
        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt1.setText(edt1.getText() + "1");
                                  }
                              }
        );
        b2.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt1.setText(edt1.getText() + "2");
                                  }
                              }
        );
        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt1.setText(edt1.getText() + "3");
                                  }
                              }
        );
        b4.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt1.setText(edt1.getText() + "4");
                                  }
                              }
        );
        b5.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt1.setText(edt1.getText() + "5");
                                  }
                              }
        );
        b6.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt1.setText(edt1.getText() + "6");
                                  }
                              }
        );
        b7.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt1.setText(edt1.getText() + "7");
                                  }
                              }
        );
        b8.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt1.setText(edt1.getText() + "8");
                                  }
                              }
        );
        b9.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt1.setText(edt1.getText() + "9");
                                  }
                              }
        );
        bmul.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        edt1.setText(edt1.getText() + "X");
                                    }
                                }
        );
        badd.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        String s1 = edt1.getText().toString();

                                        edt1.setText(edt1.getText() + "+");
                                    }
                                }

        );
        bsub.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {

                                        edt1.setText(edt1.getText() + "-");
                                    }
                                }
        );
        bdec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edt1.setText(edt1.getText() + ".");

            }


        });
        b0.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      edt1.setText(edt1.getText() + "0");
                                  }
                              }
        );
        bdiv.setOnClickListener(new View.OnClickListener() {


                                    public void onClick(View view) {

                                        edt1.setText(edt1.getText() + "/");
                                    }
                                }
        );

        beql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int b;
                //boolean b;
                String str = edt1.getText().toString();
              if(str.contains("..")||str.contains("++")||str.contains("--")||str.contains("**")||str.contains("//")||str.contains("+-")||str.contains("*-")||str.contains("/-")||str.contains("/+")||str.contains("/*")||str.contains("+++"))
              {
                    Toast.makeText(getApplicationContext(),"Invalid Expression",Toast.LENGTH_LONG).show();
              }


                 else {
                    double p1 = bodmas(str);
                    String p = Double.toString(p1);
                    edt1.setText(p);
                }
            }

     
        });
    }
    //bodmas
    static double bodmas(String equation){
        double result = 0.0;
        String noMinus = equation.replace("-", "+-");
        String[] byPluses = noMinus.split("\\+");//split by addition

        for (String multipl : byPluses) {
            String[] byMultipl = multipl.split("X");//split by multiplication
            double multiplResult = 1.0;
            for (String operand : byMultipl) {
                if (operand.contains("/")) {
                    String[] division = operand.split("\\/");//split by division
                    double divident = Double.parseDouble(division[0]);//division
                    for (int i = 1; i < division.length; i++) {
                        divident /= Double.parseDouble(division[i]);
                    }
                    multiplResult *= divident;//multiplication ke result me 1 1 karke multiply hoga
                } else {
                    multiplResult *= Double.parseDouble(operand);
                }
            }
            result += multiplResult;
        }

        return result;
    }


@Override
public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
        }

@Override
public boolean onOptionsItemSelected(MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id=item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==R.id.action_settings){
        return true;
        }

        return super.onOptionsItemSelected(item);
        }



}
