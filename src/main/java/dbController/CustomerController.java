package dbController;

import model.BoardDTO;
import model.CustomerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerController {
    private Connection connection;

    public CustomerController(Connection connection){
        this.connection = connection;
    }

    public boolean insert(CustomerDTO customerDTO){
        String query = "INSERT INTO `customer`(`store_id`,`first_name`, `last_name`, `email`, `create_date`,`last_update`) VALUES(?,?,?,?,NOW(),NOW())";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1,customerDTO.getStore_id());
            pstmt.setString(2, customerDTO.getFirst_name());
            pstmt.setString(3,customerDTO.getLast_name());
            pstmt.setString(4, customerDTO.getEmail());


            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void update(CustomerDTO customerDTO){
        String query = "UPDATE `customer` SET `first_name`=?, `last_name` = ?, `last_update` = NOW() WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, customerDTO.getFirst_name());
            pstmt.setString(2,customerDTO.getLast_name());
            pstmt.setInt(3,customerDTO.getCustomer_id());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id){
        String query = "DELETE FROM `customer`  WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<CustomerDTO> selectAll(){
        ArrayList<CustomerDTO> list = new ArrayList<>();

        String query = "SELECT * FROM `customer`  ORDER BY  `board`.`id` DESC";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                CustomerDTO c = new CustomerDTO();
                c.setCustomer_id(resultSet.getInt("customer_id"));
                c.setFirst_name(resultSet.getString("first_name"));
                c.setLast_name(resultSet.getString("last_name"));
                c.setEmail(resultSet.getString("email"));
                c.setCreate_date(resultSet.getTimestamp("create_date"));
                c.setLast_update(resultSet.getTimestamp("last_update"));

                list.add(c);
            }
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public CustomerDTO selectOne(int id){
        CustomerDTO c = null;
        String query = "SELECT * FROM `customer` WHERE `id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet resultSet = pstmt.executeQuery();

            if(resultSet.next()){
                c = new CustomerDTO();
                c.setCustomer_id(resultSet.getInt("customer_id"));
                c.setFirst_name(resultSet.getString("first_name"));
                c.setLast_name(resultSet.getString("last_name"));
                c.setEmail(resultSet.getString("email"));
                c.setCreate_date(resultSet.getTimestamp("create_date"));
                c.setLast_update(resultSet.getTimestamp("last_update"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

}
