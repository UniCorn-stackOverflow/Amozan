package org.example.Controler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.DaoResources.CustomerDaoMariaDB;
import org.example.Model.Customer;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateAccountDataController implements Initializable
{
    @FXML private Label lblFirstname;
    @FXML private Label lblLastname;
    @FXML private Label lblEmail;
    @FXML private Label lblDateOfBirth;

    Customer c = null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        CustomerDaoMariaDB daoM = new CustomerDaoMariaDB();
        c = daoM.getBufferedCustomer();
        lblFirstname.setText(c.getName());
        lblLastname.setText(c.getSurName());
        lblEmail.setText(c.getEmail());
        lblDateOfBirth.setText(c.getDateOfBirth().toString());
    }
    public void updateAccountData()
    {
        Customer updatedCustomer = new Customer(lblFirstname.getText(),lblLastname.getText(),lblEmail.getText(),lblDateOfBirth.getText());
    }
    public void changePassword()
    {

    }
}
