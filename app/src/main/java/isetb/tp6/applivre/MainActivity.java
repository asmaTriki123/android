package isetb.tp6.applivre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5;
    Button b1;
    DBAh db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (EditText) findViewById(R.id.np);
        t2 = (EditText) findViewById(R.id.l);
        t3 = (EditText) findViewById(R.id.e);
        t4 = (EditText) findViewById(R.id.mdp);
        t5=findViewById(R.id.r);
        b1 = (Button) findViewById(R.id.enr);
        db  = new DBAh(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = t1.getText().toString();
                String b = t2.getText().toString();
                String c= t3.getText().toString();
                String d=  t4.getText().toString();
                String e=  t5.getText().toString();
                if(a.equals("")||b.equals("")||c.equals("") ||d.equals("") || e.equals("")) {
                    Toast.makeText(MainActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();}
                    user u = new user (a,b,c,d,e);
                    if(!e.equals("lecteur") && !e.equals("libraire")){
                        Toast.makeText(MainActivity.this,"please enter lecteur or libraire",Toast.LENGTH_LONG).show();
                    }
                    else{
                    boolean ajout = db.insertData(u);
                    if (ajout == true) {
                        Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(MainActivity.this,login.class);
                        startActivity(intent);
                    }


                }
            }
        });

    }
    }