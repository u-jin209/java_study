package day0112;

import util.ScannerUtil;
import viewer.BoardViewer;
import viewer.UserViewer;

import java.util.Scanner;

public class Ex03Board02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BoardViewer boardViewer =new BoardViewer(scanner);
        UserViewer userViewer = new UserViewer(scanner);

        userViewer.setBoardViewer(boardViewer); //νλ μ£Όμ
        boardViewer.setUserViewer(userViewer);

        userViewer.showIndex();

    }
}
