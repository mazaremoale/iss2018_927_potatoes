package blood_donation.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController
{
    private String adminUsername = "root";
    private String adminPassword = "cartofi3";

    private Stage primaryStage;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordField;

    LoginController(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }

    public void login() throws Exception
    {
        if (usernameTextField.getText().equals(adminUsername)
                && passwordField.getText().equals(adminPassword))
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/adminWindow.fxml"));
            loader.setController(new AdminController());
            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Admin");

        }
    }

}
