package volta.vespa.tria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SelezioneDifficoltaActivity extends AppCompatActivity {

    TextView txtDifficolta;
    SeekBar seekBar;
    Button btnGioca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selezione_difficolta);

        txtDifficolta = findViewById(R.id.txtDifficolta);
        seekBar = findViewById(R.id.seekBar);
        btnGioca = findViewById(R.id.btnGioca);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateDifficolta(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        btnGioca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelezioneDifficoltaActivity.this, PartitaBotActivity.class);
                startActivity(intent);
            }
        });

        updateDifficolta(seekBar.getProgress());
    }

    private void updateDifficolta(int progress) {

        if (progress < 1) {
            GLOBALS.difficolta = "Facile";
        } else if (progress < 2) {
            GLOBALS.difficolta = "Medio";
        } else {
            GLOBALS.difficolta = "Impossibile";
        }

        txtDifficolta.setText(GLOBALS.difficolta);
    }
}