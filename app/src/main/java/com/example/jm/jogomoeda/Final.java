package com.example.jm.jogomoeda;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Final extends AJ {


    private static int CalculaTma(int Mandroid, int Tmj) {

        Random rand = new Random();
        int Tma = Mandroid + rand.nextInt(4);
        do {
            if (Tma == Tmj) {
                Tma = Mandroid + rand.nextInt(4);
            }
        } while (Tma == Tmj);


        return Tma;
    }

    private void SoundWin() {

        final MediaPlayer mPlayer;
        mPlayer = MediaPlayer.create(Final.this, R.raw.win);
        mPlayer.start();
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    private void SoundLose() {
        final MediaPlayer player = MediaPlayer.create(Final.this, R.raw.lose);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    private void SoundNeverWin() {

        final MediaPlayer player = MediaPlayer.create(Final.this, R.raw.neverwin);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    private void SoundExcelent() {

        final MediaPlayer player = MediaPlayer.create(Final.this, R.raw.excelent);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    private void SoundRir() {

        final MediaPlayer player = MediaPlayer.create(Final.this, R.raw.rir);
        player.start();
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }

    private void Mudabackground(int STVA, int STVJ) {

        RelativeLayout BG = (RelativeLayout) findViewById(R.id.bg);

        if (STVA == 1 && STVJ == 0) {
            BG.setBackgroundResource(R.drawable.bgj1);

        } else if (STVA == 0 && STVJ == 1) {
            BG.setBackgroundResource(R.drawable.bga1);

        } else if (STVA == 0 && STVJ == 2) {
            BG.setBackgroundResource(R.drawable.bga2);

        } else if (STVA == 0 && STVJ == 3) {
            BG.setBackgroundResource(R.drawable.bga3);

        } else if (STVA == 1 && STVJ == 1) {
            BG.setBackgroundResource(R.drawable.bga1j1);

        } else if (STVA == 2 && STVJ == 0) {
            BG.setBackgroundResource(R.drawable.bgj2);

        } else if (STVA == 2 && STVJ == 1) {
            BG.setBackgroundResource(R.drawable.bgj2a1);

        } else if (STVA == 1 && STVJ == 2) {
            BG.setBackgroundResource(R.drawable.bga2j1);

        } else if (STVA == 2 && STVJ == 2) {
            BG.setBackgroundResource(R.drawable.bgj2a2);

        } else if (STVA == 3 && STVJ == 0) {
            BG.setBackgroundResource(R.drawable.bgj3);

        } else if (STVA == 3 && STVJ == 1) {
            BG.setBackgroundResource(R.drawable.bgj3a1);

        } else if (STVA == 3 && STVJ == 2) {
            BG.setBackgroundResource(R.drawable.bgj3a2);

        } else if (STVA == 2 && STVJ == 3) {
            BG.setBackgroundResource(R.drawable.bga3j2);

        } else if (STVA == 1 && STVJ == 3) {
            BG.setBackgroundResource(R.drawable.bga3j1);

        } else if (STVA == 0 && STVJ == 3) {
            BG.setBackgroundResource(R.drawable.bgj3);
        }

    }

    private void GuardaScore(int STVA, int STVJ, int Tentativas) {

        if (STVA == 3) {
            // Obtém o estado do storage.
            String mediaState = Environment.getExternalStorageState();

            // Testa se ele está disponível.
            if (mediaState.equals(Environment.MEDIA_MOUNTED)) {

                FileWriter fileWriter = null;
                try {
                    // Cria o arquivo onde serão salvas as informações.
                    File file = new File(getExternalFilesDir(null).getPath(), "/Score.txt");
                    fileWriter = new FileWriter(file, true);
                    fileWriter.append('\n');
                    fileWriter.append(getString(R.string.YouLose) + " " + Tentativas + " " + getString(R.string.Round));
                    fileWriter.append('\n');// Quebra de linha.


                    // Escreve no arquivo.
                    fileWriter.flush();

                } catch (IOException e) {
                    Log.e("Erros", "Erro ao salvar usando External Storage", e);
                } finally {
                    // Fecha os recursos.
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        } else if (STVJ == 3) {
            // Obtém o estado do storage.
            String mediaState = Environment.getExternalStorageState();

            // Testa se ele está disponível.
            if (mediaState.equals(Environment.MEDIA_MOUNTED)) {

                FileWriter fileWriter = null;
                try {
                    // Cria o arquivo onde serão salvas as informações.
                    File file = new File(getExternalFilesDir(null).getPath(), "/Score.txt");
                    fileWriter = new FileWriter(file, true);

                    fileWriter.append('\n');
                    fileWriter.append(getString(R.string.YouWin) + " " + Tentativas + " " +  getString(R.string.Round));
                    fileWriter.append('\n');// Quebra de linha.
                    // Escreve no arquivo.
                    fileWriter.flush();

                } catch (IOException e) {
                    Log.e("Erros", "Erro ao salvar usando External Storage", e);
                } finally {
                    // Fecha os recursos.
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
    }

    private void VerificaVencedor(final int STVA, final int STVJ, final int Tentativas) {

        if (STVA == 3) {

            final Dialog teste = new Dialog(Final.this);
            teste.setTitle(R.string.GO);
            teste.setContentView(R.layout.custom_dialog);
            teste.show();

            final TextView Vencedor = (TextView) teste.findViewById(R.id.Vence);
            final TextView Tentativa = (TextView) teste.findViewById(R.id.Tenta);
            final Button Yes = (Button) teste.findViewById(R.id.Yes);
            final Button No = (Button) teste.findViewById(R.id.No);

            Typeface TipoLetra = Typeface.createFromAsset(getAssets(), "Shoryuken.ttf");
            Vencedor.setTypeface(TipoLetra);
            Tentativa.setTypeface(TipoLetra);

            Vencedor.setText(R.string.YouLose);
            Tentativa.setText(getString(R.string.YouLose) + " " + Tentativas + " " + getString(R.string.Round));

            Yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SoundExcelent();
                    teste.cancel();
                    GuardaScore(STVA, STVJ, Tentativas);
                    startActivity(new Intent(Final.this, MJ.class));
                }
            });

            No.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SoundRir();
                    teste.cancel();
                    GuardaScore(STVA, STVJ, Tentativas);
                    startActivity(new Intent(Final.this, JogoMoeda.class));
                }
            });

        } else if (STVJ == 3) {

            final Dialog teste = new Dialog(Final.this);
            teste.setTitle(R.string.GO);
            teste.setContentView(R.layout.custom_dialog);
            teste.show();

            final TextView Vencedor = (TextView) teste.findViewById(R.id.Vence);
            final TextView Tentativa = (TextView) teste.findViewById(R.id.Tenta);
            final Button Yes = (Button) teste.findViewById(R.id.Yes);
            final Button No = (Button) teste.findViewById(R.id.No);

            Typeface TipoLetra = Typeface.createFromAsset(getAssets(), "Shoryuken.ttf");
            Vencedor.setTypeface(TipoLetra);
            Tentativa.setTypeface(TipoLetra);
            Vencedor.setText(R.string.YouWin);
            Tentativa.setText(getString(R.string.YouWin)+ " " + Tentativas + " " + getString(R.string.Round));

            Yes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SoundExcelent();
                    teste.cancel();
                    GuardaScore(STVA, STVJ, Tentativas);
                    startActivity(new Intent(Final.this, MJ.class));
                }
            });

            No.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SoundRir();
                    teste.cancel();
                    GuardaScore(STVA, STVJ, Tentativas);
                    startActivity(new Intent(Final.this, JogoMoeda.class));
                }
            });

        }


    }

    private void VeOrientacao(int newConfig, boolean ori) {


        if (newConfig == Configuration.ORIENTATION_LANDSCAPE) {
            ori = true;
        } else if (newConfig == Configuration.ORIENTATION_PORTRAIT) {
            ori = false;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final2);

        Random rand = new Random();
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        LayoutInflater inflater = getLayoutInflater();
        Intent getFinal = getIntent();

        // mudar tipo de letra
        Typeface TipoLetra = Typeface.createFromAsset(getAssets(), "Shoryuken.ttf");


        final TextView Round = (TextView) findViewById(R.id.Round);
        final TextView pregunta1 = (TextView) findViewById(R.id.Pregunta1);
        final TextView pregunta2 = (TextView) findViewById(R.id.Pregunta2);
        final TextView Android1 = (TextView) findViewById(R.id.Android1);
        final TextView Android2 = (TextView) findViewById(R.id.Android2);
        final TextView TotalMoedas = (TextView) findViewById(R.id.totalmoedas);
        final TextView Vj = (TextView) findViewById(R.id.vj);
        final TextView Va = (TextView) findViewById(R.id.Va);
        final Button Sair2 = (Button) findViewById(R.id.Sair2);
        final Button JogarNovamente = (Button) findViewById(R.id.JN);
        final RelativeLayout BG = (RelativeLayout) findViewById(R.id.bg);

        Round.setTypeface(TipoLetra);
        pregunta1.setTypeface(TipoLetra);
        pregunta2.setTypeface(TipoLetra);
        Android1.setTypeface(TipoLetra);
        Android2.setTypeface(TipoLetra);



            int Tenta = getFinal.getIntExtra("passTentativas", 3);
            int Mandroid = rand.nextInt(4);
            int Tma = -1;
            int Mjogador = getFinal.getIntExtra("passMjogador", 0);
            int Tmj = getFinal.getIntExtra("passtmj", 0);

            int Tm = 0;
            Tm = Mjogador + Mandroid;
            Tma = CalculaTma(Mandroid, Tmj);

            int vj = getFinal.getIntExtra("passSTVJ", 3);
            int va = getFinal.getIntExtra("passSTVA", 3);

            if (Tmj == Tm) {
                SoundWin();
                vj++;
                Tenta++;
                if (vj < 3) {
                    View Layout = inflater.inflate(R.layout.custom_toast2, (ViewGroup) findViewById(R.id.layout_custom));
                    TextView Texttoast = (TextView) Layout.findViewById(R.id.texttoast);
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(Layout);
                    Texttoast.setText(R.string.YouWin);
                    toast.show();
                }

            } else if (Tma == Tm) {
                SoundLose();
                va++;
                Tenta++;
                if (va < 3) {
                    View Layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.layout_custom));
                    TextView Texttoast = (TextView) Layout.findViewById(R.id.texttoast);
                    Toast toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                    toast.setDuration(Toast.LENGTH_SHORT);
                    toast.setView(Layout);
                    Texttoast.setText(R.string.YouLose);
                    toast.show();
                }
            } else {
                SoundNeverWin();
                View Layout = inflater.inflate(R.layout.custom_toast3, (ViewGroup) findViewById(R.id.layout_custom));
                TextView Texttoast = (TextView) Layout.findViewById(R.id.texttoast);
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setView(Layout);
                Texttoast.setText(R.string.NobodyWon);
                toast.show();
                Tenta++;
            }

            final int STVA = va;
            final int STVJ = vj;
            final int Tentativas = Tenta;

            Round.setText(getString(R.string.Round) + " " + Integer.toString(Tentativas));

            String Mj = String.valueOf(Mjogador);
            pregunta1.setText(getString(R.string.PlayerCoins) + " " + Mj);

            String Totalmj = String.valueOf(Tmj);
            pregunta2.setText(getString(R.string.PlayerBet) + " " + Totalmj);

            Android1.setText(Integer.toString(Mandroid) + " " + getString(R.string.AndroidCoins));
            Android2.setText(Integer.toString(Tma) + " " + getString(R.string.AndroidBet));

            TotalMoedas.setText(Integer.toString(Tm));
            Vj.setText(Integer.toString(STVJ));
            Va.setText(Integer.toString(STVA));

            Mudabackground(STVA, STVJ);
            VerificaVencedor(STVA, STVJ, Tentativas);


        JogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getfinal = new Intent(Final.this, MJ.class);
                getfinal.putExtra("passSTVJ", STVJ);
                getfinal.putExtra("passSTVA", STVA);
                getfinal.putExtra("passTentativas", Tentativas);
                startActivity(getfinal);
            }
        });

        Sair2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SoundRir();
                Intent intent = new Intent(getApplicationContext(), JogoMoeda.class);
                startActivity(intent);
            }
        });



    }

}
