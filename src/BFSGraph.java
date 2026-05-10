import java.util.*;

public class BFSGraph {

    static void bfs(int start, int[][] adj, boolean[] visited, int n) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {

            int vertex = queue.poll();

            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;

            System.out.print((char)(vertex + 'A') + " ");

            for (int i = 0; i < n; i++) {

                if (adj[vertex][i] == 1 && !visited[i]) {
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] adj = {
                {0,1,1,1,0,0,0},
                {1,0,1,0,1,0,1},
                {1,1,0,1,0,0,0},
                {1,0,1,0,0,0,0},
                {0,1,0,0,0,1,1},
                {0,0,0,0,1,0,1},
                {0,1,0,0,1,1,0}
        };

        int n = adj.length;

        boolean[] visited = new boolean[n];

        System.out.println("BFS:");

        bfs(0, adj, visited, n);
    }
}