package Graph;

import java.util.*;

public class BuildGraph {

    private LinkedList<Integer> adj[];

    public BuildGraph(int v) { // this constructor will give the number of vertex graph has
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Integer>(); // initialization of the adjacency ll with the vertex
        }
    }

    public void addEdges(int source, int destination) {
        adj[source].add(destination);
        adj[destination].add(source);
    }

    public int bfs(int source, int destination) {
        boolean[] visited = new boolean[adj.length]; // this represents the nodes which are already visited during path
                                                     // traversal
        int[] parent = new int[adj.length]; // this tell kisne kisko introduce kia
        Queue<Integer> q = new LinkedList<>(); // using a queue to find the shortest path
        q.add(source);
        parent[source] = -1; // matlb source ko kisi ne introduce nahi karaya
        visited[source] = true;
        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == destination)
                break;
            for (int neighbour : adj[current]) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                    parent[neighbour] = current;
                }
            }
        }
        int current = destination;
        int distance = 0;
        while (parent[current] != -1) {
            System.out.print(current + "->");
            current = parent[current];
            distance++;
        }
        return distance;
    }

    // recursive stack approach for dfs
    // private boolean dfsUtil(int source, int destination, boolean vis[]) {
    // if (source == destination)
    // return true;

    // for (int neighbor : adj[source]) {
    // if (!vis[neighbor]) {
    // vis[neighbor] = true;
    // boolean isConnected = dfsUtil(neighbor, destination, vis);
    // if (isConnected)
    // return true;
    // }
    // }

    // return false;
    // }

    public boolean dfsStack(int source, int destination) {
        boolean vis[] = new boolean[adj.length];
        vis[source] = true;
        Stack<Integer> stack = new Stack<>();

        stack.push(source);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (cur == destination)
                return true;

            for (int neighbor : adj[cur]) {
                if (!vis[neighbor]) {
                    vis[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }

        return false;
    }

    // public boolean dfs(int source, int destination) {
    // boolean vis[] = new boolean[adj.length];
    // vis[source] = true;

    // return dfsUtil(source, destination, vis);
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();
        BuildGraph graph = new BuildGraph(v);
        System.out.println("Enter" + e + "Edges");
        for (int i = 0; i < e; i++) {
            int source = sc.nextInt();
            int destination = sc.nextInt();
            graph.addEdges(source, destination);
        }
        System.out.println("Enter source and destination");

        int source = sc.nextInt();
        int destination = sc.nextInt();

        // int distance = graph.bfs(source, destination);
        // System.out.println("min distance is " + distance);
        // 5 6 (01,12,23,34,24,04) 0 3

        System.out.println("possible " + graph.dfsStack(source, destination));
        // 5 5(04,43,32,21,12) 0 1

        sc.close();
    }
}
