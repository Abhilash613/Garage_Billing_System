package service;

import config.DbConfig;
import entity.Vehicle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleService {

    public void addVehicle(Vehicle vehicle) throws SQLException {
        Connection conn = DbConfig.getConnection();
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO vehicles (number, model, customer_id) VALUES (?, ?, ?)"
        );
        ps.setString(1, vehicle.getNumber());
        ps.setString(2, vehicle.getModel());
        ps.setInt(3, vehicle.getCustomerId());

        ps.executeUpdate();
        ps.close();
        conn.close();
    }

    // You can also add getAllVehicles() later if needed
}
