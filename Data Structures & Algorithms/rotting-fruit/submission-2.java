class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenList = new LinkedList<>();
        int n=grid.length, m=grid[0].length;
        int totMin=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2) rottenList.add(new int[]{i,j});
            }
        }
        while(rottenList.size()>0){
            int sz=rottenList.size();
            while(sz-->0){
                int[] coor = rottenList.poll();
                for(int[] dir: dirs){
                    int i1 = coor[0]+dir[0], j1=coor[1]+dir[1];
                    if(i1<0 || i1>=n || j1<0 || j1>=m || grid[i1][j1]!=1) continue;
                    grid[i1][j1]=2;
                    rottenList.add(new int[]{i1,j1});
                }
            }
            totMin++;
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return totMin==0?totMin:totMin-1;
    }
}
