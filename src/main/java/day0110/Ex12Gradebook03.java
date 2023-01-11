package day0110;

import util.ScannerUtil;

import java.util.Scanner;

// 1. 5명의 학생을 성적을 관리하는 프로그램을 작성하시오.
//      단, 5명을 모두 입력한 후에는 더이상 입력할 수 없도록 코드를 작성
// 2. 5명의 학생 성적을 관리하는 프로그램을 작성하시오.
//    단, 5명을 모두 입력한 후에 새로운 학생 정보를 입력할 시에는
//      가장 오래된 기록을 제거하고 새로운 학생 정보를 입력되도록 코드를 작성.
public class Ex12Gradebook03 {

    public static  final Scanner SCANNER = new Scanner(System.in);
    public static  final  int ARRAY_LENGTH = 5;

    public static void main(String[] args) {
        Student[] stu = new Student[ARRAY_LENGTH];
        for (int i=0; i<ARRAY_LENGTH;i++){
            stu[i] =new Student();
        }
        boolean inputSwitch = false;
        int action = 0;
        int max = 0;


        while (true){

            String message = "1. 입력 2. 출력 3. 종료";
            action = ScannerUtil.nextInt(SCANNER, message);
            if (action == 1){
                if(max < ARRAY_LENGTH){
                    insertInfo(SCANNER,stu,max);
                    inputSwitch = true;
                    max+=1;
                }else {
                    continue;
                }

                //ex03.insertInfo(scanner,emp);
            }
            else if (action == 2) {
                //ex03.printInfo(emp);
                if(inputSwitch){
                    for(int i =0; i<ARRAY_LENGTH;i++){
                        printInfo(stu[i]);
                    }
                }else{
                    System.out.println("아직 입력된 학생의 정보가 존재하지 않습니다.");
                }
            }
            else if (action ==3){
                System.out.println("사용해 주셔서 감사합니다.");
                break;
            }

        }


    }

    public static void insertInfo(Scanner scanner, Student[] stu,int num) {
        String message;

        message = "학생의 번호를 입력해주세요";
        stu[num].id = ScannerUtil.nextInt(scanner,message);

        message = "학생의 이름을 입력해주세요";
        stu[num].name = ScannerUtil.nextLine(scanner,message);

        message = "학생의 국어 점수를 입력해주세요";
        stu[num].korean = ScannerUtil.nextInt(scanner,message);

        message = "학생의 영어 점수를 입력해주세요";
        stu[num].english = ScannerUtil.nextInt(scanner,message);

        message = "학생의 수학 점수를 입력해주세요";
        stu[num].math =ScannerUtil.nextInt(scanner,message);
    }
    public static void printInfo(Student s){
        System.out.println("-------------------------------------------------");
        System.out.println("번호 : "+s.id+"번 이름 : "+s.name);
        System.out.printf("국어 : %d점 영어 : %d점 수학 : %d점\n" ,s.korean,s.english,s.math );
        System.out.printf("총점 %d점 평균 %.2f점\n", calculateSum(s), calculateAverage(s));
        System.out.println("-------------------------------------------------");

    }
    public static  int calculateSum(Student s){

        return s.korean+s.math+s.english;
    }
    public static double calculateAverage(Student s){
        return (double) calculateSum(s) /3;
    }


}
