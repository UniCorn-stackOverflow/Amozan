package org.example.Controler;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.example.Model.Customer;
import org.example.Model.PasswordAuthentication;
import org.example.DaoResources.CustomerDaoMariaDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.Model.Register;

import java.sql.Date;

public class RegisterController implements Initializable
{
    Customer c = new Customer();
    @FXML private ComboBox<String> comboBoxSalutation;
    @FXML private TextField txtFieldFirstname;
    @FXML private TextField txtFieldSurname;
    @FXML private TextField txtFieldEmail;
    @FXML private DatePicker datePickerDate;
    @FXML private PasswordField passwordFieldPassword;
    @FXML private PasswordField passwordFieldPasswordRepeat;
    @FXML private Button Register;

    @FXML
    private void switchToPrimary() throws IOException {
        MainControl.setRoot("primary");
    }
    // wird als aller erstes ausgeführt also direkt nachdem das fxml ausgeführt wurde also müssen da alle daen und bidings usw rein
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<String> olSalutation = FXCollections.observableArrayList("Male","Female","Other");
        comboBoxSalutation.setItems(olSalutation);

        txtFieldFirstname.textProperty().bindBidirectional(c.nameProperty());
        txtFieldSurname.textProperty().bindBidirectional(c.surnameProperty());
        txtFieldEmail.textProperty().bindBidirectional(c.emailProperty());

        // das numberFormat.getInstance bei int oder double !
        //txtFieldName.textProperty().bindBidirectional(c.nameProperty(), NumberFormat.getInstance());

    }
    @FXML
    private void registerCustomer() throws IOException
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd",Locale.GERMAN);
        String formattedValue = (datePickerDate.getValue()).format(formatter);
        c.setDateOfBirth(Date.valueOf(formattedValue));
        org.example.Model.Register r = new Register();
        boolean isRegistered = r.RegisterCustomer(c, comboBoxSalutation.getValue(), passwordFieldPassword.getText(),passwordFieldPasswordRepeat.getText());
        if(isRegistered)
        {
            MainControl.setRoot("login");
        }
    }
}