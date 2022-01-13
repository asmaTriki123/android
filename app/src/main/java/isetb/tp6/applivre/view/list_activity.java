package isetb.tp6.applivre.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import isetb.tp6.applivre.R;
import isetb.tp6.applivre.adapter.BookAdapter;
import isetb.tp6.applivre.model.book;
import isetb.tp6.applivre.retro.ApiClient;
import isetb.tp6.applivre.retro.ApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class list_activity extends AppCompatActivity {

    TextView textError;
    RecyclerView r;
    ProgressDialog pd;
    List<book> bookList;
    ImageButton btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        textError=findViewById(R.id.texterror);
        textError.setVisibility(View.INVISIBLE);
        r=findViewById(R.id.recyler);
        r.setLayoutManager(new LinearLayoutManager(this));
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching Books...");
        pd.setCancelable(false);
        pd.show();

        try{
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<book>> call = apiService.getBooks();
            call.enqueue(new Callback<List<book>>() {
                @Override
                public void onResponse(Call<List<book>> call, Response<List<book>> response) {
                    bookList=response.body();
                    BookAdapter adapter=new BookAdapter(list_activity.this,bookList);
                    r.setAdapter(adapter);
                    r.smoothScrollToPosition(0);
                    pd.hide();
                }

                @Override
                public void onFailure(Call<List<book>> call, Throwable t) {
                    Log.d("TAG", "Response = " + t.toString());
                    Toast.makeText(list_activity.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();
                    textError.setVisibility(View.VISIBLE);
                    pd.hide();
                }
            });

        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }





    }
}