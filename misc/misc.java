// Find First and Last Position of Element in Sorted Array
int[] searchRange(int[] a, int target) {
        if(a.length == 0){
            return new int[]{-1, -1};
        }
        
        int ans[] = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        return solve(a, 0, a.length-1, target, ans);
}
    
int[] solve(int[] a, int l, int r, int target, int[] ans){
        while(l<=r){
            int mid = (l+r)/2;
            if(a[mid]<target){
                l = mid+1;
            }
            else if(a[mid]>target){
                r = mid-1;
            }
            else{
                int[] left = solve(a,l,mid-1,target,ans);
                int[] right = solve(a,mid+1,r,target,ans);
                
                ans[0] = left[0]==-1 ? Math.min(mid, ans[0]) : Math.min(ans[0], left[0]);
                ans[1] = right[1]==-1 ? Math.max(mid, ans[1]) : Math.max(ans[1], right[1]);
                return ans;
            }
        }
        
        return new int[]{-1,-1};
}