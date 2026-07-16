class Solution {
    public int[] findPeakGrid(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                boolean up = (i == 0) || mat[i][j] > mat[i - 1][j];
                boolean down = (i == n - 1) || mat[i][j] > mat[i + 1][j];
                boolean left = (j == 0) || mat[i][j] > mat[i][j - 1];
                boolean right = (j == m - 1) || mat[i][j] > mat[i][j + 1];

                if (up && down && left && right) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }
}