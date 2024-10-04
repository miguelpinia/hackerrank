
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
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
 *
 * 207. Course Schedule Solved Medium
 *
 * Topics Depth-First Search Breadth-First Search Graph Topological Sort
 *
 * Companies Hint There are a total of numCourses courses you have to take,
 * labeled from 0 to numCourses - 1. You are given an array prerequisites where
 * prerequisites[i] = [ai, bi] indicates that you must take course bi first if
 * you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1. Return true if you can finish all courses. Otherwise,
 * return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]] Output: true Explanation:
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So it is possible. Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]] Output: false
 * Explanation: There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2 0 <= ai, bi < numCourses All the pairs
 * prerequisites[i] are unique.
 *
 * @author miguel
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] courses = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new ArrayList<>();
        }
        for (int[] pr : prerequisites) {
            courses[pr[0]].add(pr[1]);
        }

        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(courses, visited, i)) {
                return false;
            }
        }
        return true;

    }

    private boolean dfs(List<Integer>[] courses, Set<Integer> visited, int course) {
        if (visited.contains(course)) {
            return false;
        }
        if (courses[course].isEmpty()) {
            return true;
        }
        visited.add(course);
        for (int newCourse : courses[course]) {
            if (!dfs(courses, visited, newCourse)) {
                return false;
            }
        }
        visited.remove(course);
        courses[course] = new ArrayList<>();
        return true;
    }

}
