package streams;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStreamOfNumbers {
    private PriorityQueue<Integer> maxHeap; // Left half (stores smaller numbers)
    private PriorityQueue<Integer> minHeap; // Right half (stores larger numbers)

    public MedianOfStreamOfNumbers() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // MaxHeap for smaller numbers
        minHeap = new PriorityQueue<>(); // MinHeap for larger numbers
    }

    public void addNum(int num) {
        // Step 1: Insert into the correct heap
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num); // Add to MaxHeap
        } else {
            minHeap.offer(num); // Add to MinHeap
        }

        // Step 2: Balance the heaps (MaxHeap should never have more than 1 extra element)
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll()); // Move top of MaxHeap to MinHeap
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll()); // Move top of MinHeap to MaxHeap
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // Even number of elements
        } else {
            return maxHeap.peek(); // Odd number of elements
        }
    }

    public static void main(String[] args) {
        MedianOfStreamOfNumbers medianFinder = new MedianOfStreamOfNumbers();

        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian()); // 3.0

        medianFinder.addNum(1);
        System.out.println("Median: " + medianFinder.findMedian()); // (3+1)/2 = 2.0

        medianFinder.addNum(4);
        System.out.println("Median: " + medianFinder.findMedian()); // 3.0

        medianFinder.addNum(6);
        System.out.println("Median: " + medianFinder.findMedian()); // (3+4)/2 = 3.5

        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian()); // 3.0
    }

}
