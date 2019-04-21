package com.example.javi_.proapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.provider.MediaStore;
import android.util.SparseArray;
import android.widget.Toast;

import java.util.ArrayList;


public class AudioSoundPlayer {

    private SparseArray<PlayThread> threadMap = null;
    private Context context;
    MediaPlayer mPlayer;
    SoundPool soundPool;
    int soundId;
    boolean loaded;
    public static final int MAX_VOLUME = 100, CURRENT_VOLUME = 90;
    static int MAX_STREAMS = 10;
    float pitch=1.0f;
    private ArrayList<Integer> cuenta = new ArrayList<>();
    int aux[]={0,0,0};
    private String tercera=null;
    private String acorde=null;
    private int contador=0;
    private int acontador[]={0,0,0};
    private int sit=0;
    private boolean cartel=false;
    private int auxu=0;

    public AudioSoundPlayer(Context context) {
        this.context = context;
        threadMap = new SparseArray<>();
        mPlayer = MediaPlayer.create(this.context, R.raw.note_do);
        // For Android SDK >= 21
        if (Build.VERSION.SDK_INT >= 21 ) {

            AudioAttributes audioAttrib = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            SoundPool.Builder builder= new SoundPool.Builder();
            builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

            this.soundPool = builder.build();
        }
        // for Android SDK < 21
        else {
            // SoundPool(int maxStreams, int streamType, int srcQuality)
            this.soundPool = new SoundPool(MAX_STREAMS, AudioManager.STREAM_MUSIC, 0);
        }
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });
        soundId = soundPool.load(context, R.raw.note_do,1);
    }

    public String getAcorde() {
        return acorde;
    }

    public int getContador() {
        return contador;
    }

    public void cambioNum(int note){
            switch(note){
                case 1:
                    acorde="C";
                case 2:
                    acorde="D";
                case 3:
                    acorde="E";
                case 4:
                    acorde="F";
                case 5:
                    acorde="G";
                case 6:
                    acorde="A"; //A4
                case 7:
                    acorde="B";
                case 8:
                    acorde="C";//C5
                case 9:
                    acorde="D";
                case 10:
                    acorde="E";
                case 11:
                    acorde="F";
                case 12:
                    acorde="G";
                case 13:
                    acorde="A";
                case 14:
                    acorde="B";
                case 15:
                    acorde="C#";
                case 16:
                    acorde="D#";
                case 17:
                    acorde="F#";
                case 18:
                    acorde="G#";
                case 19:
                    acorde="A#";
                case 20:
                    acorde="C#";
                case 21:
                    acorde="D#";
                case 22:
                    acorde="F#";
                case 23:
                    acorde="G#";
                case 24:
                    acorde="A#";
                default:
                    acorde="null";
            }
        }


    public void playNote(int note) {

        if (!isNotePlaying(note)) {
            PlayThread thread = new PlayThread(note);
            thread.start();
            threadMap.put(note, thread);
            /*try {
                thread.join(); //sleep para esperar a la siguiente nota
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            if (cartel){

                Toast.makeText(context,"Ahora 3" + auxu, Toast.LENGTH_SHORT).show();
            }

            //cuenta.add(cambioNum(note));
            /*
            if(cuenta.size()==3){
                Toast.makeText(context,calculaAcordeSimple(note), Toast.LENGTH_SHORT).show();
            }
            else if(cuenta.size()==4){
                Toast.makeText(context,"Acorde complejo de 4 notas", Toast.LENGTH_SHORT).show();
            }
            else if(cuenta.size()>4){
                Toast.makeText(context,"Acorde complejo de más de 4 notas", Toast.LENGTH_SHORT).show();
            }*/
        }
    }
