package day0110;
//무한루프를 사용하여
//사용자가 입력을 누를때 마다 새로운 학생의 정보가 입력이 되고
//출력을 누를때마다 맨 마지막으로 열람한 학생의 정보가 출력되는 프로그램 작성
import day0110.Ex03Answer;
import java.util.Scanner;
import util.ScannerUtil;
public class Ex04Gradebook02 {

    public static void main(String[] args) {
        //Ex03Answer ex03 = new Ex03Answer();
        //Employee emp = new Employee();
        Student stu = new Student();
        boolean inputSwitch = false;

        Scanner scanner = new Scanner(System.in);
        int action = 0;

        while (true){

            String message = "1. 입력 2. 출력 3. 종료";
            action = ScannerUtil.nextInt(scanner, message);
            if (action == 1){
                insertInfo(scanner,stu);
                inputSwitch = true;
                //ex03.insertInfo(scanner,emp);
            }
            else if (action == 2) {
                //ex03.printInfo(emp);
                if(inputSwitch){
                    printInfo(stu);
                }else{
                    System.out.println("아직 입력된 학생의 정보가 존재하지 않습니다.");
                }
            }
            else if (action ==3){
                System.out.println("사용해 주셔서 감사합니다.");
                break;
            }

        }
        scanner.close();
    }

    public  static  void insertInfo(Scanner scanner, Student s){
        String message;

        message = "학생의 번호를 입력해주세요";
        s.id = ScannerUtil.nextInt(scanner,message);

        message = "학생의 이름을 입력해주세요";
        s.name = ScannerUtil.nextLine(scanner,message);

        message = "학생의 국어 점수를 입력해주세요";
        s.korean = ScannerUtil.nextInt(scanner,message);

        message = "학생의 영어 점수를 입력해주세요";
        s.english = ScannerUtil.nextInt(scanner,message);

        message = "학생의 수학 점수를 입력해주세요";
        s.math =ScannerUtil.nextInt(scanner,message);

    }

    public static void printInfo(Student s){
        System.out.println("번호 : "+s.id+"번 이름 : "+s.name);
        System.out.printf("국어 : %d점 영어 : %d점 수학 : %d점\n" ,s.korean,s.english,s.math );
        System.out.printf("총점 %d점 평균 %.2f점\n", calculateSum(s), calculateAverage(s));
    }

    public static  int calculateSum(Student s){
        return s.korean+s.math+s.english;
    }
    public static double calculateAverage(Student s){
        return (double) calculateSum(s) /3;
    }


}
