import java.util.*;

public class DijkstraGraph {

    static final int INF = Integer.MAX_VALUE;

    static int minDistance(int[] dist, boolean[] visited, int n) {

        int min = INF;
        int index = -1;

        for (int i = 0; i < n; i++) {

            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }

        return index;
    }

    static void dijkstra(int[][] graph, int source, String[] cities) {

        int n = graph.length;

        int[] dist = new int[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(dist, INF);

        dist[source] = 0;

        for (int count = 0; count < n - 1; count++) {

            int u = minDistance(dist, visited, n);

            visited[u] = true;

            for (int v = 0; v < n; v++) {

                if (!visited[v]
                        && graph[u][v] != 0
                        && dist[u] != INF
                        && dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Shortest distances from Edinburgh:\n");

        for (int i = 0; i < n; i++) {
            System.out.println(cities[i] + " : " + dist[i]);
        }
    }

    public static void main(String[] args) {
        String[] cities = {
                "Edinburgh",
                "Stirling",
                "Glasgow",
                "Perth",
                "Dundee"
        };

        int[][] graph = {

                {0,   50,  70,  100, 0},
                {50,  0,   50,  40,  0},
                {70,  50,  0,   0,   0},
                {100, 40,  0,   0,   60},
                {0,   0,   0,   60,  0}
        };

        dijkstra(graph, 0, cities);
    }
}