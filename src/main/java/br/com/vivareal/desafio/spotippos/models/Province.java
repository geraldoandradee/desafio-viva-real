package br.com.vivareal.desafio.spotippos.models;

public class Province {
    private String name;
    private Boundary boundary;

    public Province() {
    }

    public Province(String name, Boundary boundary) {
        this.name = name;
        this.boundary = boundary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boundary getBoundary() {
        return boundary;
    }

    public void setBoundary(Boundary boundary) {
        this.boundary = boundary;
    }
}
