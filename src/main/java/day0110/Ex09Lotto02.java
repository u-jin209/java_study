package day0110;

import java.util.Random;

//로또번호 추천기
//ver 2.0
//배열

public class Ex09Lotto02 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] lottoNumbers = new int[6];

        for (int i =0; i < lottoNumbers.length;){
            int temp = random.nextInt(45)+1;
            boolean numberSwitch = true;
            for(int j =0; j < i ;j++){
                if (temp == lottoNumbers[j]){
                    numberSwitch = false;
                }
            }

            if (numberSwitch){
                lottoNumbers[i] = temp;
                i++;
            }
        }
        for (int i =0; i<lottoNumbers.length; i++){
            System.out.printf(" %d ",lottoNumbers[i]);
        }
        System.out.println(" ");
        for (int i =0; i < lottoNumbers.length -1 ; i++){
            if (lottoNumbers[i]>lottoNumbers[i+1]){
                int temp = lottoNumbers[i];
                lottoNumbers[i] = lottoNumbers[i+1];
                lottoNumbers[i+1] = temp;
                i = -1  ;
            }
        }
        for (int i =0; i<lottoNumbers.length; i++){
            System.out.printf(" %d ",lottoNumbers[i]);
        }
    }
}
