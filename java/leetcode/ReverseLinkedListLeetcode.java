package leetcode;

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
 *
 * @author miguel
 */
public class ReverseLinkedListLeetcode {

    /**
     * 0ms, beats 100%, 42.72mb, beats 11.78%.
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode n = null;
        ListNode tmp = null;
        while (head != null) {
            tmp = new ListNode(head.val);
            tmp.next = n;
            head = head.next;
            n = tmp;
        }
        return n;
    }

    /**
     * 0ms, beats 100%.42.32, beats 54.11%.
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode next = null, previous = null, current = head;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
