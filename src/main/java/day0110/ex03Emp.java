package day0110;

import util.ScannerUtil;

import java.util.Scanner;
import java.util.WeakHashMap;

import static day0109.Ex02GradebookAnswer.getName;

//사원 관리 프로그램을 작성하시오.
//단, 사원 정보(사원 번호, 이름, 직급, ㅅ속부서, 연봉)은 하나의 구조체로 통제하고
//사원 정보입력, 출력은 별개의 메소드를 통해 관리
public class ex03Emp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee emp = new Employee();
        setInfo(scanner);

    }

    private static String getDepartment(Scanner scanner) {
        String temp;
        String message = "소속부서를 입력해주세요.";
        temp = ScannerUtil.nextLine(scanner,message);

        return temp;
    }

    private static int getSalary(Scanner scanner) {
        String message = "연봉을 입력하세요 : ";
        return ScannerUtil.nextInt(scanner, message);
    }

    private static String getRank(Scanner scanner) {
        String temp;
        String message = "직급을 입력해주세요.";
        temp = ScannerUtil.nextLine(scanner,message);

        return temp;
    }

    private static int getId(Scanner scanner) {
        String message = "사원 번호를 입력하세요 : ";
        return ScannerUtil.nextInt(scanner, message);
    }



    public static void setInfo(Scanner scanner){
        Employee employee= new Employee();
        employee.id = getId(scanner);
        employee.name = getName(scanner);
        employee.rank = getRank(scanner);
        employee.department = getDepartment(scanner);
        employee.salary = getSalary(scanner);

        printInfo(employee);
    }
    public static void printInfo(Employee employee){

        System.out.println("사원 번호: "+employee.id);
        System.out.println("이름 : "+employee.name);
        System.out.println("직급 : "+employee.id);
        System.out.println("소속부서 : "+employee.name);
        System.out.println("연봉 : "+employee.id);

    }
}

