package isetb.tp6.applivre;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class acceuil extends AppCompatActivity {
    CardView c1,c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);

        c1=findViewById(R.id.consulter);
c2=findViewById(R.id.ajoute);


        c1.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(acceuil.this, MainActivity2.class);
                startActivity(i);
            }
        }));

    }
}