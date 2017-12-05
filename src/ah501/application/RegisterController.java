package ah501.application;

import ah501.movies.MovieReg;
import ah501.registration.Registry;
import ah501.registration.User;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

/*
* Author: ah501
* This controller handles the FXML features, navigation and other methods
* of the MovieFinder JavaFX application.
*/

public class RegisterController {

    // Attributes
    private Registry reg;
    private MovieReg mreg;

    // FXML attributes as required for handler methods.
    @FXML
    private PasswordField pwSignup, pwField;

    @FXML
    private Label loginError;

    @FXML
    private Button login, signup,loginSubmit,loginCancel, signupSubmit, signupCancel,
    search, clear, randomise;

    @FXML
    private TextField unameField, usernameField, nameField, emailField, searchField;

    @FXML
    private MenuItem newMovie, newRating, exit, about, logout;

    @FXML
    private ListView<?> movieList;


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
                if (usernameField.getText() == u.getUsername()) {
                    if (pwField.getText() == u.getPassword()) {
                        stage = (Stage) signup.getScene().getWindow();
                        stage.setScene(SceneManager.createFXMLScene("MainView.fxml"));
                        stage.show();
                    }
                }

            }

            loginError.setText("Invalid username or password.");
            if(usernameField.getText() == ""){
                loginError.setText("Please enter a username");
            }
            if(pwField.getText() == "") {
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
    void onSignupSubmit(ActionEvent event) {

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
    }

    @FXML
    void onAbout(ActionEvent event) {

    }

    @FXML
    void onClear(ActionEvent event) {

    }

    @FXML
    void onExit(ActionEvent event) {

    }

    @FXML
    void onNewM(ActionEvent event) {

    }

    @FXML
    void onNewR(ActionEvent event) {

    }

    @FXML
    void onRandom(ActionEvent event) {

    }

    @FXML
    void onSearch(ActionEvent event) {

    }

    // Helper methods




}
