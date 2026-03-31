class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int INF = 2147483647;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==0){
                    System.out.println("Treasure at: ("+ i+" "+j+")");
                    queue.offer(new int[]{i,j});
                }
            }
        }
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0, 1}}; //up, down, left, right
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int nodeI = node[0];
            int nodeJ = node[1];
            for(int[] d: dir){
                int deltaI = nodeI + d[0];
                int deltaJ = nodeJ + d[1];
                if (
                    deltaI >= 0 && deltaI < m &&
                    deltaJ >= 0 && deltaJ < n &&
                    grid[deltaI][deltaJ] == INF
                ) {
                    grid[deltaI][deltaJ] = grid[nodeI][nodeJ] + 1;
                    queue.offer(new int[]{deltaI, deltaJ});
                }
            }
        }
    }
}