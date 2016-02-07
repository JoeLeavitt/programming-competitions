/**
 * Created by JL on 2/5/16.
 */

import java.util.*;

public class stars {
    public static int visitedCount;

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int skies = stdin.nextInt();

        for (int i = 1; i <= skies; i++) {
            int vertices = stdin.nextInt();
            int edges = stdin.nextInt();
            int cycles = 0;

            EdgeList[] graph = new EdgeList[vertices];

            for (int j = 0; j < vertices; j++) {
                graph[j] = new EdgeList(j);
            }

            HashSet<Integer> set = new HashSet<>();

            for (int j = 0; j < edges; j++) {
                int source = stdin.nextInt() - 1;
                int dest = stdin.nextInt() - 1;

                set.add(dest);
                set.add(source);

                graph[source].add(dest);
                graph[dest].add(source);
            }

            boolean[] visited = new boolean[vertices];
            int components = 0;

            for (int j = 0; j < graph.length; j++) {
                if (visited[j] == false && set.contains(j) == true) {
                    components++;
                    int temp = visitedCount;
                    int edgeCount = DFS(graph, visited, j) / 2;
                    int verticeCount = visitedCount - temp;

                    if (edgeCount >= verticeCount)
                        cycles++;
                }
            }

            System.out.printf("Night sky #%d: %d constellations, of which %d need to be fixed.%n%n", i, components, cycles);
        }
    }

    public static int DFS(EdgeList[] graph, boolean[] visited, int at) {
        int count = graph[at].neighbors.size();
        int iterator = count;

        visited[at] = true;
        visitedCount++;

        for (int i = 0; i < iterator; i++) {
            if (visited[graph[at].neighbors.get(i)] == false) {
                count += DFS(graph, visited, graph[at].neighbors.get(i));
            }
        }

        return count;
    }
}

class EdgeList {
    public ArrayList<Integer> neighbors;
    public int vertex;

    public EdgeList(int vertex) {
        this.vertex = vertex;
        neighbors = new ArrayList<>();
    }

    public void add(int neighbor) {
        neighbors.add(neighbor);
    }
}