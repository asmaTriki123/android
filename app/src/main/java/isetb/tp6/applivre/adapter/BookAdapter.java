package isetb.tp6.applivre.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import isetb.tp6.applivre.R;
import isetb.tp6.applivre.model.book;

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder>{


    Context context;
    List<book> list;

    public BookAdapter(Context context, List<book> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.price.setText(String.valueOf(list.get(position).getPrice())+" TND");
        Picasso.with(context).load(list.get(position).getImageURL())
                .placeholder(R.drawable.load)
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}


