// Non Reachable islands
int m, n;
int islands(int[][] grid){
    m = grid.length;
    n = grid[0].length;

    boolean[][] visited = new boolean[m][n];

    // Exclude the borders of grid, because they are reachable and gates for internal island
    for(int i=1; i<m-1; i++){
        for(int j=1; j<n-1; j++){
            if(visited[i][j]==false)
                Boolean found = false;
                dfs(grid, i, j, visited, found);
                if(!found)
                    ans++
        }
    }
    return ans;
}

void dfs(int[][] grid, int l, int r, boolean[][] visited, Boolean found){

    //Base conditions
    if(l<0 || l>m-1 || r<0 || r>n-1 || visited[i][j] || grid[i][j] == 0){
        return;
    }

    if(l==m-1 || r==n-1){
        if(grid[l][r]==1)
            found = true
    }

    visited[l][r] = true;
    dfs(grid, l+1, r, visited);
    dfs(grid, l-1, r, visited);
    dfs(grid, l, r+1, visited);
    dfs(grid, l, r-1, visited);
}