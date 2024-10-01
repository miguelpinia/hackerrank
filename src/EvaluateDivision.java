
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
 * 399. Evaluate Division Solved Medium
 *
 * Topics Array String Depth-First Search Breadth-First Search Union Find Graph
 * Shortest Path
 *
 *
 * Companies Hint You are given an array of variable pairs equations and an
 * array of real numbers values, where equations[i] = [Ai, Bi] and values[i]
 * represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that
 * represents a single variable.
 *
 * You are also given some queries, where queries[j] = [Cj, Dj] represents the
 * jth query where you must find the answer for Cj / Dj = ?.
 *
 * Return the answers to all queries. If a single answer cannot be determined,
 * return -1.0.
 *
 * Note: The input is always valid. You may assume that evaluating the queries
 * will not result in division by zero and that there is no contradiction.
 *
 * Note: The variables that do not occur in the list of equations are undefined,
 * so the answer cannot be determined for them.
 *
 *
 *
 * Example 1:
 *
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]] Output:
 * [6.00000,0.50000,-1.00000,1.00000,-1.00000] Explanation: Given: a / b = 2.0,
 * b / c = 3.0 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x =
 * ? return: [6.0, 0.5, -1.0, 1.0, -1.0 ] note: x is undefined => -1.0 Example
 * 2:
 *
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]] Output:
 * [3.75000,0.40000,5.00000,0.20000] Example 3:
 *
 * Input: equations = [["a","b"]], values = [0.5], queries =
 * [["a","b"],["b","a"],["a","c"],["x","y"]] Output:
 * [0.50000,2.00000,-1.00000,-1.00000]
 *
 *
 * Constraints:
 *
 * 1 <= equations.length <= 20 equations[i].length == 2 1 <= Ai.length,
 * Bi.length <= 5 values.length == equations.length 0.0 < values[i] <= 20.0 1 <=
 * queries.length <= 20 queries[i].length == 2 1 <= Cj.length, Dj.length <= 5
 * Ai, Bi, Cj, Dj consist of lower case English letters and digits.
 *
 *
 * @author miguel
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Graph graph = new Graph();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            if (!graph.nodes.containsKey(a)) {
                graph.nodes.put(a, new ArrayList<>());
            }
            if (!graph.nodes.containsKey(b)) {
                graph.nodes.put(b, new ArrayList<>());
            }
            List<Node> neighborsA = graph.nodes.get(a);
            List<Node> neighborsB = graph.nodes.get(b);
            neighborsA.add(new Node(b, values[i]));
            neighborsB.add(new Node(a, 1 / values[i]));
        }
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            results[i] = bfs(graph, queries.get(i).get(0), queries.get(i).get(1));
        }
        return results;
    }

    private double bfs(Graph graph, String src, String target) {
        if (!graph.nodes.containsKey(src) || !graph.nodes.containsKey(target)) {
            return -1;
        }
        Deque<Pair> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        Pair root = new Pair(src, 1);
        queue.addLast(root);
        visited.add(src);
        while (!queue.isEmpty()) {
            Pair current = queue.removeFirst();
            if (current.node.equals(target)) {
                return current.result;
            }
            for (Node n : graph.nodes.get(current.node)) {
                if (!visited.contains(n.neighbor)) {
                    queue.addLast(new Pair(n.neighbor, n.solution * current.result));
                    visited.add(n.neighbor);
                }
            }
        }
        return -1;
    }

    class Pair {

        String node;
        double result;

        Pair() {
            node = null;
            result = -1;
        }

        Pair(String node, double result) {
            this.node = node;
            this.result = result;
        }
    }

    class Node {

        String neighbor;
        double solution;

        public Node(String neighbor, double solution) {
            this.neighbor = neighbor;
            this.solution = solution;
        }
    }

    class Graph {

        Map<String, List<Node>> nodes;

        public Graph() {
            nodes = new HashMap<>();
        }
    }

}
