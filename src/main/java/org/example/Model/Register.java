package org.example.Model;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import org.example.Controler.MainControl;
import org.example.DaoResources.CustomerDaoMariaDB;

import java.util.Date;

public class Register
{
    public Register()
    {

    }
    public boolean RegisterCustomer(Customer c ,String gender,String password,String passwordRepeat)
    {
        boolean isRegistered = false;
        if(password.hashCode() != passwordRepeat.hashCode())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Password Error", ButtonType.YES,ButtonType.CANCEL);
            alert.showAndWait();
            if(alert.getResult() == ButtonType.YES)
            {
                alert.close();
            }
        }
        else
        {
            PasswordAuthentication pwa = new PasswordAuthentication();
            c.setPassword(pwa.hash(password.toCharArray()));
            c.setGender(gender);
            CustomerDaoMariaDB daoM = new CustomerDaoMariaDB();
            int isSuccess = daoM.add(c);
            if(isSuccess == 1)
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION,"",ButtonType.OK);
                alert.setHeaderText("Success");
                alert.setContentText("You have registered successfully!. now you will return to the login");
                alert.showAndWait();
                if(alert.getResult() == ButtonType.OK)
                {
                   isRegistered = true;
                }
            }
        }
        return isRegistered;
    }
}
