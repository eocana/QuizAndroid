package com.example.quiz1.model;

public class Player {

    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sumarPuntos(){
        this.points=+10;
    }

    public void restaPuntos(){
        this.points=-10;
    }


}