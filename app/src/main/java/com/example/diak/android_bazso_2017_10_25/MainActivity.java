package com.example.diak.android_bazso_2017_10_25;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_plus, btn_minus, btn_send;

    private TextView number;

    private ImageView imgV_health1, imgV_health2, imgV_health3, imgV_health4, imgV_health5;

    private int tippelt_szam = 0, kitalalando_szam = 0;

    private int vizsgal = 5;

    private AlertDialog.Builder alert_nyert; //felszólító ablak készítése
    private AlertDialog.Builder alert_vesztett;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        alert_nyert = new AlertDialog.Builder(MainActivity.this);

        alert_nyert.setTitle("Gratulálok nyertél!")
        .setMessage("Újra akarod kezdeni a játékot?")
        .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                finish();
            }
        })

       .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                new_game();

            }
        })

        .setCancelable(false)
        .create();

        alert_vesztett = new AlertDialog.Builder(MainActivity.this);
        alert_vesztett.setTitle("Vesztettél")
        .setMessage("Újra akarod kezdeni a játékot?")
                .setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })

                .setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        new_game();

                    }
                })

                .setCancelable(false)
                .create();

        Random rnd = new Random();

        kitalalando_szam = rnd.nextInt(50)+1;

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tippelt_szam < 50){
                    tippelt_szam++;
                }
                number.setText(" " + tippelt_szam);
            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tippelt_szam>0){
                    tippelt_szam--;
                }
                number.setText(" " + tippelt_szam);
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippelt_szam == kitalalando_szam)
                {
                    Toast.makeText(MainActivity.this, "Nyertél", Toast.LENGTH_LONG).show();
                    alert_nyert.show();

                } else if (tippelt_szam > kitalalando_szam)
                {
                    Toast.makeText(MainActivity.this, "Lejjebb", Toast.LENGTH_LONG).show();
                    heart_off();

                } else if (tippelt_szam < kitalalando_szam)
                {
                    Toast.makeText(MainActivity.this, "Fejlebb", Toast.LENGTH_LONG).show();
                    heart_off();

                }

                number.setText(" " + tippelt_szam);

            }
        });

    }
        public void init(){

            btn_plus = (Button) findViewById(R.id.button_plus);
            btn_minus = (Button) findViewById(R.id.button_minus);
            btn_send = (Button) findViewById(R.id.button_send);

            number = (TextView) findViewById(R.id.textView_szam);

            imgV_health1 = (ImageView) findViewById(R.id.imageView_hearth1);
            imgV_health2 = (ImageView) findViewById(R.id.imageView_hearth2);
            imgV_health3 = (ImageView) findViewById(R.id.imageView_hearth3);
            imgV_health4 = (ImageView) findViewById(R.id.imageView_hearth4);
            imgV_health5 = (ImageView) findViewById(R.id.imageView_hearth5);

        }

        public void new_game(){

            Random rnd = new Random();

            kitalalando_szam = rnd.nextInt(50)+1;
            tippelt_szam = 0;


            vizsgal = 5;
            imgV_health1.setBackgroundResource(R.drawable.heart2);
            imgV_health2.setBackgroundResource(R.drawable.heart2);
            imgV_health3.setBackgroundResource(R.drawable.heart2);
            imgV_health4.setBackgroundResource(R.drawable.heart2);
            imgV_health5.setBackgroundResource(R.drawable.heart2);


        }

    public void heart_off() {


        if (vizsgal == 1) {

            imgV_health1.setBackgroundResource(R.drawable.heart1);
            vizsgal--;
            alert_vesztett.show();
        }

        else if (vizsgal == 2) {

            imgV_health2.setBackgroundResource(R.drawable.heart1);
            vizsgal--;

        }

        else if (vizsgal == 3) {

            imgV_health3.setBackgroundResource(R.drawable.heart1);
            vizsgal--;

        }

        else if (vizsgal == 4) {

            imgV_health4.setBackgroundResource(R.drawable.heart1);
            vizsgal--;

        }

        else if (vizsgal == 5) {

            imgV_health5.setBackgroundResource(R.drawable.heart1);
            vizsgal--;
        }


    }

}




