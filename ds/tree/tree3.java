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

// Subtree of another tree
boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null || subRoot==null)
            return root==null && subRoot==null;
        
        if(isSame(root, subRoot))
            return true;
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
boolean isSame(TreeNode root, TreeNode subRoot){
        if(root==null || subRoot==null)
            return root==null && subRoot==null;
        
        else if(root.val == subRoot.val){
            return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
        }
        
        else
            return false;
}


// Invert Binary Tree
TreeNode invertTree(TreeNode root){
    if(root==null) return null;

    TreeNode temp = root.left;
    root.left = invertTree(root.right);
    root.right = invertTree(temp);

    return root;
}

// Lowest Common Ancestor
TreeNode lcs(TreeNode root, TreeNode p, TreeNode q){
    if(root==null) return null;
    if(root.val == p.val || root.val == q.val) return root;

    TreeNode left = lcs(root.left, p, q);
    TreeNode right = lcs(root.right, p, q);

    if(left==null) return right;
    else if(right==null) return left;
    return root;
}