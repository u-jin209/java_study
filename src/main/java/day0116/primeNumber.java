package day0116;

public class primeNumber {

    public static void main(String[] args) {
        int count =0;
        for (int i =1; i<=1000;i++){
            for (int j = 1; j<=i ;j++){
                if (i % j ==0 ){
                    count++;
                }
            }
            if(count ==2){
                System.out.printf(i+" ");
            }
            count =0;
        }

    }
}
