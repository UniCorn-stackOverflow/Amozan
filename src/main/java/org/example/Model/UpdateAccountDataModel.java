package org.example.Model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.example.Controler.MainControl;
import org.example.DaoResources.CustomerDaoMariaDB;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateAccountDataModel
{
    Customer c = null;
    public UpdateAccountDataModel(Customer customer) throws IOException
    {
        c = customer;
    }
    public int updateData()
    {

        CustomerDaoMariaDB daoM = new CustomerDaoMariaDB();
        int isSuccess = daoM.update(c);
        try
        {
            daoM.deleteOnExit();
            daoM.writeBufferedCustomer(c);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        Alert alert;
        if(isSuccess == 1)
        {
            alert = new Alert(Alert.AlertType.INFORMATION, "Success", ButtonType.OK);
            alert.setContentText("your Account Data has been updated successfully");


        }
        else
        {
            alert = new Alert(Alert.AlertType.ERROR, "Fail", ButtonType.OK);
            alert.setContentText("There went something wrong with the update of your Account Data");
        }
        alert.showAndWait();
        return isSuccess;
    }

}
