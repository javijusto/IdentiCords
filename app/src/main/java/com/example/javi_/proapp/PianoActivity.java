package com.example.javi_.proapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


public class PianoActivity extends AppCompatActivity {
    private int contador;
    AudioSoundPlayer as;

    public PianoActivity(){
        contador =0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) { //INICIO
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        as = new AudioSoundPlayer(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){ //MENU
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //FUNCION MENU
        switch (item.getItemId()){
            case R.id.item1:
                Toast.makeText(this, "II", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "II", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, "II", Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }

    @Override
    public void onUserInteraction() {
        /*
        Bundle b = this.getIntent().getExtras();
        String conta = b.getString("cuenta");
        System.out.println("CONTADORS: " + as.getContador());

        if(conta.equals(3)){
            Toast.makeText(this,"3", Toast.LENGTH_SHORT).show();
        }

        if(as.getContador()>3){
            Toast.makeText(this,">3", Toast.LENGTH_SHORT).show();
        }
        else if(as.getContador()<3){
            Toast.makeText(this,"<3", Toast.LENGTH_SHORT).show();
        }
        super.onUserInteraction();
 */
    }
}
