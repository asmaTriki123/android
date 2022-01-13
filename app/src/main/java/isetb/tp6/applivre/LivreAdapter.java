package isetb.tp6.applivre;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class LivreAdapter extends ArrayAdapter<Livre> {
    Activity context;
    private ArrayList<Livre> listLivre;
    DatabaseHelper db;
    public LivreAdapter(Activity context,ArrayList<Livre> listLivre) {
        super(context, R.layout.live_item, listLivre);
        this.context=context;
        this.listLivre=listLivre;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View view=inflater.inflate(R.layout.live_item,null,false);
        TextView id=view.findViewById(R.id.txt1);
        TextView rubrique=view.findViewById(R.id.txt2);
        TextView auteur=view.findViewById(R.id.txt3);
        TextView titre=view.findViewById(R.id.txt4);
        ImageView edit=view.findViewById(R.id.img1);
        ImageView delete=view.findViewById(R.id.img2);
        id.setText(String.valueOf(listLivre.get(position).getId()));
        id.setText(String.valueOf(listLivre.get(position).getId()));
        rubrique.setText(listLivre.get(position).getRubrique());
        auteur.setText(listLivre.get(position).getAuteur());
        titre.setText(listLivre.get(position).getTitre());
        Livre l = listLivre.get(position);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater =LayoutInflater.from(context);
                View vi =inflater.inflate(R.layout.livre_add,null);
                EditText n1=vi.findViewById(R.id.edit_rubrique);
                EditText n2=vi.findViewById(R.id.edit_auteur);
                EditText n3=vi.findViewById(R.id.edit_titre);
                n1.setText(l.getRubrique());
                n2.setText(l.getAuteur());
                n3.setText(l.getTitre());
                AlertDialog.Builder a=new AlertDialog.Builder(context);
                a.setView(vi);
                a.create();
                a.setPositiveButton("edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String rubrique=n1.getText().toString();
                        String auteur=n2.getText().toString();
                        String titre=n3.getText().toString();
                        db=new DatabaseHelper(context);
                        db.UpdateStudent(new Livre(l.getId(),rubrique,auteur,titre));
                        context.finish();
                        context.startActivity(context.getIntent());

                    }
                });
                a.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(context,"task canceled",Toast.LENGTH_LONG).show();
                            }
                        }




                );
                a.show();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=new DatabaseHelper(context);
                db.DeleteStudent(l.getId());
                context.finish();
                context.startActivity(context.getIntent());
            }
        });

        return view;



    }



}



