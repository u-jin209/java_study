package dbViewer;

import dbConn.ConnectionMaker;
import dbController.CustomerController;
import dbController.UserController;
import model.CustomerDTO;
import util.ScannerUtil;

import java.sql.Connection;
import java.util.Scanner;

public class CustomerViewer {
    private final Scanner SCANNER;
    private Connection connection;

    public CustomerViewer(ConnectionMaker connectionMaker) {
        SCANNER = new Scanner(System.in);
        connection = connectionMaker.makeConnection();
    }

    public void showIndex() {
        CustomerController customerController =new CustomerController(connection);
        customerController.selectAll();
        String message = "1. 회원 등록  2. 회원 수정  3. 회원 삭제  4. 종료";
        while (true) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message);
            int choiceId;
            if (userChoice == 1) {
                register();
            } else if (userChoice == 2) {
                message = " 수정할 회원의 번호를 입력하세요. ";
                choiceId = ScannerUtil.nextInt(SCANNER, message);
                modify(choiceId);
            } else if (userChoice ==3) {
                message = " 삭제할 회원의 번호를 입력하세요. ";
                choiceId = ScannerUtil.nextInt(SCANNER, message);
                delete(choiceId);

            } else if (userChoice == 4) {
                System.out.println("사용해주셔서 감사합니다.");

            }
        }
    }

    private void delete(int id) {

        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(SCANNER, message);

        if (yesNo.equalsIgnoreCase("Y")) {

            CustomerController customerController =new CustomerController(connection);
            if (customerController.selectOne(id) != null) {
                customerController.delete(id);
            }
        }


    }

    private void modify(int id) {

        String message = "새로운 성을 입력해주세요.";
        String newFirstname = ScannerUtil.nextLine(SCANNER, message);

        message = "새로운 이름을 입력해주세요.";
        String newLastname = ScannerUtil.nextLine(SCANNER, message);


        CustomerController customerController =new CustomerController(connection);
        if (customerController.selectOne(id) != null) {
            CustomerDTO c = new CustomerDTO();
            c.setCustomer_id(id);
            c.setFirst_name(newFirstname);
            c.setLast_name(newLastname);

            customerController.update(c);
        } else {
            System.out.println("회원 정보 변경에 실패하였습니다.");
        }

    }

    private void register() {

        CustomerDTO c =new CustomerDTO();
        String message;

        message = "사용자의 성을 입력해주세요.";
        c.setFirst_name(ScannerUtil.nextLine(SCANNER, message));

        message = "사용자의 이름을 입력해주세요.";
        c.setLast_name(ScannerUtil.nextLine(SCANNER, message));

        message = "사용자의 이메일을 입력해주세요.";
        c.setEmail(ScannerUtil.nextLine(SCANNER, message));

        CustomerController customerController =new CustomerController(connection);
        if(!customerController.insert(c)){
            System.out.println("중복된 이메일 입니다.\n");
            message= "새로운 이메일로 등록을 시도하시겠습니까? Y/N";
            String yesNo = ScannerUtil.nextLine(SCANNER, message);
            if (yesNo.equalsIgnoreCase("Y")){
                register();
            }
        }

    }
}
