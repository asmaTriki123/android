package isetb.tp6.applivre.retro;

import java.util.List;

import isetb.tp6.applivre.model.book;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("book.php")
    Call<List<book>> getBooks();
}
