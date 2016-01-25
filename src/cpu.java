/**
 * Created by JL on 1/22/16.
 */

import java.util.*;

public class cpu {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int testCases = stdin.nextInt();

        for(int i = 1; i <= testCases; i++) {
            int nodes = stdin.nextInt();

            ArrayList<Edge> graph = new ArrayList<Edge>();

            for(int j = 0; j < nodes; j++) {
                for(int k = 0; k < nodes; k++) {
                    int weight = stdin.nextInt();

                    if(k == j) continue;

                    graph.add(new Edge(j, k, weight));
                }
            }

            Collections.sort(graph);
            int minimumWire = krustalMST(graph, nodes);
            System.out.println("Design " + i +": " + minimumWire + " micrometers");

            graph.clear();
        }
    }

    public static int krustalMST(ArrayList<Edge> graph, int nodes) {
        int parts = nodes;
        int minimumWire = 0;
        int i = 0;

        DisjointSet disjointS = new DisjointSet(nodes);

        while(parts >= 2) {
            Edge e = graph.get(i);

            if(disjointS.find(e.source) != disjointS.find(e.destination)) {
                disjointS.union(e.source, e.destination);
                minimumWire += e.weight;
                parts--;
            }

            i++;
        }

        i = 0;
        return minimumWire;
    }
}

class DisjointSet {
    private int[] parent;

    public DisjointSet(int size) {
        parent = new int[size];
        for(int i = 0; i < size; i++) parent[i] = i;
    }

    public int find(int source) {
        if(parent[source] == source) return source;
        parent[source] = find(parent[source]);
        return parent[source];
    }

    public void union(int source, int dest) {
        parent[find(source)] = find(dest);
    }
}

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        if(source < destination) {
            this.source = source;
            this.destination = destination;
        }
        if(destination < source) {
            this.source = destination;
            this.destination = source;
        }
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge next) {
        if(weight != next.weight){
            return weight - next.weight;
        }
        else if(source != next.source){
            return source - next.source;
        }
        else
            return destination - next.destination;
    }
}