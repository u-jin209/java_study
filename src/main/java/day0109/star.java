package day0109;

import java.util.Scanner;

public class star {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("별 1");
        System.out.println("출력할 줄 수를 입력하세요");
        System.out.println("> ");
        int lineNumber = scanner.nextInt();

        for ( int i =0; i<lineNumber ; i++ ){
            for (int j=0; j<=i; j++){
                System.out.printf("*");
            }
            System.out.println();
        }


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




        System.out.println("별 5");
        for ( int i =0; i<lineNumber ; i++ ){

            for (int j=lineNumber; j>i; j--){
                System.out.printf(" ");
            }
            for (int k=1; k<=i*2+1;k++){
                System.out.printf("*");
            }
            System.out.println();
        }

        System.out.println("별 찍기 5번 강사님 코드");
        for(int i = 1; i<=lineNumber; i++){
            String stars = "";
            for (int j = 1; j<=lineNumber-i; j++){
                stars +=" ";
            }
            for (int j = 1; j<=2*i-1; j++){
                stars +="*";
            }
            System.out.println(stars);
        }

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


        System.out.println("별 찍기 6번 강사님 코드/어려움");
        for(int i = 1; i<=lineNumber; i++){
            String stars = "";
            for (int j = 1; j <= i - 1; j++){
                stars +=" ";
            }
            // -2 * i + (2 * lineNumber +1)
            for (int j = 1 ; j <= -2 * i + (2 * lineNumber +1) ; j++){
                stars += "*";
            }
            System.out.println(stars);
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

        scanner.close();
    }


}
