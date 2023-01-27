package viewer;

import controller.StudentController;
import day0126.Student;
import model.StudentDTO;
import util.ScannerUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentViewer {

    private StudentController studentController;
    private  final Scanner scanner;

    public StudentViewer(Scanner scanner){

        studentController = new StudentController();
        this.scanner =scanner;
    }

    public void showMenu() throws SQLException {
        String message = "1.입력 2. 목록 보기 3. 종료";
        while (true){
            int userChoice = ScannerUtil.nextInt(scanner,message);
            if(userChoice == 1){
                insertStudent();
            } else if (userChoice ==2) {
                printList();
            } else if (userChoice ==3) {
                System.out.println("사용해주셔서 감사합니다");
                studentController.terminate();
                break;
            }

        }
    }

    private void insertStudent(){

        StudentDTO s = new StudentDTO();

        String message = "이름을 입력해주세요.";
        s.setName(ScannerUtil.nextLine(scanner, message));

        message = "국어 점수를 입력해주세요.";
        s.setKorean(ScannerUtil.nextInt(scanner, message, 0, 100));
        message = "영어 점수를 입력해주세요.";
        s.setEnglish(ScannerUtil.nextInt(scanner, message, 0, 100));
        message = "수학 점수를 입력해주세요.";
        s.setMath(ScannerUtil.nextInt(scanner, message, 0, 100));

        studentController.insert(s);

    }

    private void updateStudent(int id){

        StudentDTO s = studentController.selectOne(id);

        String message = "새로운 국어 점수를 입력해 주세요. ";
        int korean = ScannerUtil.nextInt(scanner,message,0,100);
        message = "새로운 영어 점수를 입력해 주세요. ";
        int english = ScannerUtil.nextInt(scanner,message,0,100);
        message = "새로운 수학 점수를 입력해 주세요. ";
        int math = ScannerUtil.nextInt(scanner,message,0,100);


        studentController.update(s,id, korean, english, math);
    }

    void printOne(int id) {
        StudentDTO s = studentController.selectOne(id);
        s.printInfo();
        String message = "1. 수정 2. 삭제 3. 뒤로가기";
        int userChoice  = ScannerUtil.nextInt(scanner,message,1,3);
        if (userChoice ==1){
            updateStudent(id);
            printOne(id);
        } else if (userChoice ==2) {
            deleteStudent(id);
        }else if(userChoice ==3){
            printList();
        }
    }

    private void deleteStudent(int id) {
        String message =" 정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner,message);
        if(yesNo.equalsIgnoreCase("Y")){
            studentController.delete(id);

        }else {
            printOne(id);
        }
    }

    public void printList(){
        String query = "SELECT * FROM `student`";

        try {
            studentController.pstmt = studentController.connection.prepareStatement(query);
            studentController.resultSet = studentController.pstmt.executeQuery();
            ArrayList<StudentDTO> list = studentController.selectAll();

            if (list.isEmpty()){
                System.out.println("아직 등록된 학생이 없습니다");
            }else{
                for(StudentDTO s : list){
                    System.out.printf( "%d. %s\n",s.getId(), s.getName());
                }

                String message = "상세보기할 학생의 번호나 뒤로 가실려면 0을 입력해주세요";
                int userChoice = ScannerUtil.nextInt(scanner, message);

                while(userChoice !=0 && studentController.selectOne(userChoice) ==null){
                    System.out.println("잘못입력하셨습니다");
                    userChoice = ScannerUtil.nextInt(scanner, message);

                }
                if(userChoice !=0){
                    printOne(userChoice);
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



}
