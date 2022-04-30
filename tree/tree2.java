// Construct Binary Tree from Preorder and Inorder Traversal
TreeNode buildTree(int[] preorder, int[] inorder) {
       List<Integer> pre = new ArrayList<>();
        
        for(int x : preorder){
            pre.add(x);
        }
        
        List<Integer> in = new ArrayList<>();
        
        for(int x : inorder){
            in.add(x);
        }
        
        return tree(pre, in);
}
    
TreeNode tree(List<Integer> pre, List<Integer> in){
        if(pre.size()==0 && in.size()==0){
            return null;
        }
        
        TreeNode root = new TreeNode(pre.get(0));
        int mid = in.indexOf(pre.get(0));
        
        root.left = tree(pre.subList(1,mid+1), in.subList(0, mid));
        root.right = tree(pre.subList(mid+1, pre.size()), in.subList(mid+1, in.size()));
        
        return root;
}