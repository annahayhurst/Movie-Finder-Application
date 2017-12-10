package ah501.test;
import ah501.movies.*;

/*
* Author: ah501
* Test class ensuring the different features implemented in the movie package worked as expected.
* Where methods did not function correctly, they have been debugged after being tested here.
 */

public class MovieTest {
    public static void main (String[] args) {

        //movie registry to test methods on
        MovieReg testReg = new MovieReg();

        //test if save function works
        //MovieIO.saveRegistry();

        //test if load function works
        MovieIO.load();


        //see if registry has initialised correctly
//        testReg.sort();
//        System.out.println(testReg.toString());

        //test delete method
//        testReg.deleteMovie("Jumanji (1995)");
//        System.out.println(testReg.toString());


        //test that the movieRate method works, and only works with correct IDs
        //System.out.println("Average score of movie with ID 1356: " + MovieIO.movieRate(1356));
        //System.out.println(MovieIO.movieRate(999999));


        //rating example, to test if calculator methods and writeRating() work
//        Rating testRating = new Rating(100006, 1356, 4);
//        testReg.addNewRating(testRating);
        //testReg.deleteRating(100006, 1356);
//
//        Movie testUpdateRating = null;
//        try {
//            testUpdateRating = testReg.getById(1356);
//            System.out.println(testUpdateRating.getAggregateRating());
//        } catch (Exception e){
//            e.getMessage();
//        }
//
//        //movie example, to test if a new movie can be added to the data file
//        Movie testMovie = new Movie(99999, "My Movie", "Comedy");
//        testReg.addNewMovie(testMovie);
//
//        //test that sort method correctly reorders the registry alphabetically by name of film
//        testReg.sort();
//        System.out.println(testReg.toString());
//
//        //test that a new movie can be deleted from the list again
//        testReg.deleteMovie(99999);
//        System.out.println(testReg.toString());
//
//        //test that a new rating can be deleted from the list again
//        testReg.deleteRating(testRating);
        //System.out.println(testReg.getRatings());



    }
}
