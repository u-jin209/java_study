package day0110;

import util.ScannerUtil;

import java.util.Scanner;

public class Ex03Answer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee emp = new Employee();
        insertInfo(scanner,emp);
        printInfo(emp);


    }

    public static void printInfo(Employee emp) {

        System.out.println("-----------------------------------");
        System.out.println("사원 번호 : " + emp.id);
        System.out.println("사원 이름 :" + emp.name);
        System.out.println("사원 부서 : " + emp.department);
        System.out.println("사원 직급 : " + emp.rank);
        System.out.println("사원 연봉 : " + emp.salary);
        System.out.println("-----------------------------------");

    }

    public static void insertInfo(Scanner scanner, Employee employee) {
        //각종 풀력에서 사용할 메시지를 저장할 string 변수 message
        String message;

        //사원 번호 입력
        message = "사원의 번호를 입력해 주세요";
        employee.id = ScannerUtil.nextInt(scanner,message);

        //사원 이름 입력
        message = "사원의 이름을 입력해 주세요";
        employee.name = ScannerUtil.nextLine(scanner,message);
        //사원 직급 입력
        message = "사원의 직급을 입력해 주세요";
        employee.rank = ScannerUtil.nextLine(scanner,message);
        //사원 부서 입력
        message = "사원의 부서를 입력해 주세요";
        employee.department = ScannerUtil.nextLine(scanner,message);
        //사원 연봉 입력
        message = "사원의 연봉을 입력해 주세요";
        employee.salary = ScannerUtil.nextInt(scanner,message);
    }
}
