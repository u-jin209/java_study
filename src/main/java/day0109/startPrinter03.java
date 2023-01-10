package day0109;

import java.util.Scanner;

public class startPrinter03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("출력할 줄 수를 입력하세요");
        System.out.println("> ");
        int lineNumber = scanner.nextInt();

        System.out.println("별 3");
        for ( int i =0; i<lineNumber ; i++ ){

            for (int j=lineNumber; j>i; j--){

                System.out.printf(" ");
            }
            for (int j=0; j<=i; j++){
                System.out.printf("*");
            }
            System.out.println();
        }

        System.out.println("별 찍기 3번 강사님 코드");
        for(int i=1;i<=lineNumber;i++){
            String stars = "";
            for (int j =1; j<=lineNumber;j++){
                if (j<=lineNumber -i){
                    stars +=" ";
                }else{
                    stars +="*";
                }
            }
            System.out.println(stars);
        }


    }
}