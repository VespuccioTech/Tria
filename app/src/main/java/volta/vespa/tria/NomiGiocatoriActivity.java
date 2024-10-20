package volta.vespa.tria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class NomiGiocatoriActivity extends AppCompatActivity {

    EditText edtGiocatore1;
    EditText edtGiocatore2;
    Button btnGioca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomi_giocatori);

        edtGiocatore1 = findViewById(R.id.edtGiocatore1);
        edtGiocatore2 = findViewById(R.id.edtGiocatore2);
        btnGioca = findViewById(R.id.btnGioca);

        btnGioca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GLOBALS.giocatore1 = edtGiocatore1.getText().toString();
                GLOBALS.giocatore2 = edtGiocatore2.getText().toString();

                if (GLOBALS.giocatore1.equals("") || GLOBALS.giocatore2.equals("")) {
                    Toast.makeText(getApplicationContext(), "Inserisci 2 giocatori", Toast.LENGTH_SHORT).show();
                } else {
                    if (GLOBALS.giocatore1.equals(GLOBALS.giocatore2)) {
                        Toast.makeText(getApplicationContext(), "Inserisci 2 nomi diversi", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent intent = new Intent(NomiGiocatoriActivity.this, PartitaMultigiocatoreActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}