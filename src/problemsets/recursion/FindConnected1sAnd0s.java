package problemsets.recursion;

public final class FindConnected1sAnd0s {
    /*
     * Two cells are said to be connected if they are adjacent to each other horizontally, veritically and diagonally
     *          0 0 0 0 0
     *          0 1 1 1 0
     *          1 1 1 1 1
     *          0 1 1 1 0
     *          0 0 0 0 0
     */

    private final static int[][] DIR  ={
            {0,1}, {1,0}, {0,-1}, {-1,0},
            {1,1}, {-1,1}, {1,-1}, {-1, -1}
    };
    private static int dfs(int[][] mat, int i, int j,int rows, int cols,  boolean[][] vis){
        if(i < 0 || j <0 || i >= rows || j >=cols)
            return 0;
        if(vis[i][j] || mat[i][j] == 0)
            return 0;

        int size = 1;
        vis[i][j] = true;
        for(int[] d: DIR){
            size += dfs(mat, i + d[0] ,j+d[1], rows, cols, vis);
        }
        return size;
    }
    public static int largestConnectedComponent(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;

        boolean[][] vis = new boolean[rows][cols];
        int maxSize = 0;

        for(int i=0; i< rows; i++){
            for(int j=0; j< cols ;j++){
                if(mat[i][j]==1 && !vis[i][j]){
                    maxSize  = Math.max(maxSize, dfs(mat, i, j, rows, cols, vis));
                }
            }
        }
        return maxSize;
    }

}
