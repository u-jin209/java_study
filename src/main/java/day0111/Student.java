package day0111;

//오버로딩 -> 이름은 같지만, 파라미터, 타입 등이 다름
//오버라이딩 -> 부모 클래스의 메소드의 동작을 재정의

public class Student {

    public int id;
    public String name;
    public int korean;
    public int english;
    public int math;

    public Student(){
        id = -1;
        name ="아직없음";
    }


    public void print(){
        System.out.printf("번호 : %d번 이름 : %s\n" ,id, name);
        System.out.printf("국어 : %d점 영어 : %d점 수학 : %d점\n", korean,english,math);
        System.out.printf("총점 %d점 평균 %.2f점\n",calculateSum(),calculateAverage());
    }

    public int calculateSum(){
        return korean + english + math;
    }

    public double calculateAverage(){
        return (double)calculateSum()/3;
    }


    //인스턴스 초기화가 끝난 상태의 객체
    public boolean equals(Object object){
        if (object instanceof Student){
            //instanceof object와 Student가 같은 객체 타입인지 확인
            Student s = (Student) object; //자식클래스의 필드를 바로 불러올수없기 때문에 형변환을 시켜줌
            return id == s.id;

        }

        return false;
    }
}
