package pl.solutionit.mnozenie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.View.*;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Boolean flaga= true;
    Runne mRun = new Runne();
    Thread  watek = new Thread(mRun);
    Button los, spr, b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, backspace, enter;
    TextView tekst, pochwala, time;
    EditText wynik;
    String result, podaj = "";
    Integer ij, x, pom1, pom2;
    ProgressBar progressBar;
    long start, stop;
    int[] TEST = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        los = (Button) findViewById(R.id.button);
        los.setEnabled(false);
        spr = (Button) findViewById(R.id.enter);
        tekst = (TextView) findViewById(R.id.viewTekst);
        pochwala = (TextView) findViewById(R.id.textView2);
        time = (TextView) findViewById(R.id.time);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        b5 = (Button) findViewById(R.id.b5);
        b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);
        b8 = (Button) findViewById(R.id.b8);
        b9 = (Button) findViewById(R.id.b9);
        backspace = (Button) findViewById(R.id.b_back);
        b0 = (Button) findViewById(R.id.b0);
        enter = (Button) findViewById(R.id.enter);
        tekst.setText("Dzień dobry");
        wynik = (EditText) findViewById(R.id.iloczyn);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tekst.setText(losuj());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        backspace.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj="";
                wynik.setText(podaj);
            }
        });
        b0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+0;
                wynik.setText(podaj);
            }
        });
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+1;
                wynik.setText(podaj);
            }
        });
        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+2;
                wynik.setText(podaj);
            }
        });
        b3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+3;
                wynik.setText(podaj);
            }
        });
        b3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+3;
                wynik.setText(podaj);
            }
        });
        b4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+4;
                wynik.setText(podaj);
            }
        });
        b5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+5;
                wynik.setText(podaj);
            }
        });
        b6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+6;
                wynik.setText(podaj);
            }
        });
        b7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+7;
                wynik.setText(podaj);
            }
        });
        b8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+8;
                wynik.setText(podaj);
            }
        });
        b9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                podaj = podaj+9;
                wynik.setText(podaj);
            }
        });
        los.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                tekst.setText(losuj());
                podaj="";
                wynik.setText(podaj);

            }
        });
      /*  time.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                time.setText(mTime());
            }
        });*/

        spr.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
             //   time.setText(mTime().);
                //double czas = (start-stop)/1000.0;
                stop = System.currentTimeMillis();
                time.setText(mTime());
                watek.interrupt();
               flaga = false;
                setButtonEnable(los, true);
                result = wynik.getText().toString();
                //  pochwala.setText(result +"="+ ij);
                pom1 = Integer.parseInt(result);
                if (pom1>100) {
                    pochwala.setText("wynik z przedziału <0, 100>");
                }
                else if(Integer.parseInt(result)==ij){
                    pochwala.setText(pom1 +" = "+ ij+" BRAWO!!");
                }
                else{
                    pochwala.setText(pom1 +" NIE RÓWNA SIĘ "+ ij+" ŹLE");
                }

            }
        });

    }

    public String losuj() {
        String str = "";
        
        start = System.currentTimeMillis();
        TEST = generuj(2, 10);
        ij = TEST[0] * TEST[1];
        if (ij>30){
            str = "trzymam kciuki";
        }
        else{
            str = TEST[0] +"*"+ TEST[1];
        }

        //if(watek.isInterrupted()) {

            try {
                progressBar.setProgress(0);
                watek.start();
                //flaga =true;
    /* */   } catch (IllegalThreadStateException e) {
    /* */       e.printStackTrace();
    /* */      // str ="xxxxx";
            }
        //}


        return str;
    }
    public String mTime(){

        double czas = (stop - start);
        return String.valueOf(czas);

    }

    public class Runne implements Runnable {
        // public class Watek extends Thread{
        //Thread watek = new Thread(new Runnable() {
       // int i = 0;
        @Override
        public void run() {
            while (flaga) {
                try {
                   for (int i = 0; i <= 100; i++) {
                        progressBar.setProgress(i);
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                    //e.printStackTrace();
                    //  Thread.currentThread().interrupt();
                }
            }
        }
    }

    public int[] generuj(int min, int max) {
        Random generator = new Random();
        int[] tab = new int[2];
        tab[0] = generator.nextInt((max-min)+1)+min;
        tab[1] = generator.nextInt((max-min)+1)+min;
        return tab;
    }
    public void setButtonEnable(Button b, Boolean bol){
        b.setEnabled(bol);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
