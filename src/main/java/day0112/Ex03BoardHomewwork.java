package day0112;

import viewer.BoardViewer;
import viewer.CommentViewer;
import viewer.CommentViewer;
import viewer.UserViewer;

import java.util.Scanner;

public class Ex03BoardHomewwork {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BoardViewer boardViewer =new BoardViewer(scanner);
        UserViewer userViewer = new UserViewer(scanner);
        CommentViewer commentViewer = new CommentViewer(scanner);

        userViewer.setBoardViewer(boardViewer);//필드 주입
        //userViewer.setCommentViewer(commentViewer);

        boardViewer.setUserViewer(userViewer);
        //boardViewer.setCommentViewer(commentViewer);

        userViewer.showIndex();



    }
}
