package day0110;

import util.ScannerUtil;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

//로또 추첨기
//ver3.0
//사용자 숫자 추가
// 사용자로부터 1. 자동 2. 수동 입력 받아서
// 각각에 맞게 메소드 실행시킨 후
//컴퓨터 숫자와 비교해
//총 맞은 개수를 출력하는 프로그램 작성
public class Ex10Lotto03 {

    public static  final  Scanner SCANNER = new Scanner(System.in);
    public static  final  Random RANDOM = new Random();
    public static  final  int NUMBER_LENGTH = 6;
    public static final int MIN = 1;
    public static final int MAX = 45;
    public  static int[] userNumbers = new int[NUMBER_LENGTH];
    public  static int[] computerNumbers = new int[NUMBER_LENGTH];
    public static void main(String[] args) {

        Random random = new Random();

        String message ="1. 자동  2. 수동";
        int action = ScannerUtil.nextInt(SCANNER, message);

        if (action == 1){
            int[] lottoNumbers = randomLotto();
            int[] winNumbers = randomLotto();
            result(lottoNumbers,winNumbers);

        } else if (action == 2) {
            int[] lottoNumbers = manualLotto();
            int[] winNumbers = randomLotto();
            result(manualLotto(),winNumbers);

        }


    }
    public  static  int[] manualLotto(){
        int[] manualNumbers = new int[6];
        String message =" 로또 번호를 입력해 주세요";
        for (int i=0; i<manualNumbers.length;i++){
            manualNumbers[i] =ScannerUtil.nextInt(SCANNER,message,MIN,MAX);
        }
        return manualNumbers;
    }

    public static int[] randomLotto(){

        int[] lottoNumbers = new int[6];
        for (int i =0; i < lottoNumbers.length;){
            int temp = RANDOM.nextInt(MAX)+MIN;
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
        return lottoNumbers;
    }

    public static void result(int[] lottoNumbers,int[] winnerNumbers){
        int count =0;
        for (int i =0; i < lottoNumbers.length ; i++){
            for( int j =0; j<winnerNumbers.length ; j ++){
                if (lottoNumbers[i] == winnerNumbers[j]){
                    count+=1;
                }
            }
        }
        System.out.printf("\n %d개 맞추셨습니다.\n", count);
    }

}
