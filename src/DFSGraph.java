import java.util.*;

public class DFSGraph {

    static void dfs(int start, int[][] adj, boolean[] visited, int n) {

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {

            int vertex = stack.pop();

            if (visited[vertex]) {
                continue;
            }

            visited[vertex] = true;

            System.out.print((char)(vertex + 'A') + " ");

            for (int i = n - 1; i >= 0; i--) {

                if (adj[vertex][i] == 1 && !visited[i]) {
                    stack.push(i);
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

        System.out.println("DFS:");

        dfs(0, adj, visited, n);
    }
}