package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/26/16.
 */
public class BinaryHeap {
    private int value;
    private BinaryHeap left;
    private BinaryHeap right;

    BinaryHeap(int value) {
        this.value = value;
    }

    /**
     * This method used MAX-HEAPIFY property of head to insert a value into the heap
     *
     * @param value the value that needs to be inserted into heap
     * @param heap  the heap into which the value needs to be inserted
     * @return
     */
    public boolean addNode(BinaryHeap heap, int value) {
        if (value >= heap.value) {
            BinaryHeap newHead = new BinaryHeap(value);
            newHead.right = heap.right;
            heap.right = null;
            newHead.left = heap;
            return true;
        } else if (value < heap.value) {
            if (heap.left.value >= heap.right.value) {
                return addNode(heap.left, value);
            } else {
                return addNode(heap.right, value);
            }
        }
        return false;
    }

    public boolean removeNode(int value) {

        return false;
    }

    public int[] toArray(BinaryHeap root) {
        return new int[0];
    }


}
