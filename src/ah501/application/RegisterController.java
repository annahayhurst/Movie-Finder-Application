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

public class RegisterController {

    // fxml attributes

    @FXML
    private Label unamePrompt;

    @FXML
    private Label pwPrompt;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField pwSignup;

    @FXML
    private Button loginSubmit;

    @FXML
    private Button loginCancel;

    @FXML
    private Label loginError;

    @FXML
    private Button login;

    @FXML
    private Button signup;

    @FXML
    private TextField unameField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField pwField;

    @FXML
    private Button signupSubmit;

    @FXML
    private Button signupCancel;



    // handler methods

    @FXML
    void onLogin(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        if(event.getSource()==login) {
            stage = (Stage) login.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
        }



    }

    @FXML
    void onSignup(ActionEvent event) {

    }

    @FXML
    void onSubmitLogin(ActionEvent event) {

    }

    @FXML
    void returnHome(ActionEvent event) throws IOException {
        Parent root;
        Stage stage;
        if(event.getSource()==signupCancel) {
            //get reference to the button's stage
            stage = (Stage) signupCancel.getScene().getWindow();
            //load up OTHER FXML document
            root = FXMLLoader.load(getClass().getResource("../../../StartScreen.fxml"));
        }

        if(event.getSource()==loginCancel) {
            stage = (Stage) loginCancel.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("../../../StartScreen.fxml"));
        }
    }

    @FXML
    void onSignupSubmit(ActionEvent event) {

    }



}
