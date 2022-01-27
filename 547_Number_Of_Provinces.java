/* Idea - Run dfs on every node. When dfs ends for a node, increase count of provinces.
   Space Complexity - O(n) where n is the number of nodes/cities
   Time Complexity - O(n + e) where e is the number of edges in the graph
*/

class Solution {
    public int findCircleNum(int[][] isConnected) {

        HashMap<Integer, Boolean> visited = new HashMap<>();
        int numProvinces = 0;
        
        for(int i = 0; i < isConnected.length; i++) {
            visited.put(i, false);
        }
        
        for(int i = 0; i < isConnected.length; i++) {
            if(!visited.get(i)) {
                performDFS(i, visited, isConnected);
                numProvinces++;
            }
        }
        
        return numProvinces;
    }
    
    private void performDFS(int node, HashMap<Integer, Boolean> visited, int[][] isConnected) {
        visited.put(node, true);
        for(int adjNode = 0; adjNode < isConnected[node].length; adjNode++) {
            if(isConnected[node][adjNode] == 1 && !visited.get(adjNode)) {
                performDFS(adjNode, visited, isConnected);
            }
        }
    }
}
