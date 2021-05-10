package org.example.Controler;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.example.Model.Login;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController implements Initializable
{

    @FXML private Button registerButton;
    @FXML private TextField txtFieldEmail;
    @FXML private PasswordField passwordFieldPassword;
    @FXML private ComboBox<String> comboBoxLanguage;

    //Language
    @FXML private Label loginEmail;
    @FXML private Label loginPassword;
    @FXML private Label loginLanguage;
    @FXML private Button btnLogin;
    @FXML private Button continueAsGuestButton;
    @FXML private Label loginTitle;



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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        comboBoxLanguage.getItems().addAll("Deutsch","Englisch");
        updateUI();
    }
    @FXML
    private void auswahl(ActionEvent event)
    {
        int language = comboBoxLanguage.getSelectionModel().getSelectedIndex();
        switch(language)
        {
            case 0:
                MainControl.setLocale(new Locale("de","DE"));
                //ResourceBundle.getBundle("Sprachen2",MainControl.getLocale());
                break;
            case 1:
                MainControl.setLocale(new Locale("en","US"));
                //ResourceBundle.getBundle("Sprachen2",MainControl.getLocale());
                break;
        }
        updateUI();
    }
    private void updateUI()
    {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Sprachen2",MainControl.getLocale());
        registerButton.setText(resourceBundle.getString("registerButton"));
        btnLogin.setText(resourceBundle.getString("btnLogin"));
        continueAsGuestButton.setText(resourceBundle.getString("continueAsGuestButton"));
        loginEmail.setText(resourceBundle.getString("loginEmail"));
        loginLanguage.setText(resourceBundle.getString("loginLanguage"));
        loginTitle.setText(resourceBundle.getString("loginTitle"));
        loginPassword.setText(resourceBundle.getString("loginPassword"));

    }
}
