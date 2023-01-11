package day0111;

//오버로딩 -> 이름은 같지만, 파라미터, 타입 등이 다름
//오버라이딩 -> 부모 클래스의 메소드의 동작을 재정의

public class Student {

    private int id;
    private String name;
    private int korean;
    private int english;
    private int math;



    public Student(){
        setId(-1);
        setName("아직없음");
    }


    public void print(){
        System.out.printf("번호 : %d번 이름 : %s\n" , getId(), getName());
        System.out.printf("국어 : %d점 영어 : %d점 수학 : %d점\n", getKorean(), getEnglish(), getMath());
        System.out.printf("총점 %d점 평균 %.2f점\n",calculateSum(),calculateAverage());
    }

    public int calculateSum(){
        return getKorean() + getEnglish() + getMath();
    }

    public double calculateAverage(){
        return (double)calculateSum()/3;
    }


    //인스턴스 초기화가 끝난 상태의 객체
    public boolean equals(Object object){
        if (object instanceof Student){
            //instanceof object와 Student가 같은 객체 타입인지 확인
            Student s = (Student) object; //자식클래스의 필드를 바로 불러올수없기 때문에 형변환을 시켜줌
            return getId() == s.getId();

        }

        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }
}
