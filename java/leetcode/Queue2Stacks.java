package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/queue-using-two-stacks/problem
 *
 * @author miguel
 */
public class Queue2Stacks {

    static class Queue {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void enqueue(Integer item) {
            stack1.push(item);
        }

        public Integer dequeue() {

            Integer result;

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            result = stack2.pop();
            return result;
        }

        public Integer peek() {
            Integer result;
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            result = stack2.peek();

            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            Queue queue = new Queue();
            int q = Integer.parseInt(reader.readLine().trim());
            IntStream.range(0, q).forEach(itr -> {
                try {
                    String[] line = reader.readLine().trim().split(" ");
                    int type = Integer.parseInt(line[0]);
                    switch (type) {
                        case 1:
                            queue.enqueue(Integer.valueOf(line[1]));
                            break;
                        case 2:
                            queue.dequeue();
                            break;
                        case 3:
                            System.out.println(queue.peek());
                        default:
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }
    }

}
