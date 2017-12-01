package ah501.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/*
* Author: ah501
* This controller handles the FXML features, navigation and other methods
* of the MovieFinder JavaFX application.
*/

public class RegisterController {

    // FXML attributes as required for handler methods.

    @FXML
    private PasswordField pwSignup, pwField;

    @FXML
    private Label loginError;

    @FXML
    private Button login, signup,loginSubmit,loginCancel, signupSubmit, signupCancel;

    @FXML
    private TextField unameField, usernameField, nameField, emailField;


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
    void onSubmitLogin(ActionEvent event) {

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





}
