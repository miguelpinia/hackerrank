
import java.util.ArrayList;
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
 * 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any
 * order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23" Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = "" Output: [] Example 3:
 *
 * Input: digits = "2" Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4 digits[i] is a digit in the range ['2', '9'].
 *
 * @author miguel
 */
public class LetterCombinationsOfAPhoneNumber {

    Map<Character, String> letters = new HashMap<>();
    Set<String> combinations = new HashSet<>();

    public List<String> letterCombinations(String digits) {
        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");

        if (digits.equals("")) {
            return new ArrayList<>();
        }
        makeCombinations(0, new StringBuilder(), digits);
        return new ArrayList<>(combinations);
    }

    void makeCombinations(int index, StringBuilder word, String number) {
        if (index == number.length()) {
            combinations.add(word.toString());
            return;
        }
        char curr = number.charAt(index);
        char[] lts = letters.get(curr).toCharArray();
        for (char c : lts) {
            word.append(c);
            makeCombinations(index + 1, word, number);
            word.delete(word.length() - 1, word.length());
        }
    }

}
