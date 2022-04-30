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