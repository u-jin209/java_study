package day0127;

import dbConn.ConnectionMaker;
import dbConn.MySqlConnectionMaker;
import dbViewer.CustomerViewer;
import util.ScannerUtil;

import java.util.Scanner;

public class VideoMVC {

    private static Scanner scanner;
    private static ConnectionMaker connectionMaker ;
    private static CustomerViewer customerViewer;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        ConnectionMaker connectionMaker = new MySqlConnectionMaker();
        CustomerViewer customerViewer = new CustomerViewer(connectionMaker);

        mainMenu();


    }

    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        String message =" 1. 고객 관리 2. 비디오 관리 3. 대여/반납 4. 매출 현황";
        int choice= ScannerUtil.nextInt(scanner,message);

        while(true){
            if (choice == 1){
                customerViewer.showIndex();
            }
        }
    }
}
