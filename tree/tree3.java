// Binary Tree Maximum Path Sum
int ans;
int maxPathSum(Node root){
    ans = Integer.MIN_VALUE;
    solve(root);
    return ans;
}

void solve(Node root){
    if(root == null){
        return 0;
    }
    int leftSum = solve(root.left);
    int rightSum = solve(root.right);

    ans = Math.max(ans, leftSum + root.val + rightSum);
    return root.val + Math.max(leftSum, rightSum);
}