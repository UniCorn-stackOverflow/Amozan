package org.example.Controler;

import java.io.IOException;

import org.example.Model.Login;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML private Button registerButton;
    @FXML private TextField txtFieldEmail;
    @FXML private PasswordField passwordFieldPassword;
    @FXML
    private void Register() throws IOException
    {

        MainControl.setRoot("register");
    }
    @FXML
    private void Login() throws IOException
    {
        Login l = new Login();
        boolean isSuccess = l.checkLogin(txtFieldEmail.getText(), passwordFieldPassword.getText());
        if(isSuccess)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,"",ButtonType.OK);
            alert.setContentText("Your Login was Successful!");
            MainControl.setRoot("amozanMainView");
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,"",ButtonType.OK);
            alert.setContentText("There was a Login problem, please try again");
            alert.showAndWait();
            if(alert.getResult() == ButtonType.OK)
            {
                MainControl.setRoot("login");
            }
        }
    }

}
