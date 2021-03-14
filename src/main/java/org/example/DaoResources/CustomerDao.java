package org.example.DaoResources;

import org.example.Model.Customer;

import java.util.ArrayList;

public interface CustomerDao
{
    public int add(Customer c);
    public int update(Customer c);
    public int delete(Customer c);
    public Customer findByID(int id);
    public Customer login(String email);
    ArrayList<Customer> getAllCostumer();
}
