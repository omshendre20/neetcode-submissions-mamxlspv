class Solution {
    int[][] dir = {{-1,0}, {1, 0}, {0, 1}, {0, -1}};//up, down, left, right
    void bfs(char[][] grid, boolean[][] visited, int rows, int cols, int sr, int sc){        
        Queue<int[]> queue = new ArrayDeque<>();
        visited[sr][sc] = true;
        queue.offer(new int[]{sr, sc});
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int nodeI = node[0];
            int nodeJ = node[1];
            for(int[] d: dir){
                int deltaI = nodeI + d[0];
                int deltaJ = nodeJ + d[1];
                if(
                    deltaI>=0 && deltaI<rows &&
                    deltaJ>=0 && deltaJ<cols &&
                    grid[deltaI][deltaJ]=='1' &&
                    !visited[deltaI][deltaJ]                 
                ){
                    visited[deltaI][deltaJ] = true;
                    queue.offer(new int[]{deltaI, deltaJ});
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    bfs(grid, visited, m, n, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
