package day0110;

//구조체란(struct)
//구조체란, 내가 필요한 데이터 타입들을 모아서
//별개의 새로운 데이터 타입을 만들어 내는 것이다.
//하지만 자바에서는 구조체를 지원하지 않으므로,
//별개의 클래스를 만들고 그 클래스 안에 필요한 데이터 타입들을
//정의하는 형식으로 만들어주게된다.
public class Ex01struct {
    public static void main(String[] args){
        Student student = new Student();
        student.id=3;
        student.name="황유진";
        student.korean = 80;
        student.english = 90;
        student.math =90;
    }

    public  static  void printInfo(Student student){
        System.out.println("번호: "+student.id);
        System.out.println("이름: "+student.name);

    }
}
