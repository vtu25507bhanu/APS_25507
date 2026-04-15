import java.util.*;

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        // 0 = red, 1 = blue
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for (int[] e : redEdges) {
            graph[e[0]].add(new int[]{e[1], 0});
        }
        for (int[] e : blueEdges) {
            graph[e[0]].add(new int[]{e[1], 1});
        }

        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // start with red
        queue.offer(new int[]{0, 1}); // start with blue
        dist[0][0] = 0;
        dist[0][1] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int color = curr[1];

            for (int[] nei : graph[node]) {
                int next = nei[0];
                int edgeColor = nei[1];

                if (edgeColor != color && dist[next][edgeColor] == -1) {
                    dist[next][edgeColor] = dist[node][color] + 1;
                    queue.offer(new int[]{next, edgeColor});
                }
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i][0] == -1 || dist[i][1] == -1) {
                result[i] = Math.max(dist[i][0], dist[i][1]);
            } else {
                result[i] = Math.min(dist[i][0], dist[i][1]);
            }
        }

        return result;
    }
}