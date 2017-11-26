package ah501.movies;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MovieReg implements Symbols{

    private ArrayList<Movie> movies;
    private ArrayList<Rating> ratings;

    public MovieReg() {
        ratings = MovieIO.readRating();
        movies = MovieIO.readMovie();

        initialiseRatings();
    }


    //for when user adds a new rating
    public void addNewRating(Rating r){
        MovieIO.writeRating(r);
        ratings.add(r);
        updateAggregateRating(r.getMovieId(), r.getRating());

    }

    //for when user adds a new movie
    public void addNewMovie(Movie m) {
        MovieIO.writeMovie(m);
        movies.add(m);
    }

    //search for a movie, given a name is entered to search for it
    public ArrayList<Movie> searchByName(String query) {
       ArrayList<Movie> searchResult = new ArrayList<Movie>();

        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getName().contains(query)){
                searchResult.add(movies.get(i));
            }
        }

        return searchResult;
    }

    //search for a movie, given a genre is entered to search for it
    public ArrayList<Movie> searchByGenre(String query) {
        ArrayList<Movie> searchResult = new ArrayList<Movie>();

        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getGenre().contains(query)){
                searchResult.add(movies.get(i));
            }
        }

        return searchResult;
    }

    //sorts movies by their names, using a Comparator that looks at the getName() method
    public void sort() {
        getMovies().sort(Comparator.comparing(Movie::getName));
    }


    public synchronized void initialiseRatings(){
        for(Movie m : movies) {
            m.setAggregateRating( MovieIO.movieRate (m.getMovieId()) );
            m.setNoRatings( MovieIO.numberOfRatings (m.getMovieId()) );
        }
    }
    //recalculate average score without having to go back into file handling
    public void updateAggregateRating(int id, double nr) {

        for(Movie m : movies) {
          if(m.getMovieId() == id) {
              double fullSum = m.getAggregateRating() * m.getNoRatings();
              fullSum+= nr;
              nr++;

              m.setAggregateRating(fullSum/nr);
              break;
          }
        }
    }

    public String printRegistry(){
        StringBuilder toPrint = new StringBuilder();

        for(Movie m : movies) {
            toPrint.append("{ Id: " + m.getMovieId() + " Name :" + m.getName() + " Genre(s): "
                            + m.getGenre() + " Avg. Rating: " + m.getAggregateRating() + " } |");
        }

        return toPrint.toString();
    }

    @Override
    public String toString() {
        return "MovieReg {" +
                "movies=" + movies +
                ", ratings=" + ratings +
                '}';
    }

    //getters and setters
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

