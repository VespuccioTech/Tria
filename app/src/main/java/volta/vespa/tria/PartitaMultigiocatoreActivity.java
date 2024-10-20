package volta.vespa.tria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class PartitaMultigiocatoreActivity extends AppCompatActivity {

    Random random = new Random();

    int contatore = 0;

    ImageView img_x;
    ImageView img_o;

    ImageView img11;
    ImageView img12;
    ImageView img13;
    ImageView img21;
    ImageView img22;
    ImageView img23;
    ImageView img31;
    ImageView img32;
    ImageView img33;

    TextView txtGiocatore1;
    TextView txtGiocatore2;

    TextView txtRisultato;

    Boolean player;

    String nome1 = GLOBALS.giocatore1;
    String nome2 = GLOBALS.giocatore2;

    String vincitore;
    Boolean vinto = false;

    Button btnMenu;

    private ArrayList<String> tria = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partita);

        int n = random.nextInt(2);

        if (n == 0)
            player = true;
        else
            player = false;

        btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setVisibility(View.INVISIBLE);

        img_x = findViewById(R.id.img_x);
        img_o = findViewById(R.id.img_o);

        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);
        img13 = findViewById(R.id.img13);
        img21 = findViewById(R.id.img21);
        img22 = findViewById(R.id.img22);
        img23 = findViewById(R.id.img23);
        img31 = findViewById(R.id.img31);
        img32 = findViewById(R.id.img32);
        img33 = findViewById(R.id.img33);

        txtRisultato = findViewById(R.id.txtRisultato);

        txtGiocatore1 = findViewById(R.id.txtGiocatore1);
        txtGiocatore2 = findViewById(R.id.txtGiocatore2);

        txtGiocatore1.setText(nome1);
        txtGiocatore2.setText(nome2);

        for (int i = 0; i < 9; i++)
            tria.add("-1");

        mostraGiocatore();

        imgClick(0, img11);
        imgClick(1, img12);
        imgClick(2, img13);
        imgClick(3, img21);
        imgClick(4, img22);
        imgClick(5, img23);
        imgClick(6, img31);
        imgClick(7, img32);
        imgClick(8, img33);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void mossa(int m) {
        if (tria.get(m).equals("-1")) {
            if (player) {
                switch (m) {
                    case 0:
                        img11.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 1:
                        img12.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 2:
                        img13.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 3:
                        img21.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 4:
                        img22.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 5:
                        img23.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 6:
                        img31.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 7:
                        img32.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                    case 8:
                        img33.setImageDrawable(getDrawable(R.drawable.mossa_x));
                        break;
                }
                tria.set(m, "1");
            } else {
                switch (m) {
                    case 0:
                        img11.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 1:
                        img12.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 2:
                        img13.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 3:
                        img21.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 4:
                        img22.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 5:
                        img23.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 6:
                        img31.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 7:
                        img32.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                    case 8:
                        img33.setImageDrawable(getDrawable(R.drawable.mossa_o));
                        break;
                }
                tria.set(m, "0");
            }
            player = !player;
            mostraGiocatore();
        }
    }

    // Controlla se uno dei due giocatori ha vinto
    private void controlla(ArrayList<String> tria) {
        String output = "";

        // Controlla le righe orizzontali
        for (int i = 0; i < 9; i += 3) {

            int c = 0; // Contatore

            for (int j = i; c < 3; j++) {
                output += tria.get(j);

                if (output.equals("111")) {
                    vincitore = nome1;
                    stampaVincitore(vincitore);
                    vinto = true;
                }

                if (output.equals("000")) {
                    vincitore = nome2;
                    stampaVincitore(vincitore);
                    vinto = true;
                }

                c++;
            }
            output = "";
            c = 0;
        }

        output = "";

        // Controlla le righe verticali
        for (int i = 0; i < 3; i++) {

            for (int j = i; j < 9; j += 3) {
                output += tria.get(j);

                if (output.equals("111")) {
                    vincitore = nome1;
                    stampaVincitore(vincitore);
                    vinto = true;
                }

                if (output.equals("000")) {
                    vincitore = nome2;
                    stampaVincitore(vincitore);
                    vinto = true;
                }

            }
            output = "";
        }

        output = "";

        // Controlla le diagonali
        for (int i = 0; i < 3; i++) {

            output += tria.get(i * 4);

            if (output.equals("111")) {
                vincitore = nome1;
                stampaVincitore(vincitore);
                vinto = true;
            }

            if (output.equals("000")) {
                vincitore = nome2;
                stampaVincitore(vincitore);
                vinto = true;
            }

        }

        output = "";

        // Controlla le diagonali
        for (int i = 1; i <= 3; i++) {

            output += tria.get(i * 2);

            if (output.equals("111")) {
                vincitore = nome1;
                stampaVincitore(vincitore);
                vinto = true;
            }

            if (output.equals("000")) {
                vincitore = nome2;
                stampaVincitore(vincitore);
                vinto = true;
            }

        }
    }

    public void stampaVincitore(String vincitore) {
        if (!vinto)
            txtRisultato.setText(vincitore + " hai vinto!");

        btnMenu.setVisibility(View.VISIBLE);
    }

    public void mostraGiocatore() {

        if (contatore < 9) {
            if (player) {
                if (!vinto) {
                    txtRisultato.setText("Gioca " + nome1);
                }
            } else {
                if (!vinto) {
                    txtRisultato.setText("Gioca " + nome2);
                }
            }
            contatore++;
        } else {
            txtRisultato.setText("Pareggio");
            btnMenu.setVisibility(View.VISIBLE);
        }
    }

    private void imgClick(int i, ImageView img) {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!vinto) {
                    mossa(i);
                    controlla(tria);
                }
            }
        });
    }
}