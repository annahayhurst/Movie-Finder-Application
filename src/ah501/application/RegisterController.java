package ah501.application;

import ah501.movies.Movie;
import ah501.movies.MovieReg;
import ah501.registration.Registry;
import ah501.registration.User;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* Author: ah501
* This controller handles the FXML features, navigation and other methods
* of the MovieFinder JavaFX application.
*/

public class RegisterController {

    // Attributes
    private Registry reg;
    private MovieReg mreg;
    private User activeUser;

    // FXML attributes as required for handler methods.
    @FXML
    private PasswordField pwSignup, pwField;

    @FXML
    private Label loginError, signupError;

    @FXML
    private Button login, signup,loginSubmit,loginCancel, signupSubmit, signupCancel,
    search, clear, randomise, back;

    @FXML
    private TextField unameField, usernameField, nameField, emailField, searchField;

    @FXML
    private MenuItem newMovie, newRating, exit, about, logout;

    @FXML
    private ListView<String> movieList, searchResults;


    // Handler methods for FXML elements.

    @FXML
    void onLogin(ActionEvent event) throws IOException {
        Stage stage;
        if(event.getSource()==login) {
            stage = (Stage) login.getScene().getWindow();
            stage.setScene(SceneManager.createFXMLScene("LoginForm.fxml"));
            stage.show();
        }
    }

    @FXML
    void onSubmitLogin(ActionEvent event) throws IOException {
        Stage stage;
        if(event.getSource() == loginSubmit) {
            reg = new Registry();

            for(User u : reg.getRegister()) {
                if (usernameField.getText().equals(u.getUsername())) {
                    if (pwField.getText().equals(u.getPassword())) {
                        stage = (Stage) loginSubmit.getScene().getWindow();
                        stage.setScene(SceneManager.createFXMLScene("MainView.fxml"));
                        stage.show();
                    }
                }

            }

            loginError.setText("Invalid username or password.");
            if(usernameField.getText().equals("")){
                loginError.setText("Please enter a username");
            }
            if(pwField.getText().equals("")) {
                loginError.setText("Please enter a password");
            }



        }


    }

    @FXML
    void onSignup(ActionEvent event) throws IOException {
        Stage stage;
        if(event.getSource() == signup) {
            stage = (Stage) signup.getScene().getWindow();
            stage.setScene(SceneManager.createFXMLScene("SignupForm.fxml"));
            stage.show();
        }
    }

    @FXML
    void onSignupSubmit(ActionEvent event) throws IOException {
        Stage stage;
        if (event.getSource() == signupSubmit) {
            if (nameField.getText().isEmpty() || unameField.getText().isEmpty() || emailField.getText().isEmpty() || pwSignup.getText().isEmpty()) {
                signupError.setText("Please enter all the required information.");
            } else if (!emailField.getText().contains("@")){
                signupError.setText("Please enter a valid email address.");
            } else {
                reg = new Registry();

                boolean exists = false;
                for (User u : reg.getRegister()) {
                    if (u.getUsername().equals(unameField.getText())) {
                        signupError.setText("Username already exists.");
                        exists = true;
                    }

                }

                if (!exists) {
                    User n = new User(unameField.getText(), nameField.getText(), emailField.getText(), pwSignup.getText());
                    reg.addUser(n);
                    activeUser = n;
                    stage = (Stage) signupSubmit.getScene().getWindow();
                    stage.setScene(SceneManager.createFXMLScene("LoginForm.fxml"));
                    stage.show();
                }

            }

        }
    }

    @FXML
    void returnHome(ActionEvent event) throws IOException {
        Stage stage;
        if(event.getSource()==signupCancel) {
            stage = (Stage) signupCancel.getScene().getWindow();
            stage.setScene(SceneManager.createFXMLScene("StartScreen.fxml"));
            stage.show();
        }

        if(event.getSource()==loginCancel) {
            stage = (Stage) loginCancel.getScene().getWindow();
            stage.setScene(SceneManager.createFXMLScene("StartScreen.fxml"));
            stage.show();
        }

        if(event.getSource() == logout) {
            activeUser = null;
            stage = (Stage) clear.getScene().getWindow();
            stage.setScene(SceneManager.createFXMLScene("StartScreen.fxml"));
            stage.show();
        }
    }

    @FXML
    void onAbout(ActionEvent event) throws IOException {
        Stage stage;
        if(event.getSource() == about) {
            stage = (Stage) randomise.getScene().getWindow();
            stage.setScene(SceneManager.createFXMLScene("About.fxml"));
            stage.show();
        }
    }

    @FXML
    void onClear(ActionEvent event) {
        searchField.clear();
    }

    @FXML
    void onExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onNewM(ActionEvent event) {

    }

    @FXML
    void onSubmitM(ActionEvent event) {

    }

    @FXML
    void onNewR(ActionEvent event) {

    }

    @FXML
    void onRandom(ActionEvent event) {
        ObservableList<String> random = RegisterController.randomise();
        movieList.setItems(random);

    }

    @FXML
    void onSearch(ActionEvent event) throws IOException {
        Stage stage;
        stage = (Stage) search.getScene().getWindow();
        stage.show();

    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
        Stage stage;
        if(event.getSource()==back) {
            stage = (Stage) back.getScene().getWindow();
            stage.setScene(SceneManager.createFXMLScene("MainView.fxml"));
            stage.show();
        }
    }

    // Helper methods

    private static ObservableList<String> randomise(){
        ObservableList<String> toReturn = FXCollections.<String>observableArrayList();
        toReturn.add("-----------------------------------------------");
        toReturn.add("Title (Year)   ||   Genres   ||   Average Rating");
        toReturn.add("-----------------------------------------------");
        List<Integer> randomiser = Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        Collections.shuffle(randomiser);

        MovieReg movies = new MovieReg();

        for(int i = 0; i < 5; i++) {
            int element = randomiser.get(i);

            toReturn.add(movies.getMovies().get(element).toString());
            if(i < 4) {
            toReturn.add("~ * ~"); }
        }

        return toReturn;

    }



}
