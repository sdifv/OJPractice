class Solution {
    public void rotate(int[][] matrix) {
        int rn = matrix.length;
        int cn = matrix[0].length;
        // 先将方阵进行转置
        for(int i=0;i<rn;i++){
            for(int j=0;j<cn;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再将矩阵的各行元素进行逆转
        for(int i=0;i<rn;i++){
            for(int j=0;j<cn/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][cn-j-1];
                matrix[i][cn-j-1] = tmp;
            }
        }
    }
}