// Construct Binary Tree from Preorder and Inorder Traversal
TreeNode tree(List<Integer> pre, List<Integer> in){
        if(pre.size()==0 && in.size()==0){
            return null;
        }
        
        TreeNode root = new TreeNode(pre.get(0));
        int mid = in.indexOf(pre.get(0));
        
        root.left = tree(pre.subList(1,mid+1), in.subList(0, mid)); // [ pre(1, mid_1) in(0, mid) ]
        root.right = tree(pre.subList(mid+1, pre.size()), in.subList(mid+1, in.size())); 
        // [ pre(mid+1, size) in(mid+1, size) ]
        
        return root;
}

// Construct Binary Tree from Inorder and Postorder
TreeNode solve(List<Integer> in, List<Integer> post){
        if(in.size()==0 && post.size()==0){
            return null;
        }
        TreeNode root = new TreeNode(post.get(post.size()-1));
        int indRoot = in.indexOf(root.val);
        
        root.left = solve(in.subList(0, indRoot), post.subList(0, indRoot));
        // [ in(0, ind) post(0, ind) ]
        
        root.right = solve(in.subList(indRoot+1, in.size()), post.subList(indRoot, in.size()-1));
        // [ in(ind+1, size) post(ind+1, size()-1) ]

        return root;
}

// Construct Binary Search Tree from Preorder Traversal
int idx;
public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        if(preorder.length == 0){
            return null;
        }  
        return solve(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
    
TreeNode solve(int[] preorder, int min, int max){
        if(idx == preorder.length || preorder[idx]<min || preorder[idx]> max){
            return null;
        }
        
        int val = preorder[idx++];
        TreeNode node = new TreeNode(val);
        node.left = solve(preorder, min, val);
        node.right = solve(preorder, val, max);
        return node;   
}

// Convert sorted array to BST
TreeNode solve(int[] nums, int low, int high){
        if(low<0 || high>nums.length-1){
            return null;
        }
        if(low>high){
            return null;
        }
        int mid = (low+high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = solve(nums, low, mid-1);
        node.right = solve(nums, mid+1, high);
        return node;
}