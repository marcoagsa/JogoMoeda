package com.example.jm.jogomoeda;


import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AJ extends MJ {

    private void Murro () {

        final MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(AJ.this,R.raw.murro);
        mPlayer.start();
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apostatotaljh);

        // Desactiva Barra
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        // mudar tipo de letra
        Typeface TipoLetra = Typeface.createFromAsset(getAssets(), "fonts/Shoryuken.ttf");
        final TextView Preg2 = (TextView)findViewById(R.id.Pregunta2);
        Preg2.setTypeface(TipoLetra);



        final Button MT0 = (Button) findViewById(R.id.MT0);
        final Button MT1 = (Button) findViewById(R.id.MT1);
        final Button MT2 = (Button) findViewById(R.id.MT2);
        final Button MT3 = (Button) findViewById(R.id.MT3);
        final Button MT4 = (Button) findViewById(R.id.MT4);
        final Button MT5 = (Button) findViewById(R.id.MT5);
        final Button MT6 = (Button) findViewById(R.id.MT6);


        // Recebe informação de outras actividas
        Intent getFinal = getIntent();
        final int Mjogador = getFinal.getIntExtra("passMjogador",0);

        final int STVJ = getFinal.getIntExtra("passSTVJ",0);
        final int STVA = getFinal.getIntExtra("passSTVA",0);
        final int Tentativas = getFinal.getIntExtra("passTentativas",0);


        if(Mjogador==0){
            MT4.setEnabled(false);
            MT5.setEnabled(false);
            MT6.setEnabled(false);
        }else if(Mjogador==1){
            MT0.setEnabled(false);
            MT5.setEnabled(false);
            MT6.setEnabled(false);
        }else if (Mjogador ==2){
            MT0.setEnabled(false);
            MT1.setEnabled(false);
            MT6.setEnabled(false);
        }else if (Mjogador ==3) {
            MT0.setEnabled(false);
            MT1.setEnabled(false);
            MT2.setEnabled(false);
        }



        MT0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Murro();
                int Tmj=0;
                Intent getfinal = new Intent(AJ.this,Final.class);
                getfinal.putExtra("passtmj",Tmj);
                getfinal.putExtra("passMjogador",Mjogador);
                getfinal.putExtra("passSTVJ",STVJ);
                getfinal.putExtra("passSTVA",STVA);
                getfinal.putExtra("passTentativas",Tentativas);
                startActivity(getfinal);
            }
        });

        MT1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Murro();
                int Tmj=1;
                Intent getfinal = new Intent(AJ.this,Final.class);
                getfinal.putExtra("passtmj", Tmj);
                getfinal.putExtra("passMjogador",Mjogador);
                getfinal.putExtra("passSTVJ",STVJ);
                getfinal.putExtra("passSTVA",STVA);
                getfinal.putExtra("passTentativas",Tentativas);
                startActivity(getfinal);
            }
        });

        MT2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Murro();
                int Tmj=2;
                Intent getfinal = new Intent(AJ.this,Final.class);
                getfinal.putExtra("passtmj", Tmj);
                getfinal.putExtra("passMjogador",Mjogador);
                getfinal.putExtra("passSTVJ",STVJ);
                getfinal.putExtra("passSTVA",STVA);
                getfinal.putExtra("passTentativas",Tentativas);
                startActivity(getfinal);
            }
        });

        MT3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Murro();
                int Tmj=3;
                Intent getfinal = new Intent(AJ.this,Final.class);
                getfinal.putExtra("passtmj", Tmj);
                getfinal.putExtra("passMjogador",Mjogador);
                getfinal.putExtra("passSTVJ",STVJ);
                getfinal.putExtra("passSTVA",STVA);
                getfinal.putExtra("passTentativas",Tentativas);
                startActivity(getfinal);
            }
        });

        MT4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Murro();
                int Tmj=4;
                Intent getfinal = new Intent(AJ.this,Final.class);
                getfinal.putExtra("passtmj", Tmj);
                getfinal.putExtra("passMjogador",Mjogador);
                getfinal.putExtra("passSTVJ",STVJ);
                getfinal.putExtra("passSTVA",STVA);
                getfinal.putExtra("passTentativas",Tentativas);
                startActivity(getfinal);
            }
        });

        MT5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Murro();
                int Tmj=5;
                Intent getfinal = new Intent(AJ.this,Final.class);
                getfinal.putExtra("passtmj", Tmj);
                getfinal.putExtra("passMjogador",Mjogador);
                getfinal.putExtra("passSTVJ",STVJ);
                getfinal.putExtra("passSTVA",STVA);
                getfinal.putExtra("passTentativas",Tentativas);
                startActivity(getfinal);
            }
        });


        MT6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Murro();
                int Tmj=6;
                Intent getfinal = new Intent(AJ.this,Final.class);
                getfinal.putExtra("passtmj", Tmj);
                getfinal.putExtra("passMjogador",Mjogador);
                getfinal.putExtra("passSTVJ",STVJ);
                getfinal.putExtra("passSTVA",STVA);
                getfinal.putExtra("passTentativas",Tentativas);
                startActivity(getfinal);
            }
        });

    }

}
