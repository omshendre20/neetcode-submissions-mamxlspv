class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}}; //up, down, left, right
        Queue<int[]> queue = new ArrayDeque<>();
        int count = 0;// TIME TAKEN
        int fresh = 0;// FRESH COUNT

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                } else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotten = false;
            for(int i = 0;i<size;i++){
                int[] node = queue.poll();
                int nodeI = node[0];
                int nodeJ = node[1];
                for(int[] d: dir){
                    int deltaI = nodeI + d[0];
                    int deltaJ = nodeJ + d[1];
                    if(
                        deltaI>=0 && deltaI<m &&
                        deltaJ>=0 && deltaJ<n &&
                        grid[deltaI][deltaJ]==1
                    ){
                        fresh--;
                        rotten = true;
                        grid[deltaI][deltaJ] = 2;
                        queue.offer(new int[]{deltaI,deltaJ});
                    }
                }
            }
            if(rotten) count++;
        }
        return fresh==0?count:-1;
    }
}
