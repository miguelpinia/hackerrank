
import java.util.HashMap;
import java.util.Map;

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
 * 138. Copy List with Random Pointer Solved Medium Topics Companies Hint A
 * linked list of length n is given such that each node contains an additional
 * random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n
 * brand new nodes, where each new node has its value set to the value of its
 * corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in
 * the original list and copied list represent the same list state. None of the
 * pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where
 * X.random --> Y, then for the corresponding two nodes x and y in the copied
 * list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val random_index: the index of the node
 * (range from 0 to n-1) that the random pointer points to, or null if it does
 * not point to any node. Your code will only be given the head of the original
 * linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]] Output:
 * [[7,null],[13,0],[11,4],[10,2],[1,0]] Example 2:
 *
 *
 * Input: head = [[1,1],[2,1]] Output: [[1,1],[2,1]] Example 3:
 *
 *
 *
 * Input: head = [[3,null],[3,0],[3,null]] Output: [[3,null],[3,0],[3,null]]
 *
 *
 * Constraints:
 *
 * 0 <= n <= 1000 -104 <= Node.val <= 104 Node.random is null or is pointing to
 * some node in the linked list.
 *
 * @author miguel
 */
public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Map<Node, Node> newNodes = new HashMap<>();
        Node newHead = null;
        Node current = newHead;
        Node oldHead = head;
        while (head != null) {
            int val = head.val;
            Node n = new Node(val);
            if (newHead == null) {
                newHead = n;
                current = newHead;
            } else {
                current.next = n;
                current = current.next;
            }
            newNodes.putIfAbsent(head, n);
            head = head.next;
        }
        head = oldHead;
        current = newHead;
        while (head != null) {
            if (head.random != null) {
                Node n = newNodes.get(head.random);
                current.random = n;
            }
            head = head.next;
            current = current.next;
        }
        return newHead;
    }

    class Node {

        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
