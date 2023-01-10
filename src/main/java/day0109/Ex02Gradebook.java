package day0109;

// 사용자로부터 번호, 이름, 국어, 영어, 수학 점수를 입력받아
//각각의 정보를 다음과 같이 출력되는 프로그램 작성
// 단, 입려그 출력, 총점 및 평균을 계상하는 메소드 따로 구혐

import java.util.Scanner;

//출력 방법 :
// 번호 : ##3번 이름 : ###
// 국어 ##점 영어 ##점 수학 ###점
// 총점 ##점 평균 : ##.####점
public class Ex02Gradebook {

    public static void main(String[] args){

        setInfo();
    }

    // 리턴 값이 없을 때는 void
    public static void setInfo() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("번호를 입력하세요 : ");
        int num = scanner.nextInt();
        System.out.print("이름을 입력하세요 : ");
        String name = scanner.next();
        System.out.print("국어 점수를 입력하세요 : ");
        int korean = scanner.nextInt();
        System.out.print("영어 점수를 입력하세요 : ");
        int english = scanner.nextInt();
        System.out.print("수학 점수를 입력하세요 : ");
        int math = scanner.nextInt();

        int total = total(korean,english,math);
        double average =average(total);

        printInfo( num,  name, korean , english, math,total,average);
    }
    public static void printInfo(int num, String name, int korean ,int english, int math, int total, double average){

        System.out.print("번호 : "+num+"번");
        System.out.println(" 이름 : "+name);
        System.out.print("국어 : "+ korean +"점");
        System.out.print(" 영어 : "+ english +"점");
        System.out.println(" 수학 : "+ math +"점");
        System.out.print("총점 : "+ total +"점");
        System.out.println(" 평균 : "+ average +"점");

    }


    public static int total ( int korean ,int english, int math){
        int totalResult = korean+english+math;
        return totalResult;
    }
    public static double average (int total){
        double averageResult = (float) total/3.0;
        return averageResult;
    }

}
