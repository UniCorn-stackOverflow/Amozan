package org.example.Controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import org.example.Model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class AmozanMainController implements Initializable
{
    @FXML private Button btnAccount;
    @FXML private Button btnOrderHistory;
    @FXML private Button btnOrder;
    @FXML private ComboBox<String> comboBoxLanguage;
    //private Customer c = new Customer();
    @FXML
    private void showAccount() throws IOException
    {
        MainControl.setRoot("account");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        comboBoxLanguage.getItems().addAll("Deutsch","Englisch");
    }
    @FXML
    private void auswhal(ActionEvent e)
    {
        int language = comboBoxLanguage.getSelectionModel().getSelectedIndex();
        switch(language)
        {
            case 0:
                MainControl.setLocale(new Locale("de","DE"));
                break;
            case 1:
                MainControl.setLocale(new Locale("en","US"));
                break;
        }
    }
}
