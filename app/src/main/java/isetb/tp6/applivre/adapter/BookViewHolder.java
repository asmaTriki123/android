package isetb.tp6.applivre.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.CollationElementIterator;
import isetb.tp6.applivre.R;

public class BookViewHolder extends RecyclerView.ViewHolder{

    TextView title,price;
    ImageView image;

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.text_title);
        price=itemView.findViewById(R.id.text_price);
        image=itemView.findViewById(R.id.image);
    }
}
