package dbViewer;

import day0127.VideoMVC;
import dbConn.ConnectionMaker;
import dbController.CustomerController;
import dbController.MovieController;
import model.CustomerDTO;
import model.MovieDTO;
import util.ScannerUtil;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieViewer {

    private final Scanner SCANNER;
    private Connection connection;

    private String[] ratingList = {"G", "PG", "PG-13", "R", "NC-17"};
    private String[] special_featuresList={"Trailers", "Commentaries", "Deleted Scenes", "Behind the Scenes"};
    public MovieViewer(ConnectionMaker connectionMaker) {
        SCANNER = new Scanner(System.in);
        connection = connectionMaker.makeConnection();

    }

    public void showIndex() {
        System.out.println("= 영화 LIST ============================================");
        printAll();
        System.out.println("=======================================================");
        String message = "1. 영화 등록  2. 영화 수정  3. 영화 삭제  4. 영화 검색 5. 뒤로 가기";
        while (true) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message,1,5);
            int choiceId;
            if (userChoice == 1) {
                register();
                showIndex();
            } else if (userChoice == 2) {
                message = " 수정할 영화의 번호를 입력하세요. ";
                choiceId = ScannerUtil.nextInt(SCANNER, message);

                modify(choiceId);
                System.out.println("수정이 완료되었습니다.");
                showIndex();

            } else if (userChoice ==3) {
                message = " 삭제할 영화의 번호를 입력하세요. ";
                choiceId = ScannerUtil.nextInt(SCANNER, message);
                delete(choiceId);
                System.out.println("삭제가 완료되었습니다.");
                showIndex();

            } else if (userChoice == 4) {
                searchMenu();

            } else if (userChoice == 5) {

                VideoMVC.mainMenu();

            }
        }
    }

    private void searchMenu() {

        String message = "1. 제목으로 검색  2. 배우 이름으로 검색  3. 뒤로 가기";

        while (true) {
            int userChoice = ScannerUtil.nextInt(SCANNER, message,1,3);
            if(userChoice ==1 || userChoice ==2){
                printMovie(userChoice);

            } else if (userChoice==3) {
                showIndex();
            }
        }
    }

    private void printMovie(int mode) {
        ArrayList<MovieDTO> list = null;

        if(mode ==1) {
            String message = " 제목을 입력하세요 ";
            String title = ScannerUtil.nextLine(SCANNER, message);

            MovieController movieController = new MovieController(connection);
            list = movieController.selectTitle(title);

        }
        if (!list.isEmpty()){
            for (MovieDTO m : list){
                System.out.println("=영화 정보==============================");
                System.out.printf("영화 번호 : %d  영화 제목 : %s  개봉 년도 : %d 영화 등급 : %s \n" +
                        "대여 가능 기간 : %d 대여 비용 : %d \n" +
                                "special_features : %s\n",
                        m.getFilm_id(), m.getTitle(),m.getRelease_year(),m.getRating(),
                        m.getRental_duration(), m.getRental_rate(),m.getSpecial_features());
                System.out.println("=======================================");
            }
        }else {
            System.out.println("해당하는 영화를 찾을 수 없습니다.");
        }
    }

    private void delete(int id) {

        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(SCANNER, message);

        if (yesNo.equalsIgnoreCase("Y")) {

            MovieController movieController =new MovieController(connection);
            if (movieController.selectOne(id) != null) {
                movieController.delete(id);
            }
        }
    }


    private void modify(int id) {

        String message;

        message ="새로운 영화 제목을 입력해 주세요";
       String title = ScannerUtil.nextLine(SCANNER,message);

        message ="새로운 영화 줄거리를 입력해 주세요";
        String description = ScannerUtil.nextLine(SCANNER,message);

        message = "새로운 개봉 년도를 입력해주세요";
        int year = ScannerUtil.nextInt(SCANNER,message);

        message = "새로운 대여 기간을 입력해주세요";
        int Rental_duration =ScannerUtil.nextInt(SCANNER,message);
        message = "새로운 대여 비용을 입력해주세요";
        int Rental_rate = ScannerUtil.nextInt(SCANNER,message);

        message = "새로운 등급을 입력해 주세요\n" +
                "1. G   2. PG  3. PG-13  4. R  5. NC-17\n";
        String Rating = ratingList[ScannerUtil.nextInt(SCANNER,message,1,5)+1];

        message = "새로운 special_features를 입력해 주세요 \n" +
                "1. Trailers  2. Commentaries  3. Deleted Scenes  4. Behind the Scenes\n";
        String special_features ="";
        int count =0;
        while(count <=4) {
            int choice = ScannerUtil.nextInt(SCANNER,message,0,4);

            if(choice !=0) {
                special_features += special_featuresList[choice+1];
            }else if(choice == 0){
                break;
            }
            count++;
        }

        MovieController movieController = new MovieController(connection);
        if (movieController.selectOne(id) != null){
            MovieDTO m = new MovieDTO();
            m.setTitle(title);
            m.setDescription(description);
            m.setRelease_year(year);
            m.setRental_duration(Rental_duration);
            m.setRental_rate(Rental_rate);
            m.setRating(Rating);
            m.setSpecial_features(special_features);

            movieController.update(m);
        }else {
            System.out.println("영화 정보 변경에 실페하였습니다");

        }
    }

    private void register() {
        MovieDTO m = new MovieDTO();
        String message;

        message ="영화 제목을 입력해 주세요";
        m.setTitle(ScannerUtil.nextLine(SCANNER,message));

        message ="영화 줄거리를 입력해 주세요";
        m.setDescription(ScannerUtil.nextLine(SCANNER,message));

        message = "개봉 년도를 입력해주세요";
        m.setRelease_year(ScannerUtil.nextInt(SCANNER,message));

        message = "대여 기간을 입력해주세요";
        m.setRental_duration( ScannerUtil.nextInt(SCANNER,message));
        message = "대여 비용을 입력해주세요";
        m.setRental_rate(ScannerUtil.nextInt(SCANNER,message));

        message = "등급을 입력해 주세요\n" +
                "1. G   2. PG  3. PG-13  4. R  5. NC-17\n";
        m.setRating(ratingList[ScannerUtil.nextInt(SCANNER,message,1,5)+1]);
        message = "special_features를 입력해 주세요+" +
                "1. Trailers  2. Commentaries  3. Deleted Scenes  4. Behind the Scenes";
        String special_features ="";
        int count =0;
        while(count <=4) {
            count++;
            int choice = ScannerUtil.nextInt(SCANNER,message,0,4);

            if(choice !=0 ) {
                special_features += special_featuresList[choice+1];
                special_features += "   ";
            }else if(choice == 0){
                break;
            }

        }
        m.setSpecial_features(special_features);
    }

    private void printAll() {

        MovieController movieController= new MovieController(connection);
        ArrayList<MovieDTO> list = movieController.selectAll();

        for(MovieDTO m:list){

            System.out.printf("%d. %s\n",m.getFilm_id(),m.getTitle());
        }
    }

}
