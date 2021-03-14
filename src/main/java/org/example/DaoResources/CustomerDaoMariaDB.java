package org.example.DaoResources;

import org.example.Model.Customer;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CustomerDaoMariaDB implements CustomerDao
{
    Connection con = null;
    String urlHsql = "jdbc:hsqldb:file:\\D:\\Schule\\FI11-20,21\\java\\Amozan\\src\\DatabaseAmozan.accdb";
    String urlUcan = "jdbc:ucanaccess://D:\\Schule\\FI11-20,21\\java\\Amozan\\src\\Database\\Amozan.accdb";
    Statement stmt = null;
    public CustomerDaoMariaDB()
    {
        try
        {
            //DriverManager.registerDriver(new sun.jdbc.odbc.JdbcOdbcDriver());
            //Class.forName("org.hsqldb.jdbcDriver");
            //con = DriverManager.getConnection(url,"","");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("org.mariadb.jdbc.Driver");
            StringBuilder s = new StringBuilder();
            s.append("jdbc:mariadb://");
            s.append(Config.ip);
            s.append("/");
            s.append(Config.database);

            //con = DriverManager.getConnection("jdbc:mariadb://",Config.ip,"//",Config.database,"//",Config.username,"//",Config.password);
            con = DriverManager.getConnection(s.toString(),Config.username,Config.password);
            //con = DriverManager.getConnection("jdbc:mariadb://localhost/amozan","root","root");
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }
        catch(SQLTimeoutException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public int add(Customer c)
    {
        int isSuccess;
        try
        {
            // this dont work and i dont know why// how to get the data out of 'c' in the sql statement
            //System.out.println(c.getGetDateOfBirth());
            //StringBuilder builder = new StringBuilder();
            //builder.append()
            //String asdf = "Ein Slash im String \\ und das Anführungszeichen\"";
            //System.out.println(asdf);
            //String sql = "INSERT INTO Amozan_Customer(Customer_Firstname,Customer_Lastname,Customer_DateOfBirth,Customer_EMail,Customer_Password )VALUES(\""+c.getName()+"\",\""+c.getSirName()+"\",\""+c.getGetDateOfBirth().toString()+"\",\""+c.getEmail()+"\",\""+c.getPassword()+"\");";
            //PreparedStatement st = con.prepareStatement(sql);
            //int id = calculateID();
            //stmt.addBatch("INSERT INTO Amozan_Customer_Test(Customer_Firstname,Customer_Lastname,Customer_DateOfBirth,Customer_EMail,Customer_Password )VALUES(\""+c.getName()+"\",\""+c.getSirName()+"\",\""+c.getGetDateOfBirth().toString()+"\",\""+c.getEmail()+"\",\""+c.getPassword()+"\");");
            //stmt.addBatch("INSERT INTO Amozan_Customer(Customer_Firstname,Customer_Lastname,Customer_Adress_Nr,Customer_DateOfBirth,Customer_EMail,Customer_Password )VALUES(\""+c.getName()+"\",\""+c.getSirName()+"\",\""+c.getAdressNr()+"\",\""+c.getGetDateOfBirth().toString()+"\",\""+c.getEmail()+"\",\""+c.getPassword()+"\");");
            /**
             * correct statement
             */
            PreparedStatement ps = con.prepareStatement("INSERT INTO CUSTOMER"+ "(CUSTOMER_FIRSTNAME,CUSTOMER_LASTNAME,CUSTOMER_DATEOFBIRTH,CUSTOMER_GENDER,CUSTOMER_EMAIL,CUSTOMER_PASSWORD)"+
                    "VALUES(?,?,?,?,?,?)");
            ps.setString(1, c.getName());
            ps.setString(2, c.getSurName());
            ps.setString(3, c.getDateOfBirth().toString());
            ps.setString(4, c.getGender());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getPassword());
            ps.executeQuery();
            ps.close();
           // stmt.addBatch("INSERT INTO Amozan_Customer(Customer_Firstname,Customer_Lastname,Customer_DateOfBirth,Customer_EMail,Customer_Password )VALUES(\""+c.getName()+"\",\""+c.getSirName()+"\",\""+c.getGetDateOfBirth().toString()+"\",\""+c.getEmail()+"\",\""+c.getPassword()+"\");");

            stmt.executeBatch();//stmt.executeBatch();
            isSuccess = 1;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            isSuccess = -1;
        }

        return isSuccess;
    }
    public int update(Customer c)
    {
        int isSuccess;
        try
        {
            PreparedStatement ps = con.prepareStatement("update customer set  CUSTOMER_FIRSTNAME=?,CUSTOMER_LASTNAME=?,CUSTOMER_DATEOFBIRTH=?,CUSTOMER_EMAIL=?,CUSTOMER_GENDER=? where CUSTOMER_ID=?");
            ps.setString(1, c.getName());
            ps.setString(2, c.getSurName());
            ps.setString(3, c.getDateOfBirth().toString());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getGender());
            ps.setString(6, String.valueOf(c.getCostumerID()));
            ps.executeQuery();
            ps.close();
            isSuccess = 1;
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
            isSuccess = -1;
        }

        return isSuccess;
    }
    public int delete(Customer c)
    {

        return 0;
    }
    public Customer findByID(int id)
    {

        return null;
    }
    public void deleteOnExit() throws SQLException
    {
        PreparedStatement ps = con.prepareStatement("delete from buffered_customer");
        ps.executeQuery();
        ps.close();
    }
    public Customer getBufferedCustomer()
    {
        Customer c = null;
        try
        {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM buffered_customer");
            ResultSet rs = ps.executeQuery();

            while(rs.next())
            {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
                String formattedValue = (rs.getString("CUSTOMER_DATEOFBIRTH")).format(formatter.toString());
                c = new Customer(Integer.parseInt(rs.getString("CUSTOMER_ID")),rs.getString("CUSTOMER_FIRSTNAME"),rs.getString("CUSTOMER_LASTNAME"),rs.getString("CUSTOMER_EMAIL"),Date.valueOf(rs.getString("CUSTOMER_DATEOFBIRTH")),rs.getString("CUSTOMER_GENDER"));
            }
            rs.close();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return c;
    }
    public Customer login(String email)
    {
        try
        {
            /*ResultSet rs = stmt.executeQuery("SELECT * FROM CUSTOMER WHERE CUSTOMER_EMAIL =" + "\"email\"");
            rs.first();
            rs.next();*/
            PreparedStatement ps = con.prepareStatement("SELECT * FROM CUSTOMER WHERE CUSTOMER_EMAIL =?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            Customer c = null;
            //ResultSet rs = ps.getResultSet();
            while(rs.next())
            {
                c = new Customer(Integer.parseInt(rs.getString("CUSTOMER_ID")),rs.getString("CUSTOMER_FIRSTNAME"),rs.getString("CUSTOMER_LASTNAME"),rs.getString("CUSTOMER_EMAIL"),Date.valueOf(rs.getString("CUSTOMER_DATEOFBIRTH")),rs.getString("CUSTOMER_PASSWORD"),rs.getString("CUSTOMER_GENDER"));
            }
            ps.close();
            rs.close();
            return c;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public int writeBufferedCustomer(Customer c)
    {
        int isSuccess = 0;
        try
        {
            PreparedStatement ps = con.prepareStatement("INSERT INTO BUFFERED_CUSTOMER"+ "(CUSTOMER_ID,CUSTOMER_FIRSTNAME,CUSTOMER_LASTNAME,CUSTOMER_DATEOFBIRTH,CUSTOMER_GENDER,CUSTOMER_EMAIL)"+
                    "VALUES(?,?,?,?,?,?)");
            ps.setString(1,String.valueOf(c.getCostumerID()));
            ps.setString(2, c.getName());
            ps.setString(3, c.getSurName());
            ps.setString(4, c.getDateOfBirth().toString());
            ps.setString(5, c.getGender());
            ps.setString(6, c.getEmail());

            ps.executeQuery();
            ps.close();
            isSuccess = 1;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            isSuccess = -1;
        }
        return isSuccess;
    }
    public ArrayList<Customer> getAllCostumer()
    {
        ArrayList<Customer> arl = new ArrayList<Customer>();
        try
        {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Amozan_Customer");
            while(rs.next())
            {
                //Customer c = new Customer(Integer.parseInt(rs.getString("Customer_ID")),rs.getString("Customer_Firstname"),rs.getString("Customer_Lastname"),rs.getString("Customer_EMail"),rs.getString("Customer_Password"),rs.getString("Customer_Gender"),rs.getString("Customer_DateOfBirth"));
               // arl.add(c);
            }
            rs.close();
            return arl;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }


    }
}
