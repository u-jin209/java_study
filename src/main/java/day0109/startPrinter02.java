package day0109;

import java.util.Scanner;

public class startPrinter02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 줄 수를 입력하세요");
        System.out.println("> ");
        int lineNumber = scanner.nextInt();

        System.out.println("별 2");
        for ( int i =0; i<lineNumber ; i++ ){
            for (int j=lineNumber; j>i; j--){
                System.out.printf("*");
            }
            System.out.println();
        }

        System.out.println("별 찍기 2번 강사님 코드");

        for(int i=1;i<=lineNumber;i++){
            String stars = "";
            for (int j =i; j<=lineNumber;j++){
                stars +="*";
            }
            System.out.println(stars);
        }


    }
}