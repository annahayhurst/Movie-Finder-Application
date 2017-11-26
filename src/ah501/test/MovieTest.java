package ah501.test;
import ah501.movies.*;

public class MovieTest {
    public static void main (String[] args) {

        //movie registry to test methods on
        MovieReg testReg = new MovieReg();


        //see if registry has initialised correctly
        System.out.println(testReg.toString());

        //test that the movieRate method works, and only works with correct IDs
        System.out.println("Average score of movie with ID 1356: " + MovieIO.movieRate(1356));
        //System.out.println(MovieIO.movieRate(999999));


        //rating example, to test if calculator methods and writeRating() work
        Rating testRating = new Rating(100006, 1356, 4);
        testReg.addNewRating(testRating);

        Movie testUpdateRating = null;
        try {
            testUpdateRating = testReg.getById(1356);
            System.out.println(testUpdateRating.getAggregateRating());
        } catch (Exception e){
            e.getMessage();
        }

        //movie example, to test if a new movie can be added to the data file
        Movie testMovie = new Movie(99999, "My Movie", "Comedy");
        //testReg.addNewMovie(testMovie);


    }
}
