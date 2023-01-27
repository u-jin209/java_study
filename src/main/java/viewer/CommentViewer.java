package viewer;

import controller.CommentController;
import model.CommentDTO;
import model.BoardDTO;
import model.UserDTO;
import util.ScannerUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CommentViewer {

    private  Scanner SCANNER;
    private CommentController commentController;
    private UserDTO logIn;


    public CommentViewer(Scanner scanner) {
        SCANNER =scanner;
        commentController = new CommentController();

    }

    public void setLogIn(UserDTO logIn){
        this.logIn =logIn;
    }

    public void printAll(int boardId){
        ArrayList<CommentDTO> list = commentController.selectAll(boardId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMd H:m:s");
        for(CommentDTO c:list){
            String date = sdf.format(c.getEntryDate());
            if(c.getModifyDate() != null){
                date = sdf.format(c.getModifyDate());
            }

            System.out.printf("%d. %s(%s): %s\n",c.getId(),c.getWriterNickname(),date,c.getCommentContent());
        }
    }

    public void showMenu(int boardId){

        String message = "1. 새 댓글 작성하기 2. 댓글 수정  3. 댓글 삭제 4. 뒤로 가기";

        int userChoice = ScannerUtil.nextInt(SCANNER, message);
        if (userChoice == 1) {
            writeComment(boardId);

        }else if(userChoice !=4){
            message = "수정/ 삭제할 댓글 번호나 뒤로 가실려면 0을 입력해 주세요";
            int targetId = ScannerUtil.nextInt(SCANNER,message);
            while (userChoice != 0 && commentController.selectOne(targetId)==null){
                System.out.println("잘못입력하셨습니다.");
                targetId = ScannerUtil.nextInt(SCANNER,message);
            }
            if (userChoice == 2){
                update(targetId,boardId);
            }else if (userChoice == 3){
                delete(targetId,boardId);
            }
        }

    }

//    public void printList(int boardId) {
//        ArrayList<CommentDTO> list = commentController.selectAll(boardId);
//
//        String message;
//        int userChoice;
//
//        if (list.isEmpty()){
//            System.out.println("아직 등록된 댓글이 존재하지 않습니다.");
//
//        }else {
//            for(CommentDTO c : list){
//                System.out.printf("댓글 번호 : %s \n 작성자 : %s. \n %s\n",
//                        c.getId(),c.getWriterNickname(),c.getCommentContent());
//            }
//            message = "1. 수정  2. 삭제 3. 뒤로 가기";
//
//            userChoice = ScannerUtil.nextInt(SCANNER, message,1,4);
//
//            if(userChoice ==1){
//                if (logIn.getId() == logWriter.getWriterId()) {
//                    update(logWriter.getId());
//                }else{
//                    System.out.println("수정 하실 수 없습니다");
//                }
//            } else if (userChoice ==2) {
//
//                if (logWriter.getWriterId() == logIn.getId()) {
//                    delete(logWriter.getId());
//                }else{
//                    System.out.println("삭제 하실 수 없습니다");
//                }
//
//
//            } else if (userChoice == 3) {
//
//                boardViewer.printOne(boardId);
//            }
//
//        }
//
//
//    }

    private void writeComment(int boardId) {
        CommentDTO c = new CommentDTO();
        c.setBoardId(boardId);
        c.setWriterId(logIn.getId());
        c.setWriterNickname(logIn.getNickname());

        String message;
        message = "댓글의 내용을 입력하세요";
        c.setCommentContent(ScannerUtil.nextLine(SCANNER,message));

        commentController.add(c);

    }


    private void delete(int id, int boardId) {
        CommentDTO c = commentController.selectOne(id);
        if(c != null && c.getBoardId() == boardId && c.getWriterId() == logIn.getId()){
            String message = "정말로 삭제하시겠습니까? Y/N";
            String yesNo = ScannerUtil.nextLine(SCANNER, message);
            if (yesNo.equalsIgnoreCase("Y")){
                commentController.delete(id);
            }
        }
    }



    private void update(int id, int boardId) {
        CommentDTO c = commentController.selectOne(id);

        if(c != null && c.getBoardId() == boardId && c.getWriterId() == logIn.getId()){
            String message = "새로운 내용을 입력해주세요 ";
            c.setCommentContent(ScannerUtil.nextLine(SCANNER,message));

            commentController.update(c);
        }
    }
}
