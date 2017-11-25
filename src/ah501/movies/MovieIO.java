package ah501.movies;

import java.io.*;
import java.util.ArrayList;


public class MovieIO {

    private static final String COM = ",";
    private static final String NL = "\n";

//read from CSV file and return a usable array list of ratings.
    public ArrayList<Rating> readRating(String fName) {
        BufferedReader reader = null;
        ArrayList<Rating> ratings = new ArrayList<Rating>();

        try {
            reader = new BufferedReader(new FileReader(fName));
            String line = "";
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(COM);
                if (tokens.length > 0) {

                    try {
                        int u = Integer.parseInt(tokens[0]);
                        int m = Integer.parseInt(tokens[1]);
                        double r = Double.parseDouble(tokens[2]);
                        Rating rating = new Rating(u, m, r);
                        ratings.add(rating);

                    } catch (NumberFormatException nfe) {
                        System.out.println("Parsed value was not an integer or double.");
                        break;
                    }
                }
            }

        } catch (EOFException eof) {
            System.out.println("Reached end of file, exiting.");
        } catch(FileNotFoundException fnf) {
            System.out.println("File not found at specified path.");
        } catch (IOException io) {
            System.out.println("Error occurred with I/O.");
            io.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch(IOException io) {
                System.out.println("Error occurred while closing reader.");
            }
        }

    return ratings;
    }

    //write to CSV file
    public static  void writeRating(String fileName, Rating r) {

        FileWriter writer = null;

        try {
            writer = new FileWriter(fileName, true);
            //Write the new ratings into the CSV file

                writer.append(String.valueOf(r.getUserId()));
                writer.append(COM);
                writer.append(String.valueOf(r.getMovieId()));
                writer.append(COM);
                writer.append(String.valueOf(r.getRating()));
                writer.append(NL);

        } catch(FileNotFoundException fnf) {
            System.out.println("File not found at specified path.");
        } catch(IOException io) {
            System.out.println("Error occurred with I/O.");
            io.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing file writer.");
                e.printStackTrace();
            }

        }
    }

    //calculate initial avg. rating of a movie, by searching the list of movies for its id.
    public static double movieRate(int id) {

        BufferedReader reader = null;
        ArrayList<Double> allRatings = new ArrayList<Double>();
        int numberOfRatings = 0;

        try {
            reader = new BufferedReader(new FileReader("./src/files/ratings.csv"));
            String line = "";
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(COM);
                if (tokens.length > 0) {

                    try {

                        //if the id in this line matches the passed id, add the relevant rating to the list
                        if(Integer.parseInt(tokens[1]) == id);
                        double r = Double.parseDouble(tokens[2]);
                        allRatings.add(r);
                        numberOfRatings++;

                    } catch (NumberFormatException nfe) {
                        System.out.println("Parsed value was not an integer or double.");
                        break;
                    }
                }
            }

        } catch (EOFException eof) {
            System.out.println("Reached end of file, exiting.");
        } catch(FileNotFoundException fnf) {
            System.out.println("File not found at specified path.");
        } catch (IOException io) {
            System.out.println("Error occurred with I/O.");
            io.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch(IOException io) {
                System.out.println("Error occurred while closing reader.");
            }
        }

        // if no ratings could be fetched from the file...
        if (numberOfRatings == 0) {
            System.out.println("Could not calculate a rating for this movie.");
            return -1;

        // if ratings were found, they are summed and divided by the number of ratings to find the mean average
        } else {
            double sum = 0;
            for(Double d : allRatings)
                sum += d;
            return sum/numberOfRatings;
        }

    }


}
