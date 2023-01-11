package day0111;

// 1. 학생관리 프로그램 만들기 검색

import day0111.Student;
import util.ScannerUtil;

import java.util.Scanner;

public class Ex01Gradebook02 {
    private static Scanner SCANNER = new Scanner(System.in);
    public static  final  int ARRAY_LENGTH = 5;
    private static final int SCORE_MAX =100;
    private static final int SCORE_MIN =0;
    private static Student[] studentArray =new Student[ARRAY_LENGTH];


    public static void main(String[] args) {
        showMenu();
        SCANNER.close();
    }

    public static void showMenu() {
        while (true) {
            String message = "1.입력 2.출력 3.종료";
            int userChoice = ScannerUtil.nextInt(SCANNER, message);

            if (userChoice == 1) {
                insertStudent();
            } else if (userChoice == 2) {
                printInfo();
            } else if (userChoice == 3) {
                System.out.println("사용해주셔서 감사합니다.");
                break;
            }
        }
    }

    public static void printInfo() {
        if (findNextIndex() ==0){
            System.out.println("아직 입력된 학생이 존재하지 않습니다.");
        }else {
            int lastIndex = findNextIndex();
            if (lastIndex == -1){
                lastIndex = 5;
            }
            for(int i = 0; i< lastIndex; i++){
                studentArray[i].print();
            }
        }
    }

    public static void  insertStudent(){
        int index = findNextIndex();
        if(index == -1) {
            moveElement();
            index = 4;
        }
        Student s = new Student();
        String message;

        message = "학생의 번호를 입력해주세요";
        s.id = ScannerUtil.nextInt(SCANNER,message);

        message = "학생의 이름을 입력해주세요";
        s.name = ScannerUtil.nextLine(SCANNER,message);

        message = "학생의 국어 점수를 입력해주세요";
        s.korean = ScannerUtil.nextInt(SCANNER,message, SCORE_MIN,SCORE_MAX);

        message = "학생의 영어 점수를 입력해주세요";
        s.english = ScannerUtil.nextInt(SCANNER,message,SCORE_MIN,SCORE_MAX);

        message = "학생의 수학 점수를 입력해주세요";
        s.math =ScannerUtil.nextInt(SCANNER,message,SCORE_MIN,SCORE_MAX);

        studentArray[index] =s;

    }

    private static void moveElement() {
        for (int i = 0; i < ARRAY_LENGTH -1; i++ ){
            studentArray[i] = studentArray[i+1];
        }
    }

    public static int findNextIndex() {
        for(int i =0; i< studentArray.length; i++){
            if(studentArray[i] == null){
                return i ;
            }
        }
        return -1;
    }
}
