package dbController;

import model.CustomerDTO;
import model.MovieDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieController {
    private Connection connection;

    public MovieController(Connection connection){
        this.connection = connection;
    }
    public boolean insert(MovieDTO movieDTO){
        String query = "INSERT INTO `film`(`title`, `description`, `release_year`,`rental_duration`,`rental_rate`,`rating`," +
                "`special_features`,`last_update`) VALUES(?,?,?,?,?,?,?, NOW())";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);

            pstmt.setString(1, movieDTO.getTitle());
            pstmt.setString(2,movieDTO.getDescription());
            pstmt.setInt(3, movieDTO.getRelease_year());
            pstmt.setInt(4, movieDTO.getRental_duration());
            pstmt.setInt(5, movieDTO.getRental_rate());
            pstmt.setString(6, movieDTO.getRating());
            pstmt.setString(7,movieDTO.getSpecial_features());


            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void update(MovieDTO movieDTO){
        String query = "UPDATE `film` SET `title` = ?, `description` =?, `release_year`=?," +
                "`rental_duration`=?,`rental_rate`=?,`rating`=?  ,`special_features`=?,`last_update` = NOW() WHERE `film_id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, movieDTO.getTitle());
            pstmt.setString(2,movieDTO.getDescription());
            pstmt.setInt(3,movieDTO.getRelease_year());
            pstmt.setInt(4,movieDTO.getRental_duration());
            pstmt.setInt(5,movieDTO.getRental_rate());
            pstmt.setString(6,movieDTO.getRating());
            pstmt.setString(7,movieDTO.getSpecial_features());

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        String query = "DELETE FROM `film`  WHERE `film_id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<MovieDTO> selectAll(){
        ArrayList<MovieDTO> list = new ArrayList<>();

        String query = "SELECT * FROM `film`  ORDER BY  `film`.`film_id` ASC ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                MovieDTO m = new MovieDTO();
                m.setFilm_id(resultSet.getInt("film_id"));
                m.setTitle(resultSet.getString("title"));
                m.setDescription(resultSet.getString("description"));
                m.setRelease_year(resultSet.getInt("release_year"));
                m.setLanguage_id(resultSet.getInt("language_id"));
                m.setRental_duration(resultSet.getInt("rental_duration"));
                m.setRental_rate(resultSet.getInt("rental_rate"));
                m.setLength(resultSet.getInt("length"));
                m.setRating(resultSet.getString("rating"));
                m.setRating(resultSet.getString("special_features"));
                m.setLast_update(resultSet.getTimestamp("last_update"));

                list.add(m);
            }
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public MovieDTO selectOne(int id){
        MovieDTO m = null;
        String query = "SELECT * FROM `film` WHERE `film_id` = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);

            ResultSet resultSet = pstmt.executeQuery();

            if(resultSet.next()){
                m = new MovieDTO();
                m.setFilm_id(resultSet.getInt("film_id"));
                m.setTitle(resultSet.getString("title"));
                m.setDescription(resultSet.getString("description"));
                m.setRelease_year(resultSet.getInt("release_year"));
                m.setLanguage_id(resultSet.getInt("language_id"));
                m.setRental_duration(resultSet.getInt("rental_duration"));
                m.setRental_rate(resultSet.getInt("rental_rate"));
                m.setLength(resultSet.getInt("length"));
                m.setRating(resultSet.getString("rating"));
                m.setRating(resultSet.getString("special_features"));
                m.setLast_update(resultSet.getTimestamp("last_update"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("해당 영화는 존재하지 않습니다.");
        }

        return m;
    }


    public ArrayList<MovieDTO> selectTitle(String title) {
        ArrayList<MovieDTO> list = new ArrayList<>();

        String query = "SELECT * FROM `film`  WHERE `title` = ?  ";

        try {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1,title);

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                MovieDTO m = new MovieDTO();
                m.setTitle(resultSet.getString("title"));
                m.setDescription(resultSet.getString("description"));
                m.setRelease_year(resultSet.getInt("release_year"));
                m.setRental_duration(resultSet.getInt("Rental_duration"));
                m.setRental_rate(resultSet.getInt("rental_rate"));
                m.setRating(resultSet.getString("rating"));
                m.setSpecial_features(resultSet.getString("special_features"));

                list.add(m);
            }
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
