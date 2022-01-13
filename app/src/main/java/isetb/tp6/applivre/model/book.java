package isetb.tp6.applivre.model;

import com.google.gson.annotations.SerializedName;

public class book {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("price")
    private double price;
    @SerializedName("image")
    private String imageURL;

    public book(String title, double price, String imageURL) {
        this.title = title;
        this.price = price;
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageURL() {
        return "http://192.168.1.17/livre/book/"+imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
