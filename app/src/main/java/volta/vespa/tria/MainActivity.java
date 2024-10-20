package volta.vespa.tria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView txtTria;
    Button btnBot;
    Button btnDueGiocatori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTria = findViewById(R.id.txtTria);
        btnBot = findViewById(R.id.btnBot);
        btnDueGiocatori = findViewById(R.id.btnDueGiocatori);

        btnBot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SelezioneDifficoltaActivity.class);
                startActivity(intent);
            }
        });

        btnDueGiocatori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NomiGiocatoriActivity.class);
                startActivity(intent);
            }
        });
    }
}