
import java.util.Arrays;

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
 * 2491. Divide Players Into Teams of Equal Skill Solved Medium
 *
 * Topics Array Hash Table Two Pointers Sorting
 *
 *
 * Companies Hint You are given a positive integer array skill of even length n
 * where skill[i] denotes the skill of the ith player. Divide the players into n
 * / 2 teams of size 2 such that the total skill of each team is equal.
 *
 * The chemistry of a team is equal to the product of the skills of the players
 * on that team.
 *
 * Return the sum of the chemistry of all the teams, or return -1 if there is no
 * way to divide the players into teams such that the total skill of each team
 * is equal.
 *
 *
 *
 * Example 1:
 *
 * Input: skill = [3,2,5,1,3,4] Output: 22 Explanation: Divide the players into
 * the following teams: (1, 5), (2, 4), (3, 3), where each team has a total
 * skill of 6. The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 *
 * 3 = 5 + 8 + 9 = 22. Example 2:
 *
 * Input: skill = [3,4] Output: 12 Explanation: The two players form a team with
 * a total skill of 7. The chemistry of the team is 3 * 4 = 12. Example 3:
 *
 * Input: skill = [1,1,2,3] Output: -1 Explanation: There is no way to divide
 * the players into teams such that the total skill of each team is equal.
 *
 *
 * Constraints:
 *
 * 2 <= skill.length <= 105 skill.length is even. 1 <= skill[i] <= 1000
 *
 * @author miguel
 */
public class DividePlayers {

    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int level = skill[0] + skill[n - 1];
        long chemistry = 0;
        for (int i = 0; i < n / 2; i++) {
            if (skill[i] + skill[n - i - 1] != level) {
                return -1;
            }
            chemistry += skill[i] * skill[n - i - 1];
        }
        return chemistry;
    }

    public long dividePlayers2(int[] skill) {
        int[] freqs = new int[1001];
        int n = skill.length;
        int totalSkill = 0;
        for (int s : skill) {
            totalSkill += s;
            freqs[s]++;
        }
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }
        int targetSkill = totalSkill / (n / 2);
        long chemistry = 0;
        for (int s : skill) {
            int currentSkill = targetSkill - s;
            if (freqs[currentSkill] == 0) {
                return -1;
            }
            freqs[currentSkill]--;
            chemistry += s * currentSkill;
        }
        return chemistry / 2;
    }

}
