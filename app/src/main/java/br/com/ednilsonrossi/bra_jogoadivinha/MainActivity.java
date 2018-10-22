package br.com.ednilsonrossi.bra_jogoadivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int sorteado;
    private EditText entradaET;
    private Button clicouBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sortear();
        entradaET = (EditText) findViewById(R.id.entradaEditText);
        clicouBtn = (Button) findViewById(R.id.clicouBtn);
    }

    private void sortear(){
        Random rand = new Random();
        sorteado = rand.nextInt(100);
    }

    public void clique(View view){
        int palpite;
        if(view == clicouBtn){
            palpite = Integer.parseInt(entradaET.getText().toString());
            if(palpite == sorteado){
                Toast.makeText(this, "Parabéns você acertou!", Toast.LENGTH_SHORT).show();
                clicouBtn.setEnabled(false);
            }else{
                if(palpite > sorteado){
                    Toast.makeText(this, "Seu palpite foi muito alto. Tente novamente", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Seu palpite foi muito baixo. Tente novamente", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
