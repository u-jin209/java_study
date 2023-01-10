package day0109;

import java.util.Scanner;

public class startPrinter09 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("별 9");
        System.out.println("출력할 줄 수를 입력하세요");
        System.out.printf("> ");
        int lineNumber = scanner.nextInt();

        int totalHeight = 2 * lineNumber -1;

        System.out.println("별 찍기 9번");
        for(int i = 1; i<=totalHeight; i++){
            String stars = "";
            if (i <= lineNumber){
                for (int j = 1; j<=lineNumber-i; j++){
                    stars +=" ";
                }
                for (int j = 1; j<=2*i-1; j++){
                    stars +="*";
                }
            }
            else{
                int lowerI = i -lineNumber +1;

                for (int j = 1; j <= lowerI - 1; j++){
                    stars +=" ";
                }
                // -2 * i + (2 * lineNumber +1)
                for (int j = 1 ;j <= 2 * ( lineNumber - lowerI) + 1 ; j++){
                    stars += "*";
                }
            }

            System.out.println(stars);
        }



        System.out.println("별 찍기 9번");
        for(int i = 1; i<=totalHeight; i++){
            String stars = "";
            int spaceWidth = 0;
            int starWidth = 0;

            if (i <= lineNumber){
                //윗부분
                spaceWidth = lineNumber -i;
                starWidth = 2 * i -1;

            }
            else{
                int lowerI = i -lineNumber +1;
                spaceWidth = lowerI -i;
                starWidth = 2 * (lineNumber-lowerI) + 1;
            }

            for (int j = 1; j <= spaceWidth; j++){
                stars +=" ";
            }
            // -2 * i + (2 * lineNumber +1)
            for (int j = 1 ;j <= starWidth ; j++) {
                stars += "*";
            }
            System.out.println(stars);
        }


    }
}