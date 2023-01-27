package day0126;

import viewer.StudentViewer;

import java.sql.SQLException;
import java.util.Scanner;

public class studentMain {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        StudentViewer studentViewer = new StudentViewer(scanner);


        studentViewer.showMenu();

        scanner.close();

    }
}
