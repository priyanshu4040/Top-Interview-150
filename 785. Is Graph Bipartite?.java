import java.util.*;

class Solution {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        // -1 means not colored
        int[] color = new int[n];
        Arrays.fill(color, -1);

        // Check all disconnected components also
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node, int currentColor, int[][] graph, int[] color) {

        color[node] = currentColor;

        for (int neighbour : graph[node]) {

            // If neighbour is not colored
            if (color[neighbour] == -1) {

                // Give opposite color to neighbour
                if (!dfs(neighbour, 1 - currentColor, graph, color)) {
                    return false;
                }
            }

            // If neighbour already has same color
            else if (color[neighbour] == currentColor) {
                return false;
            }
        }

        return true;
    }
}
