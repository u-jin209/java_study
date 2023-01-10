package day0109;

import java.util.Scanner;

public class startPrinter06Easy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 줄 수를 입력하세요");
        System.out.println("> ");
        int lineNumber = scanner.nextInt();

        System.out.println("별 6");
        for ( int i =0; i<=lineNumber ; i++ ){

            for (int j=1; j<=i; j++){
                System.out.printf(" ");
            }
            for (int j=lineNumber; j>=i*2-1; j--){
                System.out.printf("*");
            }
            System.out.println();
        }


        System.out.println("별 찍기 6번 강사님 코드/쉬움");
        for(int i = lineNumber ; i >= 1; i--){
            String stars = "";

            for (int j = 1; j <= lineNumber- i; j++){
                stars += " ";
            }

            for (int j = 1 ; j <= -2 * i -1; j++){
                stars += "*";
            }
            System.out.println(stars);
        }



    }
}