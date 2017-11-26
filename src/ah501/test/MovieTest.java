package ah501.test;
import ah501.movies.*;

public class MovieTest {
    public static void main (String[] args) {

        //movie registry to test methods on
        MovieReg testReg = new MovieReg();

        //System.out.println(testReg.printRegistry());
        System.out.println(MovieIO.movieRate(2));


        //rating example, to test if calculator methods and writeRating() work
        Rating testRating = new Rating(100006, 1356, 4);
        //testReg.addNewRating(testRating);


    }
}
