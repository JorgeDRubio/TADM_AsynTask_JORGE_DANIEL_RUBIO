package com.example.jorge.tadm_asyntask_jorge_daniel_rubio;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText numero1, numero2;
    Button boton1, boton2;
    ProgressBar progress1, progress2;
    private Handler handler = new Handler();
    private int i,prog1,prog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1=findViewById(R.id.editTextDat1);
        numero2=findViewById(R.id.editTextDat2);
        boton1=findViewById(R.id.buttonCon1);
        boton2=findViewById(R.id.buttonCon2);
        progress1= findViewById(R.id.progressBar1);
        progress2=findViewById(R.id.progressBar2);

        boton1.setOnClickListener(MainActivity.this);
        boton2.setOnClickListener(MainActivity.this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonCon1:
                hilos1();
                break;

            case R.id.buttonCon2:


                hilos2();

                break;
        }
    }

    private void UnSegundo() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hilos2() {
        final int  num2;
        num2 = Integer.parseInt(numero2.getText().toString());




        new Thread(new Runnable() {
            @Override
            public void run() {

                while (prog2 < num2){
                    prog2 += 1;

                    UnSegundo();

                    handler.post(new Runnable() {

                        public void run() {
                            progress2.setProgress(prog2);

                            Toast.makeText(getBaseContext(), "Tarea ejecutandose", Toast.LENGTH_LONG).show();
                            progress2.setMax(num2);
                        }




                    });
                }
            }


        }).start();
    }
    public void hilos1() {
        final int  num1;
        num1 = Integer.parseInt(numero1.getText().toString());




        new Thread(new Runnable() {
            @Override
            public void run() {
                while (prog1 < num1){
                    prog1 += 1;

                    UnSegundo();

                    handler.post(new Runnable() {

                        public void run() {
                            progress1.setProgress(prog1);

                            Toast.makeText(getBaseContext(), "Tarea ejecutandose", Toast.LENGTH_LONG).show();
                            progress1.setMax(num1);
                        }




                    });
                }
            }


        }).start();
    }

}
