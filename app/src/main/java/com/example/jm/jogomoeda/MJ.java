package com.example.jm.jogomoeda;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MJ extends JogoMoeda {

    private void Murro () {

        final MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(MJ.this,R.raw.murro);
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
            setContentView(R.layout.activity_apostajh);

            // Desactiva Barra
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();


            // Recebe informação de outras actividas
            Intent getFinal = getIntent();

            //fazer passar a informação de actividade para actividade
            final int STVJ = getFinal.getIntExtra("passSTVJ",0);
            final int STVA = getFinal.getIntExtra("passSTVA",0);
            final int Tentativas = getFinal.getIntExtra("passTentativas",0);

            // mudar tipo de letra
            Typeface TipoLetra = Typeface.createFromAsset(getAssets(), "Shoryuken.ttf");
            final TextView Preg1 = (TextView)findViewById(R.id.Pregunta1);
            Preg1.setTypeface(TipoLetra);

            //Definir os Butões utilizados
            final Button M0 = (Button) findViewById(R.id.M0);
            final Button M1 = (Button) findViewById(R.id.M1);
            final Button M2 = (Button) findViewById(R.id.M2);
            final Button M3 = (Button) findViewById(R.id.M3);


            M0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Murro();
                    int Mjogador = 0;
                    Intent getfinal = new Intent(MJ.this,AJ.class);
                    getfinal.putExtra("passMjogador",Mjogador);
                    getfinal.putExtra("passSTVJ",STVJ);
                    getfinal.putExtra("passSTVA",STVA);
                    getfinal.putExtra("passTentativas", Tentativas);
                    startActivity(getfinal);
                }
            });


            M1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Murro();
                    int Mjogador = 1;
                    Intent getfinal = new Intent(MJ.this,AJ.class);
                    getfinal.putExtra("passMjogador",Mjogador);
                    getfinal.putExtra("passSTVJ",STVJ);
                    getfinal.putExtra("passSTVA",STVA);
                    getfinal.putExtra("passTentativas",Tentativas);
                    startActivity(getfinal);
                }

            });

            M2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Murro();
                    int Mjogador = 2;
                    Intent getfinal = new Intent(MJ.this,AJ.class);
                    getfinal.putExtra("passMjogador",Mjogador);
                    getfinal.putExtra("passSTVJ",STVJ);
                    getfinal.putExtra("passSTVA",STVA);
                    getfinal.putExtra("passTentativas",Tentativas);
                    startActivity(getfinal);
                }
            });

            M3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Murro();
                    int Mjogador = 3;
                    Intent getfinal = new Intent(MJ.this,AJ.class);
                    getfinal.putExtra("passMjogador",Mjogador);
                    getfinal.putExtra("passSTVJ",STVJ);
                    getfinal.putExtra("passSTVA",STVA);
                    getfinal.putExtra("passTentativas",Tentativas);
                    startActivity(getfinal);
                }
            });

        }

}
