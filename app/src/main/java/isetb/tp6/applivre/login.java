package isetb.tp6.applivre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import isetb.tp6.applivre.view.list_activity;


public class login extends AppCompatActivity {
    EditText e,l,h;
    Button b2;
    DBAh db;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e=(EditText)findViewById(R.id.email);
        l=(EditText)findViewById(R.id.mdpp);
        h=(EditText)findViewById(R.id.rol);
        b2 =(Button) findViewById(R.id.auth);
        db = new DBAh(this);
        btn= (Button) findViewById(R.id.In);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String a = e.getText().toString();
                String b = l.getText().toString();
                String y = h.getText().toString();
                if (a.equals("") || b.equals("") || y.equals("")) {
                    Toast.makeText(login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();

                }
                else {
                    user u = new user(a, b, y);
                    Boolean checkuserpass = db.checkusernamepassword(u);

                    if ((checkuserpass == true)) {
                        if (y.equals("lecteur")) {
                            Toast.makeText(login.this, "lecteur", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(login.this, list_activity.class);
                            startActivity(i);
                        }

                    else {
                            Toast.makeText(login.this, "libraire", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login.this, acceuil.class);
                        startActivity(intent);
                    }
                }
                    else{
                            Toast.makeText(login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }



        }




        );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent i = new Intent(login.this,MainActivity.class);
startActivity(i);
            }
        });
    }
}