/*
    public String calculaAcordeSimple(int note){
        Collections.sort(cuenta);//ORDENA ELEMENTOS
        if(cuenta.get(1)-cuenta.get(0)== 3){
            tercera= "maj";
        }
        else  tercera= "min";
        return acorde + tercera;
    }*/

    public void stopNote(int note) {
        PlayThread thread = threadMap.get(note);
        if (thread != null) {
            threadMap.remove(note);
        }
        //cuenta.get(cuenta.indexOf(cambioNum(note)));
    }

    public boolean isNotePlaying(int note) {
        return threadMap.get(note) != null;
    }

    private class PlayThread extends Thread {
        int note;
        AudioTrack audioTrack;

        public PlayThread(int note) {
            this.note = note;

// soundId for reuse later on


        }

        @Override
        public void run() {

            try {
                // The audio url to play
                //String audioUrl = "http://www.all-birds.com/Sound/western%20bluebird.wav";
                // Initialize a new media player instance
                switch(note){
                    case 1:
                        pitch=0.5000009555643467f;
                        sit=1;
                        break;
                    case 2:
                        pitch=0.561231607775236f;
                        sit=3;
                        break;
                    case 3:
                        sit=5;
                        pitch=0.6299615289793999f;
                        break;
                    case 4:
                        pitch=0.6674196513719037f;
                        sit=6;
                        break;
                    case 5:
                        pitch=0.7491528922066083f;
                        sit=8;
                        break;
                    case 6:
                        pitch=0.8408966251378402f;  //A4
                        sit=10;
                        break;
                    case 7:
                        pitch=0.9438739725294362f;
                        sit=12;
                        break;
                    case 8:
                        pitch=1.0f; //C5
                        sit=13;
                        break;
                    case 9:
                        pitch=1.122463215550472f;
                        sit=15;
                        break;
                    case 10:
                        pitch=1.259921146830106f;
                        sit=17;
                        break;
                    case 11:
                        pitch=1.334839302743807f;
                        sit=18;
                        break;
                    case 12:
                        pitch=1.49830769554191f;
                        sit=20;
                        break;
                    case 13:
                        pitch=1.68179325027568f;
                        sit=22;
                        break;
                    case 14:
                        pitch=1.887749856187566f;
                        sit=24;
                        break;
                    case 15:
                        pitch=0.5297323846490499f;
                        sit=2;
                        break;
                    case 16:
                        pitch=0.5946037370210473f;
                        sit=4;
                        break;
                    case 17:
                        pitch=0.7071061498210228f;
                        sit=7;
                        break;
                    case 18:
                        pitch=0.7937013020519789f;
                        sit=9;
                        break;
                    case 19:
                        pitch=0.8908993962744457f;
                        sit=11;
                        break;
                    case 20:
                        pitch=1.059462858169406f;
                        sit=14;
                        break;
                    case 21:
                        pitch=1.189207474042095f;
                        sit=16;
                        break;
                    case 22:
                        pitch=1.413484845880108f;
                        sit=19;
                        break;
                    case 23:
                        pitch=1.586582009126663f;
                        sit=21;
                        break;
                    case 24:
                        pitch=1.780879850091973f;
                        sit=23;
                        break;
                    default:
                        break;

                }
                cambioNum(note); //cambio de nota x tecla
                //System.out.println(pitch + " " + sit);
                contador++;
                if(loaded){
                    System.out.println("yes");
                    soundPool.play(soundId, 1, 1, 0, 0, pitch);
                    System.out.println("Notas: " + contador);
                    if(contador==3) {
                       // Toast.makeText(context,"Ahora <3", Toast.LENGTH_SHORT).show();
                        //Toast.makeText(context,"Ahora 3", Toast.LENGTH_SHORT).show();
                        cartel = true;
                        auxu++;
                        System.out.print("Acorde: " + acorde + tercera); //impresion del acorde por consola

                    }
                    else if(contador>=3){
                        System.out.print("Acorde complejo: " + acorde + tercera /*+ septima + novena*/); //impresion del acorde por consola

                    }
                    else if (contador==2){
                        cartel=true;

                        Thread.sleep(500); //sleep para esperar a la siguiente nota
                    }
                    else if(contador==1){
                        cartel=false;
                        Thread.sleep(500); //sleep para esperar a la siguiente nota
                    }
                }
                else System.out.println("no");
                cartel=false;
                contador--;

            } catch (Exception e) {
            } finally {
                if (audioTrack != null) {
                    audioTrack.release();
                }
            }

        }
    }
}