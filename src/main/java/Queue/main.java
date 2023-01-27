package Queue;

import javax.sound.midi.Soundbank;

public class main {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);


        q.dequeue();


        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.enqueue(9);

        q.dequeue();

        q.enqueue(10);
        q.enqueue(12);
        q.dequeue();
        q.dequeue();
        q.enqueue(12);

    }
}
