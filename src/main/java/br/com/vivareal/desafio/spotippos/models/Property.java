package br.com.vivareal.desafio.spotippos.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Property {
    private Integer id;
    @SerializedName("lat")
    private Integer x;
    @SerializedName("long")
    private Integer y;
    private String title;
    private Integer price; // apenas para cumprir a definicao do json, mas deveria ser double ou float
    private String description;
    private Integer beds;
    private Integer baths;
    private Integer squareMeters;
    private List<String> provices;

    public Property() {}

    public Property(Integer x, Integer y, String title, Integer price, String description, Integer beds, Integer baths, Integer squareMeters) {
        this.x = x;
        this.y = y;
        this.title = title;
        this.price = price;
        this.description = description;
        this.beds = beds;
        this.baths = baths;
        this.squareMeters = squareMeters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    public Integer getBaths() {
        return baths;
    }

    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    public Integer getSquareMeters() {
        return squareMeters;
    }

    public void setSquareMeters(Integer squareMeters) {
        this.squareMeters = squareMeters;
    }


    public List<String> getProvices() {
        return provices;
    }

    public void setProvices(List<String> provices) {
        this.provices = provices;
    }
}
