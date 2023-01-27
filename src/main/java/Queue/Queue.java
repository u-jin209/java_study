package Queue;

public class Queue{
    private int size;
    private int front;
    private int rear;
    private static final int QMAX =10;

    private int[] queue;

    public void Queue(){
        queue = new int[QMAX];
        this.size = 0;
        this.front =0;
        this.rear =0;

    }

    public boolean isEmpty(){
        if (size != 0){
            return true;
        }
        else {
            return false;
        }
    }

    public void enqueue(int num){
        if (rear < QMAX ){
            queue[rear] = num;
            size ++;
            if(size <= QMAX){
                rear ++;

            }

        }
        else{
            System.out.println("큐가 가득 차 추가할 수 없습니다.");

        }
        print();
    }

    public void dequeue(){

        if(isEmpty()){
            front = queue[0];

            for (int i =1; i< rear;i++){
                queue[i-1] = queue[i];
            }
            rear--;
            size--;
            queue[rear] = 0;
        }else {
            System.out.println("큐가 비어있습니다.");
        }
        print();

    }

    public int peek(){
        return queue[0];
    }
    public int size(){

        return size;

    }

    public void clear(){
        for (int i=0; i<rear;i++){
            queue[i]= 0;
        }
        size =0;

    }

    public void print() {
        for (int i = 0; i < QMAX; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println(" ");
    }

}
