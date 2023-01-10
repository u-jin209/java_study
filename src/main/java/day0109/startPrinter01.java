package day0109;

import java.util.Scanner;

public class startPrinter01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("별 1");
        System.out.println("출력할 줄 수를 입력하세요");
        System.out.println("> ");
        int lineNumber = scanner.nextInt();

        for (int i = 0; i < lineNumber; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }

    }
}