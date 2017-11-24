package ah501.movies;

public class Rating {

    private int userId;
    private int movieId;
    private double rating;

    public Rating(int u, int m, double r) {
        userId =  u;
        movieId = m;
        rating = r;
    }

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
