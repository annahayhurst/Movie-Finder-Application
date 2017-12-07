package ah501.movies;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

/*
* Author: ah501
* A class purely for file handling, supporting Movie, Rating and MovieReg classes.
* Contains static methods which open the correct CSV file, and then either fetch information from it
* or write passed information to it.
 */
public class MovieIO implements Symbols{



    // Read ratings from the Ratings.csv file and return them as an ArrayList.
    public static ArrayList<Rating> readRating() {
        BufferedReader reader = null;
        ArrayList<Rating> ratings = new ArrayList<Rating>();

        try {
            reader = new BufferedReader(new FileReader("./src/files/ratings.csv"));
            String line = "";
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(COMMA);
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
            } catch (NullPointerException npe) {
                System.out.println("Null pointer exception occurred while attempting to flush or close.");
                npe.printStackTrace();
            }
        }

    return ratings;
    }

    // Writes the passed ending to a new line at the end of the Ratings.csv file.
    public static void writeRating(Rating r) {

        FileWriter writer = null;

        try {
            writer = new FileWriter("./src/files/ratings.csv", true);
            //Write the new ratings into the CSV file

                writer.append(String.valueOf(r.getUserId()));
                writer.append(COMMA);
                writer.append(String.valueOf(r.getMovieId()));
                writer.append(COMMA);
                writer.append(String.valueOf(r.getRating()));
                writer.append(NEWLINE);

        } catch(FileNotFoundException fnf) {
            System.out.println("File not found at specified path.");
        } catch(IOException io) {
            System.out.println("Error occurred with I/O.");
            io.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            }catch (NullPointerException npe) {
                System.out.println("Null pointer exception occurred while attempting to flush or close.");
                npe.printStackTrace();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing file writer.");
                e.printStackTrace();
            }

        }
    }


    // Read movies from the MovieData.csv file and return them as an ArrayList.
    // This file is a shortened version of the full Movies.csv.
    public static ArrayList<Movie> readMovie() {
        BufferedReader reader = null;
        ArrayList<Movie> movies = new ArrayList<Movie>();

        try {
            reader = new BufferedReader(new FileReader("./src/files/MovieData.csv"));
            String line = "";
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(COMMA);
                if (tokens.length > 0) {

                    try {
                        int id = Integer.parseInt(tokens[0]);
                        String name = (tokens[1]);
                        String genres = (tokens[2]);
                        Movie m = new Movie(id, name, genres);
                        movies.add(m);

                    } catch (NumberFormatException nfe) {
                        System.out.println("Parsed id value was not an integer.");
                        break;
                    }
                }
            }

        } catch (EOFException eof) {
            System.out.println("Reached end of file, exiting.");
        } catch (FileNotFoundException fnf) {
            System.out.println("File not found at specified path.");
        } catch (IOException io) {
            System.out.println("Error occurred with I/O.");
            io.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException io) {
                System.out.println("Error occurred while closing reader.");
            } catch (NullPointerException npe) {
                System.out.println("Null pointer exception occurred while attempting to flush or close.");
                npe.printStackTrace();
            }
        }
    return movies;
    }

    // Writes passed movie object as ID, name and genre to the end of the MovieData.csv file.
    public static void writeMovie(Movie m) {

        FileWriter writer = null;

        try {
            writer = new FileWriter("./src/files/MovieData.csv", true);

            writer.append(String.valueOf(m.getMovieId()));
            writer.append(COMMA);
            writer.append(String.valueOf(m.getName()));
            writer.append(COMMA);
            writer.append(String.valueOf(m.getGenre()));
            writer.append(NEWLINE);

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
                System.out.println("Error occurred while closing file writer.");
                e.printStackTrace();
            } catch (NullPointerException npe) {
                System.out.println("Null pointer exception occurred while attempting to flush or close.");
                npe.printStackTrace();
            }

        }
    }



    // Calculate initial avg. rating of a movie, by searching the list of movies for its id and collecting
    // the related ratings. It then sums them and finds the mean value.
    public static double movieRate(int id) {

        BufferedReader reader = null;
        ArrayList<Double> allRatings = new ArrayList<Double>();
        int numberOfRatings = 0;

        try {
            reader = new BufferedReader(new FileReader("./src/files/ratings.csv"));
            String line = "";
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(COMMA);
                if (tokens.length > 0) {

                    try {

                        //if the id in this line matches the passed id, add the relevant rating to the list
                        if(Integer.parseInt(tokens[1]) == id) {
                            double r = Double.parseDouble(tokens[2]);
                            allRatings.add(r);
                            numberOfRatings++;
                        }

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
            } catch (NullPointerException npe) {
                System.out.println("Null pointer exception occurred while attempting to flush or close.");
                npe.printStackTrace();
            }
        }

        // if no ratings could be fetched from the file...
        if (numberOfRatings == 0) {
            System.out.println("Could not calculate a rating for this movie.");
            return 0;

        // if ratings were found, they are summed and divided by the number of ratings to find the mean average
        } else {
            double sum = 0;

            for(Double d : allRatings)
                sum += d;
            return sum/numberOfRatings;
        }

    }

    // Counts how many ratings exist for a given movie by its ID in the Ratings.csv file
    // This is implemented purely so that when a new rating is added, this information is available to calculate
    // the new mean value.
    public static int numberOfRatings(int id) {

        BufferedReader reader = null;
        int numberOfRatings = 0;

        try {
            reader = new BufferedReader(new FileReader("./src/files/ratings.csv"));
            String line = "";
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(COMMA);
                if (tokens.length > 0) {

                    try {

                        //if the id in this line matches the passed id, add the relevant rating to the list
                        if(Integer.parseInt(tokens[1]) == id);
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
            } catch (NullPointerException npe) {
                System.out.println("Null pointer exception occurred while attempting to flush or close.");
                npe.printStackTrace();
            }
        }

            return numberOfRatings;


    }

    // Checks if a given user has already given a rating for a film.
    // If they have it breaks from the loop and returns true.
    public static boolean existsRating(int userId, int movieId) {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("./src/files/ratings.csv"));
            String line = "";
            reader.readLine();

            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(COMMA);
                if (tokens.length > 0) {

                    try {

                       if (Integer.parseInt(tokens[0]) == userId && Integer.parseInt(tokens[1]) == movieId) {
                           return true;
                       }
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
            } catch (NullPointerException npe) {
                System.out.println("Null pointer exception occurred while attempting to flush or close.");
                npe.printStackTrace();
            }
        }

        return false;


    }

}
