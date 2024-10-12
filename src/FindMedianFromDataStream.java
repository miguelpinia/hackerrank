
import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Copyright (c) 2024 miguel.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    miguel - initial API and implementation and/or initial documentation
 */
/**
 * 295. Find Median from Data Stream Solved Hard
 *
 * Topics Two Pointers Design Sorting Heap (Priority Queue) Data Stream
 *
 *
 * Companies The median is the middle value in an ordered integer list. If the
 * size of the list is even, there is no middle value, and the median is the
 * mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3. For example, for arr =
 * [2,3], the median is (2 + 3) / 2 = 2.5. Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object. void addNum(int num) adds
 * the integer num from the data stream to the data structure. double
 * findMedian() returns the median of all elements so far. Answers within 10-5
 * of the actual answer will be accepted.
 *
 *
 * Example 1:
 *
 * Input ["MedianFinder", "addNum", "addNum", "findMedian", "addNum",
 * "findMedian"] [[], [1], [2], [], [3], []] Output [null, null, null, 1.5,
 * null, 2.0]
 *
 * Explanation MedianFinder medianFinder = new MedianFinder();
 * medianFinder.addNum(1); // arr = [1] medianFinder.addNum(2); // arr = [1, 2]
 * medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
 * medianFinder.addNum(3); // arr[1, 2, 3] medianFinder.findMedian(); // return
 * 2.0
 *
 *
 * Constraints:
 *
 * -105 <= num <= 105 There will be at least one element in the data structure
 * before calling findMedian. At most 5 * 104 calls will be made to addNum and
 * findMedian.
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are in the range [0, 100], how would
 * you optimize your solution? If 99% of all integer numbers from the stream are
 * in the range [0, 100], how would you optimize your solution? @author miguel
 */
public class FindMedianFromDataStream {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    double median = 0;

    public void addNum(int num) {
        if (maxHeap.size() > minHeap.size()) {
            if (num < median) {
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
        } else if (maxHeap.size() == minHeap.size()) {
            if (num < median) {
                maxHeap.add(num);
                median = maxHeap.peek();
            } else {
                minHeap.add(num);
                median = minHeap.peek();
            }
        } else {
            if (num < median) {
                maxHeap.add(num);
            } else {
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }
            median = (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }

    public double findMedian() {
        return median;
    }

}
