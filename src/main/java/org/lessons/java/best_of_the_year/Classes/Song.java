package org.lessons.java.best_of_the_year.Classes;

public class Song {
    
    private String id;
    private String title;

    public Song(String id, String title) {
        this.id = id;
        this.title = title;
    }

    //Getter e Setter

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getTitle();
    }
}