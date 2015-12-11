package com.example.jm.jogomoeda;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.ColorRes;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class JogoMoeda extends AppCompatActivity {

    private void CriaScore() {

        File file = new File(getExternalFilesDir(null).getPath(), "/Score.txt");
        if (file.exists()) {
            Toast.makeText(getBaseContext(), "File Score Create", Toast.LENGTH_SHORT).show();
        } else

            try {
                File sdcard = new File(getExternalFilesDir(null).getPath());

                FileOutputStream fou = new FileOutputStream(sdcard + "/Score.txt");
                OutputStreamWriter osw = new OutputStreamWriter(fou);
                osw.append(getString(R.string.BestScore));
                osw.append('\n');
                osw.flush();
                osw.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public void AppExit() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void SoundFithg() {

        final MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(JogoMoeda.this, R.raw.fithg);
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
        setContentView(R.layout.activity_jogo_moeda);

        // Esconder actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();


        // Titulo do Jogo com o tipo de letra defenido
        Typeface TipoLetra = Typeface.createFromAsset(getAssets(),"fonts/Shadowofxizor.ttf");

        TextView Titulo = (TextView) findViewById(R.id.Titulo);

        Titulo.setTypeface(TipoLetra);
        Titulo.setTextSize(80);

        //Defenir os butões utilizados
        Button Bsair = (Button) findViewById(R.id.Bsair);
        Button Bjogar = (Button) findViewById(R.id.Bjogar);
        Bjogar.setTypeface(TipoLetra);
        Bjogar.setTextSize(30);
        Bsair.setTypeface(TipoLetra);
        Bsair.setTextSize(30);
        Switch Som = (Switch) findViewById(R.id.Som);
         ImageButton ScoreB = (ImageButton) findViewById(R.id.ScoreButton);
        final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // Função do Switch Sound
        Som.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
                } else {
                    // The toggle is disabled
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
                }
            }
        });

        //Função Botão Score
        ScoreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog teste = new Dialog(JogoMoeda.this);
                teste.setTitle(R.string.Score);
                teste.setContentView(R.layout.custom_dialog2);
                teste.show();

                TextView Data = (TextView) teste.findViewById(R.id.Data);
                Button Ok = (Button) teste.findViewById(R.id.OK);

                Typeface TipoLetra = Typeface.createFromAsset(getAssets(), "fonts/Shoryuken.ttf");
                Data.setTypeface(TipoLetra);


                //Find the directory for the SD Card using the API
                //*Don't* hardcode "/sdcard"
                File sdcard = new File((getExternalFilesDir(null).getPath()));

                //Get the text file
                File file = new File(sdcard, "/Score.txt");

                //Read text from file
                StringBuilder text = new StringBuilder();

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String line;

                    while ((line = br.readLine()) != null) {
                        text.append(line);
                        text.append('\n');
                    }
                    br.close();
                } catch (IOException e) {
                    //You'll need to add proper error handling here
                    Toast.makeText(getBaseContext(), "Erro Read File", Toast.LENGTH_LONG).show();
                }

                Data.setText(text);
                Data.setMovementMethod(new ScrollingMovementMethod());
                Ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        teste.dismiss();
                    }
                });
            }
        });

        // Função do Buttão Jogar
        Bjogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundFithg();
                CriaScore();
                Intent getfinal = new Intent(JogoMoeda.this, MJ.class);
                startActivity(getfinal);
            }
        });

        // Função do Buttão Sair
        Bsair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppExit();
            }
        });
       ;
    }

}
