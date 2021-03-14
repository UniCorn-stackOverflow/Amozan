package org.example.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class Customer extends Human
{
    //private ArrayList<Order> OrderHistory;
    private StringProperty password;
    private int customerID;
    private IntegerProperty adressNr;
    /**
     * @Costumer for the costumer from the Database
     */
    public Customer(int costumerID, String name, String sirName, String email, Date dateOfBirth, String password, String gender)
    {
        this.customerID = costumerID;
        this.setName(name);
        this.setSirName(sirName);
        this.setEmail(email);
        this.setPassword(password);
        this.setGender(gender);
        this.dateOfBirth = dateOfBirth;
    }
    public Customer(){}
    public Customer(int customerID,String name,String lastName,String email,Date dateOfBirth,String gender)
    {
        this.customerID = customerID;
        this.setName(name);
        this.setSirName(lastName);
        this.setEmail(email);
        this.setGender(gender);

        this.setDateOfBirth( dateOfBirth);


    }
    /*public Costumer(String name,String sirName,String email,String password,String gender,String dateOfBirth)
    {
        this.name = name;
        this.sirName = sirName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");

        this.dateOfBirth = Date.valueOf(dateOfBirth);
        consumerBasket = new ArrayList<Item>();
    }*/
    /*public Costumer(int costumerID,String name,String sirName,String email,String password,String gender,String dateOfBirth)
    {
        this.costumerID = costumerID;
        this.name = name;
        this.sirName = sirName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        this.adressNr = 1;
        this.dateOfBirth = Date.valueOf(dateOfBirth);
        consumerBasket = new ArrayList<Item>();
    }*/

    public ArrayList<Item> getConsumerBasket()
    {
        return consumerBasket;
    }

    public void setConsumerBasket(ArrayList<Item> consumerBasket)
    {
        this.consumerBasket = consumerBasket;
    }

    /*public ArrayList<Order> getOrderHistory()
    {
        return OrderHistory;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory)
    {
        OrderHistory = orderHistory;
    }*/

    /*public String getName()
    {
        return name;
    }

    public String getSirName()
    {
        return sirName;
    }

    public String getEmail()
    {
        return email;
    }
    public Date getGetDateOfBirth()
    {
        return this.dateOfBirth;
    }*/
    public String getPassword()
    {
        return this.password.getValue();
    }
    public StringProperty passwordProperty()
    {
        if(password == null)
        {
            password = new SimpleStringProperty("");
        }
        return password;
    }

    public void setPassword(String password)
    {
        this.passwordProperty().set(password);
    }
    public int getCostumerID()
    {
        return this.customerID;
    }
    public int getAdressNr()
    {
        return this.adressNr.getValue();
    }

}

