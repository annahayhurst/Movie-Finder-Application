package ah501.movies;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/*
* Author: ah501
* A registry class that stores information about movies and their ratings according to the current state of the source files.
* Has methods for calculating average ratings of the movies stored in its array list, and writing new ratings and movies to
* the relevant files via MovieIO methods.
 */

public class MovieReg implements Symbols{

    // Attributes
    private ArrayList<Movie> movies;
    private ArrayList<Rating> ratings;

    // Constructor
    public MovieReg() {
        ratings = MovieIO.readRating();
        movies = MovieIO.readMovie();

        initialiseRatings();
    }

    public MovieReg(int noRate) {
        ratings = MovieIO.readRating();
        movies = MovieIO.readMovie();
    }


    // For when user adds a new rating: add this to the Ratings.csv file then update the rating of the movie.
    public void addNewRating(Rating r){
        MovieIO.writeRating(r);
        ratings.add(r);
        updateAggregateRating(r.getMovieId(), r.getRating());

    }

    // For when user adds a new movie: add this to the MovieData.csv file and to the current working list.
    public void addNewMovie(Movie m) {
        MovieIO.writeMovie(m);
        movies.add(m);
    }

    // Search for a movie, given a name is entered to search for it.
    public ArrayList<Movie> searchByName(String query) {
       ArrayList<Movie> searchResult = new ArrayList<Movie>();

        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getName().contains(query)){
                searchResult.add(movies.get(i));
            }
        }

        return searchResult;
    }

    // Search for a movie, given a genre is entered to search for it.
    public ArrayList<Movie> searchByGenre(String query) {
        ArrayList<Movie> searchResult = new ArrayList<Movie>();

        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getGenre().contains(query)){
                searchResult.add(movies.get(i));
            }
        }

        return searchResult;
    }

    // Search for a movie by its id.
    public Movie getById(int id) throws Exception {
        Movie toFind = null;

        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getMovieId() == id){
                toFind = movies.get(i);
            }
        }

        if (toFind != null) {
            return toFind;
        } else throw new Exception("Could not find movie with that id in this registry.");
    }

    // Sorts movies by their names, using a Comparator that looks at the getName() method.
    public void sort() {
        getMovies().sort(Comparator.comparing(Movie::getName));
    }

    // Generates the current ratings for the movies in this registry, when the registry is created.
    public synchronized void initialiseRatings(){
        for(Movie m : movies) {
            m.setAggregateRating( MovieIO.movieRate (m.getMovieId()) );
            m.setNoRatings( MovieIO.numberOfRatings (m.getMovieId()) );
        }
    }
    // Recalculate average score without having to go back into file handling.
    public void updateAggregateRating(int id, double nr) {

        for(Movie m : movies) {
          if(m.getMovieId() == id) {
              double fullSum = m.getAggregateRating() * m.getNoRatings();
              fullSum+= nr;
              m.setNoRatings(m.getNoRatings()+ 1);

              m.setAggregateRating(fullSum/m.getNoRatings());
              break;
          }
        }
    }

    // A user can delete a movie they have added to the registry so it no longer appears in their UI.
    public void deleteMovie(int id) {
        Iterator<Movie> movieIterator = getMovies().iterator();
        while(movieIterator.hasNext()){
            Movie next = movieIterator.next();

            if (next.getMovieId() == id) {
                movieIterator.remove();
            }
        }
    }

    // A user can delete a rating they have added for a movie so it no longer appears on their UI.
    public void deleteRating(Rating r) {
        Iterator<Rating> ratingIterator = getRatings().iterator();
        while(ratingIterator.hasNext()){
            Rating next = ratingIterator.next();

            if (next == r) {
                ratingIterator.remove();
            }
        }
    }


    // Methods for printing the contents of the registry for examination
    public String printRegistry(){
        StringBuilder toPrint = new StringBuilder();
        DecimalFormat decimalFormat = new DecimalFormat("#.00");

        for(Movie m : movies) {
            toPrint.append("{Id: " + m.getMovieId() + ", Name: " + m.getName() + ", Genre(s): "
                            + m.getGenre() + ", Avg. Rating: " + decimalFormat.format( m.getAggregateRating() ) + "} | ");
        }

        return toPrint.toString();
    }

    @Override
    public String toString() {
        return "This movie registry contains [ " +
                printRegistry() + " ]";
    }

    // Getters and setters
    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }



    }

