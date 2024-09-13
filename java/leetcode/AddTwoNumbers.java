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
 * 2. Add Two Numbers
 *
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * Example 2:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * Example 3:
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 * @author miguel
 */
public class AddTwoNumbers {

    /**
     * 1ms, beats 100%, 44.28mb, beats 71.51%
     * @param l1
     * @param l2
     * @return 
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode currNode = new ListNode();
        ListNode head = currNode;
        int carry = 0;
        int currSum;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                currSum = l1.val + l2.val + carry;
                carry = currSum / 10;
                currNode.next = new ListNode(currSum % 10);
                currNode = currNode.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                currSum = l2.val + carry;
                carry = currSum / 10;
                currNode.next = new ListNode(currSum % 10);
                currNode = currNode.next;
                l2 = l2.next;
            } else if (l2 == null) {
                currSum = l1.val + carry;
                carry = currSum / 10;
                currNode.next = new ListNode(currSum % 10);
                currNode = currNode.next;
                l1 = l1.next;
            }
        }
        if (carry > 0) {
            currNode.next = new ListNode(carry);
        }
        return head.next;
    }
}
