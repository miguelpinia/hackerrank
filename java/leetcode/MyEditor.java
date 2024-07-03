package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/simple-text-editor/problem
 *
 * @author miguel
 */
public class MyEditor {

    // 4 operations
    // append(W, S) append W to S -> returns S + W
    // delete(k, S) delete the last k chars of S = a0.a1...a(n - k).a(n - (k - 1))...an -> return a0...a(n - k)
    // print(k) Print the kth char of S
    // undo() - Undo the last (not previously undone) operation of type 1 or 2, reverting to the previous state.
    // Stack<Operation> s <- to store all operations performed
    // Operation{int type, S previous state}
    static class Operation {

        String previousState;

        public Operation(int type, String prevState) {
            this.previousState = prevState;
        }
    }

    static class Editor {

        Stack<Operation> operations = new Stack<>();
        String currentState;

        public Editor(String state) {
            this.currentState = state;
        }

        public void print(int k) {
            char c = currentState.charAt(k - 1);
            System.out.println(c);
        }

        public void undo() {
            if (!operations.isEmpty()) {
                Operation o = operations.pop();
                currentState = o.previousState;
            }
        }

        public void append(String w) {
            Operation o = new Operation(1, currentState);
            operations.push(o);
            currentState += w;
        }

        public void delete(int k) {
            int n = currentState.length();
            if (k <= n) {
                Operation o = new Operation(2, currentState);
                operations.push(o);
                currentState = currentState.substring(0, n - k);
            }
        }
    }

    static class ProcessOperations {

        Editor e;

        public ProcessOperations(String initialState) {
            e = new Editor(initialState);
        }

        public void execute(String[] operation) {
            int type = Integer.parseInt(operation[0]);
            switch (type) {
                case 1 ->
                    e.append(operation[1]);
                case 2 -> {
                    int k = Integer.parseInt(operation[1]);
                    e.delete(k);
                }
                case 3 -> {
                    int k1 = Integer.parseInt(operation[1]);
                    e.print(k1);
                }
                case 4 ->
                    e.undo();
            }
        }

    }

    static class ReadLines {

        public List<String> readOps() {
            List<String> ops = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                int q = Integer.parseInt(br.readLine().trim());
                IntStream.range(0, q).forEach(itr -> {
                    try {
                        ops.add(br.readLine().trim());
                    } catch (IOException ex) {
                        Logger.getLogger(MyEditor.class.getName()).log(Level.SEVERE, null, ex);
                    }

                });
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            return ops;
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        ReadLines rl = new ReadLines();
        List<String> ops = rl.readOps();
        ProcessOperations po = new ProcessOperations("");
        for (String op : ops) {
            po.execute(op.trim().split(" "));
        }
    }

}
