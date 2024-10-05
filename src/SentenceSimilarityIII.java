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
 *1813. Sentence Similarity III
 * Solved
 *
 * Medium
 *
 * Topics Array
 * Two Pointers
 * String
 *
 *
 * Companies
 * Hint
 * You are given two strings sentence1 and sentence2, each representing a sentence composed of words. A sentence is a list of words that are separated by a single space with no leading or trailing spaces. Each word consists of only uppercase and lowercase English characters.
 *
 * Two sentences s1 and s2 are considered similar if it is possible to insert an arbitrary sentence (possibly empty) inside one of these sentences such that the two sentences become equal. Note that the inserted sentence must be separated from existing words by spaces.
 *
 * For example,
 *
 * s1 = "Hello Jane" and s2 = "Hello my name is Jane" can be made equal by inserting "my name is" between "Hello" and "Jane" in s1.
 * s1 = "Frog cool" and s2 = "Frogs are cool" are not similar, since although there is a sentence "s are" inserted into s1, it is not separated from "Frog" by a space.
 * Given two sentences sentence1 and sentence2, return true if sentence1 and sentence2 are similar. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
 *
 * Output: true
 *
 * Explanation:
 *
 * sentence2 can be turned to sentence1 by inserting "name is" between "My" and "Haley".
 *
 * Example 2:
 *
 * Input: sentence1 = "of", sentence2 = "A lot of words"
 *
 * Output: false
 *
 * Explanation:
 *
 * No single sentence can be inserted inside one of the sentences to make it equal to the other.
 *
 * Example 3:
 *
 * Input: sentence1 = "Eating right now", sentence2 = "Eating"
 *
 * Output: true
 *
 * Explanation:
 *
 * sentence2 can be turned to sentence1 by inserting "right now" at the end of the sentence.
 *
 *
 *
 * Constraints:
 *
 * 1 <= sentence1.length, sentence2.length <= 100
 * sentence1 and sentence2 consist of lowercase and uppercase English letters and spaces.
 * The words in sentence1 and sentence2 are separated by a single space.
 *
 *
 * @author miguel
 */
public class SentenceSimilarityIII {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");

        if (s1.length > s2.length) {
            String[] tmp = s2;
            s2 = s1;
            s1 = tmp;
        }

        int left = 0;

        while (left < s1.length && s1[left].equals(s2[left])) {
            left++;
        }

        int rightS1 = s1.length - 1;
        int rightS2 = s2.length - 1;

        while (rightS1 >= left && rightS2 >= 0 && s1[rightS1].equals(s2[rightS2])) {
            rightS1--;
            rightS2--;
        }
        return left > rightS1;
    }

}
