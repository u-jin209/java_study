package controller;

import model.StudentDTO;
import util.ScannerUtil;

import java.sql.*;
import java.util.ArrayList;

public class StudentController {
    private ArrayList<StudentDTO> list;
    public static PreparedStatement pstmt = null;
    public static Connection connection = null;
    public static ResultSet resultSet = null;
    public StudentController(){
        list = new ArrayList<>();
        initialize();

    }
    static void initialize() {
        String address = "jdbc:mysql://localhost/basic";
        String username = "root";
        String password = "1111";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(address, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void terminate() throws SQLException {
        if (resultSet != null) {
            resultSet.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (connection != null) {
            connection.close();
        }

    }


    //insert()

    public static void insert(StudentDTO s) {

        String query = "INSERT INTO `student`(`name`,`korean`,`english`,`math`) VALUES(?,?,?,?)";

        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setString(1, s.getName());
            pstmt.setInt(2, s.getKorean());
            pstmt.setInt(3, s.getEnglish());
            pstmt.setInt(4, s.getMath());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void update(StudentDTO s, int id, int korean, int english, int math){

        String query = "UPDATE `student` SET `korean` =?, `english` = ? ,`math`=? WHERE `id` =?";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1,korean);
            pstmt.setInt(2,english);
            pstmt.setInt(3,math);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public static void delete(int id){

        String query = "DELETE FROM `student` WHERE `id` = ?";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static StudentDTO selectOne(int id) {
        String query = "SELECT * FROM `student` WHERE `id` = ?";
        try {
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1,id);

            resultSet = pstmt.executeQuery();

            if(resultSet.next()){
                StudentDTO s = new StudentDTO();
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("name"));
                s.setKorean(resultSet.getInt("korean"));
                s.setEnglish(resultSet.getInt("english"));
                s.setMath(resultSet.getInt("math"));

                return s;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    public static ArrayList<StudentDTO> selectAll(){
        ArrayList<StudentDTO> list = new ArrayList<>();
        try{
            while(resultSet.next()){
                StudentDTO s = new StudentDTO();
                s.setId(resultSet.getInt("id"));
                s.setName(resultSet.getString("name"));
                s.setKorean(resultSet.getInt("korean"));
                s.setEnglish(resultSet.getInt("english"));
                s.setMath(resultSet.getInt("math"));

                list.add(s);


            }
        }catch (SQLException e){
            throw new RuntimeException(e);

        }
        return list;
    }



}
