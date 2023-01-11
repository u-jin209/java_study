package day0111;

// 1. 학생관리 프로그램 만들기
// 2. 게시판프로그램 (배열) 가장오래된거 날림 > 제목, 작성자 ,글번호, 내용
public class Ex01Gradebook01 {
    public static void main(String[] args) {
        Student s = new Student(); //Student() 생성자 -> 어떠한 객체를 초기화 할때 실행되는 메소드
                                    // 자바에 존재하는 모든 객체는 같은 조상을 가지고있음

        s.id =1;
        s.name = "황유진";
        s.korean = 100;
        s.english = 90;
        s.math = 80;

        s.print();

        Student s2 = new Student();
        s2.id =2;
        s2.name = "유승재";
        s2.korean = 90;
        s2.english = 90;
        s2.math = 80;

        s2.print();

        Student s3 = new Student();
        s3.id =2;
        s3.name = "유승재";
        s3.korean = 90;
        s3.english = 90;
        s3.math = 80;

        s2.print();
        s3.print();

        System.out.println(s2.equals(s3));
        // 주소값 비교만 해서 false 출력(this는 s2)
        //오버라이드 부모 클래스를 그대로 사용할 수 없는 상황일때 자식 클래스로  재정의 하여 사용
        // 오버라이딩 후 true 출력


        String a ="Abc";
        String b = new String( "Abc");
        System.out.println(a == b);// ==은 스택에 저장된 값만 비교함. 따라서 Equals 메소드 활용
        System.out.println(a.equals(b));
    }
}
