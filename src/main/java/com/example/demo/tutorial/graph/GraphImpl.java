package com.example.demo.tutorial.graph;

import java.util.*;

public class GraphImpl {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList), qs = new HashSet<>(), qe = new HashSet<>(), vis = new HashSet<>();
        qs.add(beginWord);
        if (dict.contains(endWord)) qe.add(endWord); // all transformed words must be in dict (including endWord)
        for (int len = 2; !qs.isEmpty(); len++) {
            Set<String> nq = new HashSet<>();
            for (String w : qs) {
                for (int j = 0; j < w.length(); j++) {
                    char[] ch = w.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == w.charAt(j)) continue; // beginWord and endWord not the same, so bypass itself
                        ch[j] = c;
                        String nb = String.valueOf(ch);
                        if (qe.contains(nb)) return len; // meet from two ends
                        if (dict.contains(nb) && vis.add(nb)) nq.add(nb); // not meet yet, vis is safe to use
                    }
                }
            }
            qs = (nq.size() < qe.size()) ? nq : qe; // switch to small one to traverse from other end
            qe = (qs == nq) ? qe : nq;
        }
        return 0;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        boolean isPossible = true;
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        Map<Integer, Integer> indegree = new HashMap<>();
        int[] topologicalOrder = new int[numCourses];

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);

            // Record in-degree of each vertex
            indegree.put(dest, indegree.getOrDefault(dest, 0) + 1);
        }

        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree.get(i) == 0) {
                q.add(i);
            }
        }

        int i = 0;
        // Process until the Q becomes empty
        while (!q.isEmpty()) {
            int node = q.remove();
            topologicalOrder[i++] = node;

            // Reduce the in-degree of each neighbor by 1
            if (adjList.containsKey(node)) {
                for (Integer neighbor : adjList.get(node)) {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);

                    // If in-degree of a neighbor becomes 0, add it to the Q
                    if (indegree.get(neighbor) == 0) {
                        q.add(neighbor);
                    }
                }
            }
            if (i == numCourses) {
                return topologicalOrder;
            }

        }


        // Check to see if topological sort is possible or not.


        return new int[0];
    }
}
