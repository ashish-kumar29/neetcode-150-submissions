class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] prefHeight = new int[n];
        int[] suffHeight = new int[n];
        int i=1, j=n-2;
        prefHeight[0]=height[0];
        suffHeight[n-1]=height[n-1];
        while(i<n){
            prefHeight[i]=Math.max(prefHeight[i-1], height[i]);
            suffHeight[j]=Math.max(suffHeight[j+1], height[j]);
            j--;
            i++;
        }
        int ans=0;
        for(i=0;i<n;i++){
            ans+=(Math.min(prefHeight[i], suffHeight[i])-height[i]);
        }
        return ans;
    }
}

// 0 1 0 2 1 0 1 3 2 1 2 1
// 0 1 1 2 2 2 2 3 3 3 3 3
// 3 3 3 3 3 3 3 3 2 2 2 1
// 1+1+2+1+1