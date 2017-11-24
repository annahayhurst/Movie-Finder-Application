package ah501.movies;

import java.io.*;
import java.util.ArrayList;


public class MovieIO {

    private static final String COM = ",";
    private static final String NL = "\n";


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


}
