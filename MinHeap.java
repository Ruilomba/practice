import Model.TreeNode;

import java.util.*;

public class MinHeap {

    private int[] stack;
    private int capacity;
    private int size;

    /** initialize your data structure here. */
    public MinHeap() {
        this.capacity = 10;
        this.stack = new int[capacity];
        this.size = 0;
    }

    public void push(int val) {
        this.ensureCapacity();
        this.stack[size++] = val;

        int i = this.size - 1;
        while(this.stack[i] < this.stack[parent(i)]){
            this.swap(i, parent(i));
            i = parent(i);
        }
    }

    public void pop() {
        if(size == 0) return;
        this.stack[0] = this.stack[size--];

        this.heapify(0);
    }

    private void heapify(int pos){
        if(!isLeaf(pos)){

            if (this.stack[pos] > this.stack[left(pos)]
                    || this.stack[pos] > this.stack[right(pos)]) {

                if (this.stack[left(pos)] < this.stack[right(pos)]) {
                    swap(pos, left(pos));
                    heapify(left(pos));
                }

                else {
                    swap(pos, right(pos));
                    heapify(right(pos));
                }
            }
        }
    }

    private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    public int top() {
        return this.stack[0];
    }

    public int getMin() {
        return this.stack[0];
    }

    private void swap(int pos1, int pos2){
        int temp = this.stack[pos1];
        this.stack[pos1] = this.stack[pos2];
        this.stack[pos2] = temp;
    }

    private int right(int pos){
        return (2 * pos) + 1;
    }

    private int left(int pos){
        return 2 * pos;
    }

    private int parent(int pos){
        return pos / 2;
    }

    private void ensureCapacity(){
        if(this.size == this.capacity) {
            this.capacity *= 2;
            int[] newStack = new int[this.capacity];
            int i = 0;
            for(Integer val : this.stack){
                newStack[i] = val;
                i++;
            }

            this.stack = newStack;
        }

        this.size++;
    }

    public static void main(String[] args)   {
    }
}
