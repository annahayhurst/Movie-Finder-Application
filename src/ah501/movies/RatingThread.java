package ah501.movies;

import java.util.concurrent.Callable;

/*
* Author: ah501
* Simple thread class using the callable interface to make calculating ratings faster.
 */

public class RatingThread implements Callable<double[]> {

    private double calculatedRating;
    private int id, noRatings;

    public RatingThread(int id) {
        this.id = id;
    }

    public double[] call() {
//        System.out.println("Started a thread!");
        calculatedRating = MovieIO.movieRate(id);
        noRatings = MovieIO.numberOfRatings (id);

        double[] array = new double[2];
        array[0] = calculatedRating;
        array[1] = noRatings;
        return array;
    }

    private double getRating() {
        return calculatedRating;
    }

    private int getNoRatings() {
        return noRatings;
    }
}
