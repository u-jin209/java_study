package day0111;


import util.ScannerUtil;

import java.util.Scanner;

// 2. 게시판프로그램 (배열) 가장오래된거 날림 > 제목, 작성자 ,글번호, 내용
public class Ex02board {

    public static  final Scanner SCANNER = new Scanner(System.in);
    public static  final  int ARRAY_LENGTH = 5;
    private static Board[] boardArray =new Board[ARRAY_LENGTH];

    public static void main(String[] args) {
        showMenu();
        SCANNER.close();
    }

    public static void showMenu() {
        while (true){
            String message = "1. 글 작성  2. 글 조회 3. 종료";
            int option = ScannerUtil.nextInt(SCANNER, message);

            if (option == 1){
                insertBoard();
            }
            else if (option == 2){
                printInfo();
            }
            else if ( option ==3) {
                System.out.println("사용을 종료합니다.");
                break;
            }
        }

    }

    public static void printInfo() {

        if (findNextIndex() == 0 ){
            System.out.println("아직 입력된것이 없습니다.");
        }else{
            int lastIndex = findNextIndex();
            if (lastIndex == -1){
                lastIndex = 5;
            }
            for (int i =0; i < lastIndex; i++){
                boardArray[i].printBoard();
            }
        }


    }


    public static void insertBoard() {
        int index = findNextIndex();
        if (index == -1){
            moveElement();
            index = 4;
        }
        Board b = new Board();
        String message = "작성자를 입력하세요 : ";
        b.name = ScannerUtil.nextLine(SCANNER,message);
        message = "제목을 입력하세요 : ";
        b.title = ScannerUtil.nextLine(SCANNER,message);
        message = "내용을 입력하세요 : ";
        b.content = ScannerUtil.nextLine(SCANNER,message);
        b.number = index + 1;

        boardArray[index] =b;
    }

    public static void moveElement() {
        for (int i = 0; i < ARRAY_LENGTH -1; i++ ){
            boardArray[i] = boardArray[i+1];
        }
    }

    public static int findNextIndex() {
        for(int i =0; i< boardArray.length; i++){
            if(boardArray[i] == null){
                return i ;
            }
        }
        return -1;
    }
}
