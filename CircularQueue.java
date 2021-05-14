import java.util.Arrays;

public class CircularQueue {

    private int rear;
    private int front;
    private int capacity;
    private int size;
    private int[] array;
        public CircularQueue(int k) {
            this.capacity = k;
            rear = -1;
            front = 0;
            this.size = 0;
            this.array = new int[k];
        }

        public boolean enQueue(int value) {
            if(isFull()) return false;

            if(front == -1) front++;
            size++;
            this.rear = (this.rear + 1) % this.capacity;
            this.array[rear] = value;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return false;

            size--;
            this.front = (this.front + 1) % this.capacity;
            this.array[front] = -1;
            return true;
        }

        public int Front() {
            return this.array[front];
        }

        public int Rear() {
            return this.array[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

    public static void main(String[] args) {
        CircularQueue myCircularQueue = new CircularQueue(3);
        boolean cenas = myCircularQueue.enQueue(1); // return True
        cenas =myCircularQueue.enQueue(2); // return True
        cenas =myCircularQueue.enQueue(3); // return True
        cenas =myCircularQueue.enQueue(4); // return False
        int test = myCircularQueue.Rear();     // return 3
        cenas =myCircularQueue.isFull();   // return True
        cenas =myCircularQueue.deQueue();  // return True
        cenas =myCircularQueue.enQueue(4); // return True
        test = myCircularQueue.Rear();     // return 4
    }
}
 