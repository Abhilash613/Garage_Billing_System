package service;

import config.DbConfig;
import entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    // ✅ Add customer and auto-generate ID
    public void addCustomer(Customer customer) throws SQLException {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO customers (name, phone) VALUES (?, ?)",
                Statement.RETURN_GENERATED_KEYS
        );
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getPhone());
        ps.executeUpdate();

        // ✅ Get generated ID from DB and set in object
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            customer.setId(rs.getInt(1));
        }

        rs.close();
        ps.close();
        conn.close();
    }

    // ✅ Get all customers
    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> list = new ArrayList<>();
        Connection conn = DbConfig.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM customers");

        while (rs.next()) {
            Customer customer = new Customer(
                    rs.getString("name"),
                    rs.getString("phone")
            );
            customer.setId(rs.getInt("id")); // Auto-set ID
            list.add(customer);
        }

        rs.close();
        st.close();
        conn.close();
        return list;
    }

    // ✅ Get single customer by phone number
    public Customer getCustomerByPhone(String number) throws SQLException {
        Customer customer = null;
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM customers WHERE phone = ?");
        ps.setString(1, number);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            customer = new Customer(
                    rs.getString("name"),
                    rs.getString("phone")
            );
            customer.setId(rs.getInt("id")); // Set the auto-generated ID
        }

        rs.close();
        ps.close();
        conn.close();
        return customer;
    }
}
