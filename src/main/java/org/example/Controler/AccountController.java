package org.example.Controler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.DaoResources.CustomerDaoMariaDB;
import org.example.Model.Customer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountController implements Initializable
{
    @FXML private Label lblFirstname;
    @FXML private Label lblLastname;
    @FXML private Label lblEmail;
    @FXML private Label lblDateOfBirth;
    @FXML private Button btnEditData;
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
    }
    public void editData() throws IOException
    {
        MainControl.setRoot("editAccountData");
    }
}
