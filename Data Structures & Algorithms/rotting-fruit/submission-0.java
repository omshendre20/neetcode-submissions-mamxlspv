class Solution {
    int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};//up, down, left, right
    int bfs(int[][] grid, boolean[][] visited, int rows, int cols, int sr, int sc){
        Queue<int[]> queue = new ArrayDeque<>();
        visited[sr][sc] = true;
        queue.offer(new int[]{sr,sc});
        int count=-1;
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
                    (grid[deltaI][deltaJ]==1 || grid[deltaI][deltaJ]==2) &&
                    !visited[deltaI][deltaJ]
                ){
                    count++;
                    visited[deltaI][deltaJ] = true;
                    queue.offer(new int[]{deltaI,deltaJ});
                }
            }
        }
        return count;
    }
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==2){
                    System.out.println("rotten fruit: ("+i+", "+j+")");
                    count+= bfs(grid, visited, m, n, i, j);
                }
            }
        }
        return count==0?-1:count;
    }
}
