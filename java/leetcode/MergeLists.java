package unam.mx.leetcode;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
 *
 * @author miguel
 */
public class MergeLists {

    static class SinglyLinkedListNode {

        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {

        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode newHead = null;
        SinglyLinkedListNode curr = null;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                if (newHead == null) {
                    newHead = head1;
                    curr = newHead;
                } else {
                    curr.next = head1;
                    curr = curr.next;
                }
                head1 = head1.next;
            } else {
                if (newHead == null) {
                    newHead = head2;
                    curr = newHead;
                } else {
                    curr.next = head2;
                    curr = curr.next;
                }
                head2 = head2.next;
            }
        }
        if (head1 != null) {
            curr.next = head1;
        } else if (head2 != null) {
            curr.next = head2;
        }
        return newHead;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {
            int tests = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int testsItr = 0; testsItr < tests; testsItr++) {
                SinglyLinkedList llist1 = new SinglyLinkedList();

                int llist1Count = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < llist1Count; i++) {
                    int llist1Item = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    llist1.insertNode(llist1Item);
                }

                SinglyLinkedList llist2 = new SinglyLinkedList();

                int llist2Count = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int i = 0; i < llist2Count; i++) {
                    int llist2Item = scanner.nextInt();
                    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                    llist2.insertNode(llist2Item);
                }

                SinglyLinkedListNode llist3 = mergeLists(llist1.head, llist2.head);

                printSinglyLinkedList(llist3, " ", bufferedWriter);
                bufferedWriter.newLine();
            }
        }

        scanner.close();
    }

}
