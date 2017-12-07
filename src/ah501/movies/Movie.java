package ah501.movies;

/*
* Author: ah501
* Class for the object type Movie, which stores the ID, genre, name and average rating of a given movie.
* It relies on the helper classes MovieIO for fetching movies, and the MovieReg class for storing them.
 */


import java.text.DecimalFormat;

public class Movie {

    // Attributes
    private String name, genre;
    private int movieId, noRatings;
    private double aggregateRating;

    // Constructor
    public Movie(int id, String n, String g) {
    this.name = n;
    this.genre = g;
    this.movieId = id;
    this.aggregateRating = 0;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getNoRatings() {
        return noRatings;
    }

    public void setNoRatings(int noRatings) {
        this.noRatings = noRatings;
    }

    public double getAggregateRating() {
        return aggregateRating;
    }

    public void setAggregateRating(double aggregateRating) {
        this.aggregateRating = aggregateRating;
    }

    @Override
    public String toString(){
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return getName() + "   ||   " + getGenre() + "   ||   " +  decimalFormat.format(getAggregateRating());
    }
}
