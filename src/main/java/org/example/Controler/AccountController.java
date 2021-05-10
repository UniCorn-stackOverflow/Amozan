package org.example.Controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.DaoResources.CustomerDaoMariaDB;
import org.example.Model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class AccountController implements Initializable
{
    @FXML private Label lblFirstname;
    @FXML private Label lblLastname;
    @FXML private Label lblEmail;
    @FXML private Label lblDateOfBirth;
    @FXML private Label lblGender;
    @FXML private Button btnEditData;

    //multilanguage
    @FXML private Label sAccFirstname;
    @FXML private Label sAccLastname;
    @FXML private Label sAccEmail;
    @FXML private Label sAccDateOfBirth;
    @FXML private Label sAccGender;
    @FXML private Label sAccTitle;

    Customer c = null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        CustomerDaoMariaDB daoM = new CustomerDaoMariaDB();
        c = daoM.getBufferedCustomer();
        lblFirstname.textProperty().bind(c.nameProperty());
        lblLastname.textProperty().bind(c.surnameProperty());
        lblEmail.textProperty().bind(c.emailProperty());
        lblDateOfBirth.setText(c.getDateOfBirth().toString());
        lblGender.textProperty().bind(c.genderProperty());
        updateUI();
    }
    public void editData() throws IOException
    {
        MainControl.setRoot("editAccountData");
    }

    private void updateUI()
    {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Sprachen2",MainControl.getLocale());
        sAccFirstname.setText(resourceBundle.getString("sAccFirstname"));
        sAccLastname.setText(resourceBundle.getString("sAccLastname"));
        sAccEmail.setText(resourceBundle.getString("sAccEmail"));
        sAccDateOfBirth.setText(resourceBundle.getString("sAccDateOfBirth"));
        sAccGender.setText(resourceBundle.getString("sAccGender"));
        btnEditData.setText(resourceBundle.getString("btnEditData"));
        //sAccTitle.setText(resourceBundle.getString("sAccTitle"));


    }

}
