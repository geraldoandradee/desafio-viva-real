package br.com.vivareal.desafio.spotippos.models;

public class Boundary {
    Integer upperLeftX;
    Integer upperLeftY;
    Integer bottomRightX;
    Integer bottomRightY;

    public Boundary() {
    }

    public Boundary(Integer upperLeftX, Integer upperLeftY, Integer bottomRightX, Integer bottomRightY) {
        this.upperLeftX = upperLeftX;
        this.upperLeftY = upperLeftY;
        this.bottomRightX = bottomRightX;
        this.bottomRightY = bottomRightY;
    }

    public Integer getUpperLeftX() {
        return upperLeftX;
    }

    public void setUpperLeftX(Integer upperLeftX) {
        this.upperLeftX = upperLeftX;
    }

    public Integer getUpperLeftY() {
        return upperLeftY;
    }

    public void setUpperLeftY(Integer upperLeftY) {
        this.upperLeftY = upperLeftY;
    }

    public Integer getBottomRightX() {
        return bottomRightX;
    }

    public void setBottomRightX(Integer bottomRightX) {
        this.bottomRightX = bottomRightX;
    }

    public Integer getBottomRightY() {
        return bottomRightY;
    }

    public void setBottomRightY(Integer bottomRightY) {
        this.bottomRightY = bottomRightY;
    }
}
