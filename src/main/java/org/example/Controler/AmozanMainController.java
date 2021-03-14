package org.example.Controler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.Model.Customer;

import java.io.IOException;

public class AmozanMainController
{
    @FXML private Button btnAccount;
    @FXML private Button btnOrderHistory;
    @FXML private Button btnOrder;
    //private Customer c = new Customer();
    @FXML
    private void showAccount() throws IOException
    {
        MainControl.setRoot("account");
    }
}
