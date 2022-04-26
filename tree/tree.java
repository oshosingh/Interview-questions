class Tree {
    int val;
    Tree left;
    Tree right;

    public Tree(int val){
        this.val;
    }
    public Tree(int val, Tree left, Tree right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// InOrder
void inOrder(Tree root){
    if(root == null){
        return;
    }

    inOrder(root.left);
    System.out.println(root.val);
    inOrder(root.right);
}

// PreOrder
void preOrder(Tree root){
    if(root == null){
        return;
    }

    System.out.println(root.val);
    inOrder(root.left);
    inOrder(root.right);
}

// PostOrder
void postOrder(Tree root){
    if(root == null){
        return;
    }

    inOrder(root.left);
    inOrder(root.right);
    System.out.println(root.val);
}

// Breadth first / level order
void levelOrder(Tree root){
    if(root == null){
        return;
    }
    Queue<Tree> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){
        Tree top = queue.pop();
        System.out.println(top.val);
        if(top.left != null){
            queue.add(top.left);
        }
        if(top.right != null){
            queue.add(top.right);
        }
    }
}

// Height of tree
void height(Tree root){
    if(root == null){
        return 0;
    }
    int lh = height(root.left);
    int rh = height(root.right);

    return Math.max(lh, rh)+1;
}

// Diameter of tree
int max = 0;
void diameter(Tree root){
    if(root == null){
        return 0;
    }
    int lh = diameter(root.left);
    int rh = diameter(root.right);

    max = Math.max(max, lh+rh); // counting edges
    return Math.max(lh, rh)+1;
}
return max;

// Validate Binary Search Tree
public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        
        if(root.left == null && root.right == null){
            return true;
        }
        
        return solve(root, Long.MIN_VALUE, Long.MAX_VALUE);
}
    
boolean solve(TreeNode root, long min, long max){
        if(root == null){
            return true;
        }
        
        if((long)root.val > min && (long)root.val < max){
            boolean x = solve(root.left, min, root.val);
            boolean y = solve(root.right, root.val, max);
            
            return x&&y;
        }
        else{
            return false;
        }
}