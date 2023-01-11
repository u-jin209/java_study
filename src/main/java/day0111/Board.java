package day0111;

// 2. 게시판프로그램 (배열) 가장오래된거 날림 > 제목, 작성자 ,글번호, 내용
public class Board {

    public String name;
    public String title;
    public int number;
    public String content;


    public boolean equals(Object object){
        if (object instanceof Board){
            //instanceof object와 Student가 같은 객체 타입인지 확인
            Board b= (Board) object; //자식클래스의 필드를 바로 불러올수없기 때문에 형변환을 시켜줌
            return number == b.number;
        }
        return false;
    }
    public void printBoard(){
        System.out.println("--------------------------------");
        System.out.printf("\t\t< %s >\n\n", title);
        System.out.printf("\t\t\t\t작성자 : %s \n\n", name);
        System.out.printf("본문 \n\n  %s \n\n", content);
        System.out.printf("\t %d 번째 글 입니다.\n", number);
        System.out.println("--------------------------------");

    }
}
