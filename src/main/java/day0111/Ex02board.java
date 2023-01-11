package day0111;


import util.ScannerUtil;

import java.util.Scanner;

// 2. 게시판프로그램 (배열) 가장오래된거 날림 > 제목, 작성자 ,글번호, 내용
public class Ex02board {

    public static  final Scanner SCANNER = new Scanner(System.in);
    public static  final  int ARRAY_LENGTH = 5;
    private static final Board[] boardArray =new Board[ARRAY_LENGTH];

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
                printList();
            }
            else if ( option ==3) {
                System.out.println("사용을 종료합니다.");
                break;
            }
        }

    }

    public static void printList() {

        if (findNextIndex() == 0 ){
            System.out.println("작성된 게시글이 없습니다.");
        }else{
            for (int i =0; i < findNextIndex(); i++){
                System.out.println(boardArray[i].getNumber() + "." +boardArray[i].getTitle());

                //boardArray[i].printBoard();
            }
            String message = "상세보기할 글의 번호나 뒤로가실려면 0을 입력하세요";
            int userChoice = ScannerUtil.nextInt(SCANNER,message);

            while (userChoice !=0 && findIndexById(userChoice) == -1){
                System.out.println("잘못 입력하셨습니다.");
                userChoice = ScannerUtil.nextInt(SCANNER, message);

            }

            if (userChoice != 0 ){
                printOne(userChoice);
            }
        }

    }

    public static void printOne(int id) {
        if (findIndexById(id) == -1){
            System.out.println("해당 id를 가진 게시글은 존재하지 않습니다.");
        }else{
            boardArray[findIndexById(id)].printBoard();
            String message = "1. 수정 2. 뒤로가기";
            int userChoice = ScannerUtil.nextInt(SCANNER,message);
            if (userChoice ==1){
                update(id);
            }else {
                printList();

            }
        }

    }

    public static void update(int id){
        int index = findIndexById(id);
        boardArray[index].setTitle(ScannerUtil.nextLine(SCANNER, "새로운 제목을 입력해주세요."));
        boardArray[index].setContent(ScannerUtil.nextLine(SCANNER, "새로운 내용을 입력해주세요."));

        printOne(id);
    }

    public static int findIndexById(int id) {

        for (int i = 0 ; i< boardArray.length; i++){
            if ( boardArray[i] != null && id == boardArray[i].getNumber()){
                return i;
            }
        }

        return -1;
    }


    public static void insertBoard() {
        int index = findNextIndex();
        if (index >= boardArray.length){
            System.out.println("더 이상 작성하실 수 없습니다.");
        }
//        if (index == -1){
//            moveElement();
//            index = 4;
//        }
        Board b = new Board();
        String message = "작성자를 입력하세요 : ";
        b.getName(ScannerUtil.nextLine(SCANNER,message));
        message = "제목을 입력하세요 : ";
        b.setTitle(ScannerUtil.nextLine(SCANNER,message));
        message = "내용을 입력하세요 : ";
        b.setContent(ScannerUtil.nextLine(SCANNER,message));
        b.setNumber(index ++);

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
        return boardArray.length;
    }
}
