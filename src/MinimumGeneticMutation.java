
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
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
 * 433. Minimum Genetic Mutation
 *
 * A gene string can be represented by an 8-character long string, with choices
 * from 'A', 'C', 'G', and 'T'.
 *
 * Suppose we need to investigate a mutation from a gene string startGene to a
 * gene string endGene where one mutation is defined as one single character
 * changed in the gene string.
 *
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation. There is also a gene
 * bank bank that records all the valid gene mutations. A gene must be in bank
 * to make it a valid gene string.
 *
 * Given the two gene strings startGene and endGene and the gene bank bank,
 * return the minimum number of mutations needed to mutate from startGene to
 * endGene. If there is no such a mutation, return -1.
 *
 * Note that the starting point is assumed to be valid, so it might not be
 * included in the bank.
 *
 *
 *
 * Example 1:
 *
 * Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
 * Output: 1 Example 2:
 *
 * Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank =
 * ["AACCGGTA","AACCGCTA","AAACGGTA"] Output: 2
 *
 *
 * Constraints:
 *
 * 0 <= bank.length <= 10 startGene.length == endGene.length == bank[i].length
 * == 8 startGene, endGene, and bank[i] consist of only the characters ['A',
 * 'C', 'G', 'T'].
 *
 * @author miguel
 */
public class MinimumGeneticMutation {

    /**
     * 2ms, beats 32.83%.
     *
     * @param startGene
     * @param endGene
     * @param bank
     * @return
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<Character> choices = new HashSet<>();
        choices.add('A');
        choices.add('C');
        choices.add('T');
        choices.add('G');
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        Set<String> newBank = Set.copyOf(Arrays.asList(bank));

        Deque<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(startGene, 0));
        while (!queue.isEmpty()) {
            Pair current = queue.removeFirst();
            if (current.mutation.equals(endGene)) {
                return current.steps;
            }
            char[] array = current.mutation.toCharArray();
            for (int i = 0; i < array.length; i++) {
                for (char c : choices) {
                    if (array[i] != c) {
                        StringBuilder sb = new StringBuilder(current.mutation);
                        sb.setCharAt(i, c);
                        String newGene = sb.toString();
                        if (newBank.contains(newGene) && !visited.contains(newGene)) {
                            queue.addLast(new Pair(newGene, current.steps + 1));
                            visited.add(newGene);
                        }
                    }
                }
            }
        }
        return -1;
    }

    class Pair {

        String mutation;
        int steps;

        Pair(String mutation, int steps) {
            this.mutation = mutation;
            this.steps = steps;
        }
    }

}
