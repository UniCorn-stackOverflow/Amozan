package org.example.Model;

import org.example.DaoResources.CustomerDaoMariaDB;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.IOException;

public class Login
{


    public Login() throws IOException
    {

    }
    public boolean checkLogin(String email, String pw)
    {
        boolean isSuccess = false;

        CustomerDaoMariaDB daoM = new CustomerDaoMariaDB();
        Customer c = daoM.login(email);
        if (c != null)
        {
            PasswordAuthentication pwA = new PasswordAuthentication();
            if (pwA.authenticate(pw.toCharArray(), c.getPassword()))
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
                alert.setContentText("Login was Successful");
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK)
                {
                    int isSuccess2 = daoM.writeBufferedCustomer(c);
                    if (isSuccess2 == 1)
                    {
                        isSuccess = true;
                        //MainControl.setRoot("amozanMainView");

                    }
                }
            }
        }
        return isSuccess;
    }
}

