package day0109;

import java.util.Scanner;

public class star_baekjoon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("출력할 줄 수를 입력하세요");
        System.out.println("> ");
        int lineNumber = scanner.nextInt();

        int totalHeight = 2 * lineNumber -1;

        System.out.println("별 찍기 백준-9");
        for(int i = 1; i<=totalHeight; i++){
            String stars = "";
            if (i <= lineNumber){
                for (int j = 1; j <= i - 1; j++){
                    stars +=" ";
                }
                // -2 * i + (2 * lineNumber +1)
                for (int j = 1 ;j <= 2 * ( lineNumber - i) + 1 ; j++){
                    stars += "*";
                }
            }
            else{
                int lowerI = i -lineNumber +1;
                for (int j = 1; j<=lineNumber-lowerI; j++){
                    stars +=" ";
                }
                for (int j = 1; j<=2*lowerI-1; j++){
                    stars +="*";
                }

            }

            System.out.println(stars);
        }

        System.out.println("출력할 줄 수를 입력하세요");
        System.out.println("> ");
        int lineNumber2 = scanner.nextInt();

        String star2="";
        for (int i = 1; i<=lineNumber2 ;i++){
            if (i == 1 ) {
                for (int j = 1; j <= lineNumber2 - i; j++) {
                    star2 += " ";
                }
                for (int j = 1; j <= 2 * i - 1; j++) {
                    star2 += "*";
                }

            }
            else if (i == lineNumber2) {
                for (int j = 1; j <= 2 * i - 1; j++) {
                    star2 += "*";
                }
            }
            else{
                System.out.println(i);
            }
            System.out.println(star2);
        }


    }



}
