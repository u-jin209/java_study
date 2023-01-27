package day0113;

//상속(Inheritance)
//상속의 목적 : 코드의 재사용성과 다형성을 위해서
//# 상속의 종류
//1. 클래스 상속
//    코드의 재사용성이 주 목적
//    부모클래스의 메소드를 자식클래스가 그대로 재사용가능.
//    extends 라는 키워드를 통해서 이루어짐.
//2. 인터페이스 상석
//      다형성이 주목적
//      부모 인터페이스의 메소드를 자식클래스가 반드시 재정의(=오버라이드)해야함
//        #implement라는 키워드를 통해서 이루어진다.

public class Ex01Inheritance {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.move();
        animal.eat();
        System.out.println("----------------");
        Dog dog = new Dog();
        dog.move();
        dog.eat();
        dog.makeSound();

        Animal a = new Dog();
        a.move();
        a.eat();
//
//        showSample(animal);
//        showSample(dog);
//        showSample(a);
        IAnimal iAnimal = new Cat();
        showSample(iAnimal);
    }

    public static void showSample(IAnimal animal){
        animal.makeSound();
        animal.eat();
        animal.move();

    }

    public static void showSample(Rabbit rabbit){
        rabbit.makeSound();
        rabbit.eat();
        rabbit.move();

    }
}
