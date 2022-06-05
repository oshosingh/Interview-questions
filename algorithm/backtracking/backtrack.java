// N Queens problem 2
int ans = 0;
int totalQueen(int n){
    List<List<Integer>> queenPos = new ArrayList<>();
    search(n, queenPos, 1, 0);
    return ans;
}

void search(int n, List<List<Integer>> queenPos, int queen, int col){
    // base condition, if placed all queens in board
    if(queen>n){
        ans++; return;
    }

    for(int i=0; i<n; i++){
        if(isSafe(queenPos, i, col)){
            queenPos.add(Arrays.asList(i, col));
            search(n, queenPos, queen+1, col+1);

            // backtrack
            queenPos.remove(Arrays.asList(i, col));
        }
    }
}

boolean isSafe(List<List<Integer>> queenPos, int row, int col){
    for(List<Integer> queenCord : queenPos){

        // if new queen is in row or col of current queen cord
        if(queenCord.get(0)==row || queenCord.get(1)==col) return false;

        // check if new queen is in the diagonal cells, diff of x and y cord is same for diagonal 
        int xDiff = Math.abs(queenCord.get(0)-row);
        int yDiff = Math.abs(queenCord.get(1)-col);

        if(xDiff==yDiff) return false;
    }
    return true;
}