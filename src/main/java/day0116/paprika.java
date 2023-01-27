package day0116;

import java.util.Scanner;

public class paprika {

    public static void main(String[] args) {
        for (int i = 10 ; i <100;i++){
            String stringNum = Integer.toString(i);
            int num1 = Integer.parseInt(stringNum.substring(0,1));
            int num2 = Integer.parseInt(stringNum.substring(1));
            int add = num1+num2;
            if (i == add*add){
                System.out.printf("%d\n",i);
            }
        }

        for (int i = 1000 ; i <10000;i++){
            String stringNum = Integer.toString(i);
            int num1 = Integer.parseInt(stringNum.substring(0,2));
            int num2 = Integer.parseInt(stringNum.substring(2,4));
            int add = num1+num2;
            if (i == add*add){
                System.out.printf("%d\n",i);
            }
        }
    }

}
