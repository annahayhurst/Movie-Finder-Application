package ah501.movies;

/*
* Author: ah501
* A class for storing the ratings of movies. Takes the user ID, movie ID and rating as arguments.
* Utilised by MovieIO and MovieReg classes.
 */

public class Rating {

    // Attributes
    private int userId;
    private int movieId;
    private double rating;

    // Constructor
    public Rating(int u, int m, double r) {
        userId =  u;
        movieId = m;
        rating = r;
    }

    // Getters + setters + toString
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String toString() {
        return "Rating [User ID=" + userId + ", Movie ID=" + movieId
                + ", Rating ="+ rating + "]";
    }






}
