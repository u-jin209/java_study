package day0113;

import dbConn.ConnectionMaker;
import dbConn.MySqlConnectionMaker;

import java.sql.Connection;

public class Ex02Contoller {
    public static void main(String[] args) {
        ConnectionMaker maker = new MySqlConnectionMaker();
        Connection connection = maker.makeConnection();
    }
}
