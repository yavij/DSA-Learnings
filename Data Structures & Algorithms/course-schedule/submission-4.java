class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graphs = new ArrayList<>();
        buildGraph(numCourses, prerequisites, graphs);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graphs, visited)) {
                return false; // cycle found → cannot finish
            }
        }
        return true;
    }

    //1. Build the graph
    private void buildGraph(int numCourses, int[][] prerequisites, List<List<Integer>> graphs){

        // Initialize empty list for each course
        for (int i = 0; i < numCourses; i++) {
            graphs.add(new ArrayList<>());
        }

        // Fill the graph
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prerequisite = prereq[1];

            graphs.get(prerequisite).add(course);
        }
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] visited) {
    
        // If currently visiting → cycle detected
        if (visited[node] == 1) return true;

        // If already visited → no need to check again
        if (visited[node] == 2) return false;

        // Mark as visiting
        visited[node] = 1;

        // Visit all neighbors
        for (int neighbor : graph.get(node)) {
            if (dfs(neighbor, graph, visited)) {
                return true;
            }
        }

        // Mark as fully visited
        visited[node] = 2;

        return false;
    }
}
