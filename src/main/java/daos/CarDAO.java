package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.CarDTO;

//concrete class
public class CarDAO implements ICarDAO {

    @Override
    public CarDTO findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM car_table WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<CarDTO> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT * FROM car_table");
            ResultSet rs = ps.executeQuery();
            List<CarDTO> carList = new ArrayList<>();

            while (rs.next()) {
                CarDTO carDTO = extractUserFromResultSet(rs);
                carList.add(carDTO);

            }
            return carList;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public CarDTO update(CarDTO dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "UPDATE car_table SET id=?, make=?, model=?, color=?, year=?, vin=?");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getMake());
            ps.setString(3, dto.getModel());
            ps.setString(4, dto.getColor());
            ps.setInt(5, dto.getYear());
            ps.setString(6, dto.getVin());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dto;
    }

    @Override
    public CarDTO create(CarDTO dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO car_table VALUES (id=?, make=?, model=?, color=?, year=?, vin=?)");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getMake());
            ps.setString(3, dto.getModel());
            ps.setString(4, dto.getColor());
            ps.setInt(5, dto.getYear());
            ps.setString(6, dto.getVin());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dto;
    }

    @Override
    public void delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.createStatement();
            ps.executeUpdate("DELETE FROM car_table WHERE id=" + id);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public CarDTO extractUserFromResultSet(ResultSet rs) throws SQLException {
        CarDTO car = new CarDTO();

        car.setId(rs.getInt("id"));
        car.setMake(rs.getString("make"));
        car.setModel(rs.getString("model"));
        car.setColor(rs.getString("color"));
        car.setYear(rs.getInt("year"));
        car.setVin(rs.getString("vin"));

        return car;
    }

}
