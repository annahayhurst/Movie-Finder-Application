package ah501.movies;


public class Movie {


    private String name, genre;
    private int movieId, noRatings;
    private double aggregateRating;

    public Movie(int id, String n, String g) {
    this.name = n;
    this.genre = g;
    this.movieId = id;
    }

    public void calculateAggregateRating() {
        this.aggregateRating = MovieIO.movieRate(this.movieId);
        this.noRatings = MovieIO.numberOfRatings(this.movieId);

    }

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
}
