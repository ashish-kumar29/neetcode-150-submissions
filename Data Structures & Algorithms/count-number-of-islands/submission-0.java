class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    int n, m;
    public void dfs(char[][] grid, int i, int j){
        for(int[] dir: dirs){
            int i1=i+dir[0], j1=j+dir[1];
            if(i1<0 || j1<0 || i1>=n || j1>=m || grid[i1][j1]=='0') continue;
            grid[i1][j1]='0';
            dfs(grid, i1, j1);
        }
    }
    public int numIslands(char[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int island=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    island++;
                    grid[i][j]='0';
                    dfs(grid, i, j);
                }
            }
        }
        return island;
    }
}