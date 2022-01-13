package isetb.tp6.applivre;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView l;
    DatabaseHelper db;
    LivreAdapter adapter;
    ArrayList<Livre> listlivre;
    FloatingActionButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        db=new DatabaseHelper(this);
        l=findViewById(R.id.list);
        button=findViewById(R.id.btn_add);

        int nbStudent=db.getStudentCount();

        if(nbStudent==0){
            Toast.makeText(MainActivity2.this," la base est vide",Toast.LENGTH_LONG).show();
        }
        else{
            listlivre=db.getAllStudent();
            adapter=new LivreAdapter(this,listlivre);
            l.setAdapter(adapter);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =LayoutInflater.from(MainActivity2.this);
                View vi =inflater.inflate(R.layout.livre_add,null);
                EditText n1=vi.findViewById(R.id.edit_rubrique);
                EditText n2=vi.findViewById(R.id.edit_auteur);
                EditText n3=vi.findViewById(R.id.edit_titre);
                AlertDialog.Builder a=new AlertDialog.Builder(MainActivity2.this);
                a.setView(vi);
                a.create();
                a.setPositiveButton("add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String rubrique=n1.getText().toString();
                        String auteur=n2.getText().toString();
                        String titre=n3.getText().toString();
                        Livre s=new Livre(rubrique,auteur,titre);
                        db.AddStudent(s);
                        finish();
                        startActivity(getIntent());
                    }
                });
                a.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity2.this,"task canceled",Toast.LENGTH_LONG).show();
                    }
                });
                a.show();
            }
        });




    }
}