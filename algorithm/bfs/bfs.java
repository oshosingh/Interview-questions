// Shotest path in a binary matrix (1-> cannot move)
int shortestPathBinaryMatrix(int[][] grid) {
        int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

        // base condition, if source is 1
        if(grid[0][0]!=0) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});

        while(q.size()>0){
            int s = q.size();

            // Run for all the cells in queue
            for(int i =0; i<s; i++){
                int temp[] = q.poll();

                // base condition, if reached last cell
                if(temp[0] == grid.length-1 && temp[1] == grid[0].length-1) return temp[2];

                for(int r[]:dir){
                    int dx = r[0]+temp[0];
                    int dy = r[1]+temp[1
                    ];
                    if(isInLimit(dx, dy, grid)){
                        grid[dx][dy]=1;
                        q.add(new int[]{dx, dy,temp[2]+1});
                    }
                }

            }
        }
        return -1;
}
    
public boolean isInLimit(int x, int y, int grid[][]){
    if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==1)return false;
    return true;
}