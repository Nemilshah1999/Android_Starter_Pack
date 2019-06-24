package com.example.nehaudeshi.coffeebuzz;

public class Drinks {

    private String name;
    private String desc;
    private int imageID;

    private Drinks(String name, String desc, int imageID){
        this.name = name;
        this.desc = desc;
        this.imageID = imageID;
    }

    public static final Drinks[] drinks = {
      new Drinks("Latte","This is a description for Latte",R.drawable.c1),
      new Drinks("Cappuccino","This is a description for Cappucino",R.drawable.c4),
      new Drinks("Filter Coffee","This is a description for Filter Coffee",R.drawable.c2)
    };

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getImageID() {
        return imageID;
     }

    public String toString(){
        return this.name;
    }
}
