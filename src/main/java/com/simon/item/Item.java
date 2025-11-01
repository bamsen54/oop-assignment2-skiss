package com.simon.item;

public abstract class Item {

    private int id;
    private String title;
    private String category;

    public Item() {
    }

    public Item(int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String article) {
        this.title = article;
    }

    abstract public String toString();
}
