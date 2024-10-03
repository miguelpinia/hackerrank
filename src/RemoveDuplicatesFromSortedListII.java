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
 * 82. Remove Duplicates from Sorted List II
 *
 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,3,4,4,5]
 * Output: [1,2,5]
 * Example 2:
 *
 *
 * Input: head = [1,1,1,2,3]
 * Output: [2,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [0, 300].
 * -100 <= Node.val <= 100
 * The list is guaranteed to be sorted in ascending order.
 *
 * @author miguel
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode current = head;
        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.val == current.next.val) {
                    current = current.next;
                }
                prev.next = current.next;
            } else {
                prev = prev.next;
            }
            current = current.next;

        }
        return dummy.next;
    }

    public class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
