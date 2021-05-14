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
            if(isEmpty()) {
                this.front = -1;
                this.rear = -1;
                return true;
            }

            this.front = (this.front + 1) % this.capacity;
            return true;
        }

        public int Front() {
            if(this.isEmpty()) return -1;
            return this.array[front];
        }

        public int Rear() {
            if(this.isEmpty()) return -1;
            return this.array[rear];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

    public static void main(String[] args) {

        CircularQueue myCircularQueue = new CircularQueue(6);
        boolean cenas = myCircularQueue.enQueue(6);
        int s = myCircularQueue.Rear();// return True
        s = myCircularQueue.Rear();
        cenas =myCircularQueue.deQueue();  // return True
        cenas =myCircularQueue.enQueue(5); // return True
        s = myCircularQueue.Rear();
        cenas =myCircularQueue.deQueue();  // return True
        s = myCircularQueue.Front();
        cenas =myCircularQueue.deQueue();  // return True
        cenas =myCircularQueue.deQueue();  // return True
        cenas =myCircularQueue.deQueue();  // return True
    }
}
 