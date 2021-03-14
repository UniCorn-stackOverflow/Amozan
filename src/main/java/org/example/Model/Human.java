package org.example.Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Date;

public class Human
{
    protected StringProperty name;
    protected StringProperty surName;
    protected ArrayList<Item> consumerBasket;
    protected StringProperty email;
    protected Date dateOfBirth;

    protected StringProperty gender;


    /*public Human(String name,String sirName,String email,String gender)
    {}*/
    public Human() {}
    public String getName()
    {
        if(this.name != null)
         return this.name.getValue();
        else
            return "";
    }
    public void setName(String name)
    {
        this.nameProperty().set(name);
    }
    public StringProperty nameProperty()
    {
        if(name == null)
        {
            name = new SimpleStringProperty("");
        }
        return name;
    }
    public StringProperty surnameProperty()
    {
        if(surName == null)
        {
            surName = new SimpleStringProperty("");
        }
        return surName;
    }
    public StringProperty emailProperty()
    {
        if(email == null)
        {
            email = new SimpleStringProperty("");
        }
        return email;
    }
    public StringProperty genderProperty()
    {
        if(gender == null)
        {
            gender = new SimpleStringProperty("");
        }
        return gender;
    }
    public String getSurName()
    {
        if(surName != null)
            return this.surName.getValue();
        else
            return "";
    }
    public void setSirName(String surName)
    {
        this.surnameProperty().set(surName);
    }
    public String getEmail()
    {
        if(email != null)
            return this.email.getValue();
        else
            return "";
    }
    public void setEmail(String email)
    {
        this.emailProperty().setValue(email);
    }
    public String getGender()
    {
        return this.gender.getValue();
    }
    public void setGender(String gender)
    {
        this.genderProperty().setValue(gender);
    }
    public Date getDateOfBirth()
    {
        return this.dateOfBirth;
    }
    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }
}
