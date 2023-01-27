package Queue;

import util.ScannerUtil;

import java.util.Scanner;

public class Stack {

    private int size;
    private int top;

    private int[] stack;

    public Stack(int size){
        this.size = size;
        this.top =-1;
        stack = new int[this.size];

    }

    public boolean isEmpty(){
        return (top == -1);
    }
    public boolean isFull(){
        return (top == this.size-1);
    }

    public void push(int num){
        if (isFull()){
            System.out.println("스텍이 가득 차 추가할 수 없습니다.");
        }
        else{
            stack[++top] = num;

        }
        print();
    }

    public void pop(){

        if(isEmpty()){
            System.out.println("스택이 비어있습니다.");
        }else {
            System.out.println("POP : " + stack[top]);
            stack[top] = 0;
            top--;
        }
        print();
    }

    public void peek(){
        if(isEmpty()){
            System.out.println("스택이 비어있습니다.");


        }else {
            System.out.println("Peek : "+stack[top]);

        }
        print();
    }

    public void clear(){
        if(isEmpty()){
            System.out.println("스택이 비어있습니다.");

        }else {
            top = -1;
            stack = new int[this.size];
            System.out.println("초기화 완료.");
        }

        print();

    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = " 원하는 스택 사이즈를 입력하세요.";
        int size = ScannerUtil.nextInt(scanner,message);
        Stack stack1 = new Stack(size);

        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.peek();
        stack1.push(5);
        stack1.push(6);
        stack1.pop();
        stack1.pop();
        stack1.pop();
        stack1.clear();
        stack1.pop();
    }
}
