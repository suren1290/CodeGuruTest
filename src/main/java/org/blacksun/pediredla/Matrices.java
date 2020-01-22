package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */
public class Matrices {
    public Matrices() {
    }

    public void setZeroes(int[][] matrix) {
        if (matrix.length != 0 && matrix != null) {
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    if (matrix[i][j] == 0) {
                        this.dfs(matrix, i, j);
                    }
                }
            }

        }
    }

    private void dfs(int[][] matrix, int row, int col) {
        if (row < matrix[0].length - 1 && row >= 0 && col < matrix.length - 1 && col >= 0) {
            if (matrix[row][col] == 0) {
                this.dfs(matrix, row + 1, col);
                this.dfs(matrix, row - 1, col);
                this.dfs(matrix, row, col + 1);
                this.dfs(matrix, row, col - 1);
            } else if (matrix[row][col] == 1) {
                matrix[row][col] = 0;
            }

        }
    }
}

