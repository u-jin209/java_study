package day0109;

import java.util.Scanner;

public class startPrinter04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 줄 수를 입력하세요");
        System.out.println("> ");
        int lineNumber = scanner.nextInt();

        System.out.println("별 4");
        for ( int i =0; i<lineNumber ; i++ ){

            for (int j=0; j<=i; j++){

                System.out.printf(" ");
            }
            for (int j=lineNumber; j>i; j--){
                System.out.printf("*");
            }
            System.out.println();
        }




    }
}