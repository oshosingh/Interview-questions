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
                    int dy = r[1]+temp[1];
                    
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

==============================================================================================================================================

// Given a binary matrix where 0 represents water and 1 represents land, and connected ones form an island, count the total islands.

int countIslands(int[][] mat){

    // Base condition
    if(mat == null || mat.length==0) return 0;

    int m = mat.length;
    int n = mat[0].length;

    int islands = 0;

    boolean[][] visited = new boolean[m][n];

    for(int i=0; i<m; i++){
        for(int j=0; j<n; j++){
            
            // Do BFS
            if(mat[i][j] == 1 && !visited[i][j]){
                bfs(mat, i, j, visited);
                islands++;
            }
        }
    }
}

void bfs(int[][] mat, int i, int j, boolean[][] visited){
    Queue<List<Integer>> q = new LinkedList<>();
    q.add(Arrays.asList(i,j));

    int[][] dir = new int[][] { {-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {-1,1}, {1,0}, {1,1} };

    visited[i][j] = true;

    while(!q.isEmpty()){
        List<Integer> poll = q.poll();
        int x = poll.get(0);
        int y = poll.get(1);

        for(int[] r : dir){
            int dx = x + r[0];
            int dy = y + r[1];

            if(isSafe(dx, dy, visited, mat)){

                visited[dx][dy] = true;
                q.add(Arrays.asList(dx, dy));
            }
        }
    }
}

boolean isSafe(int x. int y, boolean[][] visited, int[][] mat){
    if(x<0 || x>mat.length-1 || y<0 || y>mat[0].length-1 || visited[x][y]) return false;
    return true;
}

======================================================================================================================================