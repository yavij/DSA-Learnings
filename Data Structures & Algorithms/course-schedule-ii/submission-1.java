class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graphs = new ArrayList<>();
        int[] result = new int[numCourses];
        int[] index = new int[]{numCourses - 1}; // pointer from end
        buildGraph(numCourses, prerequisites, graphs);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graphs, visited, result, index)) {
                return new int[0]; // cycle detected
            }
        }
        return result;
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

    private boolean dfs(int node, List<List<Integer>> graph, int[] visited, int[] result, int[] index) {
    
        // If currently visiting → cycle detected
        if (visited[node] == 1) return true;

        // If already visited → no need to check again
        if (visited[node] == 2) return false;

        // Mark as visiting
        visited[node] = 1;

        // Visit all neighbors
        for (int neighbor : graph.get(node)) {
            if (dfs(neighbor, graph, visited, result, index)) {
                return true;
            }
        }

        // Mark as fully visited
        visited[node] = 2;
        result[index[0]--] = node;

        return false;
    }
    
}
