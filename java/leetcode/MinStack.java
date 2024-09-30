
import java.util.ArrayDeque;
import java.util.Deque;

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
 * 155. Min Stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object. void push(int val) pushes the
 * element val onto the stack. void pop() removes the element on the top of the
 * stack. int top() gets the top element of the stack. int getMin() retrieves
 * the minimum element in the stack. You must implement a solution with O(1)
 * time complexity for each function.
 *
 * @author miguel
 */
public class MinStack {

    // Can be improved using linked-list, where each node is a pair.
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque();
    }

    public void push(int val) {
        stack.addFirst(val);
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peekFirst());
        minStack.addFirst(val);
    }

    public void pop() {
        stack.removeFirst();
        minStack.removeFirst();
    }

    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }

}
