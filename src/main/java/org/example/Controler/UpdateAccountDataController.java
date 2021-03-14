package org.example.Controler;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.example.DaoResources.CustomerDaoMariaDB;
import org.example.Model.Customer;
import org.example.Model.UpdateAccountDataModel;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class UpdateAccountDataController implements Initializable
{
    @FXML private TextField txtFieldFirstname;
    @FXML private TextField txtFieldLastname;
    @FXML private TextField txtFieldEmail;
    @FXML private DatePicker datePickerDateOfBirth;
    @FXML private TextField txtFieldGender;

    Customer c = null;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        CustomerDaoMariaDB daoM = new CustomerDaoMariaDB();
        c = daoM.getBufferedCustomer();
        txtFieldFirstname.setText(c.getName());
        txtFieldLastname.setText(c.getSurName());
        txtFieldEmail.setText(c.getEmail());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate localDate = LocalDate.parse(c.getDateOfBirth().toString(), formatter);
        datePickerDateOfBirth.setValue(localDate);
        txtFieldGender.setText(c.getGender());
    }
    public void updateAccountData() throws IOException
    {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        String formattedValue = (datePickerDateOfBirth.getValue()).format(formatter);
        Date d = (Date.valueOf(formattedValue));
        Customer updatedCustomer = new Customer(c.getCostumerID(),txtFieldFirstname.getText(),txtFieldLastname.getText(),txtFieldEmail.getText(),d,txtFieldGender.getText());

        UpdateAccountDataModel uADModel = new UpdateAccountDataModel(updatedCustomer);
        int isSuccess = uADModel.updateData();
        if(isSuccess == 1)
        {
            MainControl.setRoot("amozanMainView");
        }
    }
    public void changePassword()
    {

    }
}
