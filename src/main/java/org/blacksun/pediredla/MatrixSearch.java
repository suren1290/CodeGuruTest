package org.blacksun.pediredla;

/**
 * Created by Pediredla on 11/24/16.
 */
public class MatrixSearch {
    public MatrixSearch() {
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length >= 1 && matrix[0].length >= 1 && matrix != null) {
            int col = matrix[0].length - 1;
            int row = 0;

            while (row <= matrix.length - 1 && col >= 0) {
                if (target == matrix[row][col]) {
                    return true;
                }

                if (target < matrix[row][col]) {
                    --col;
                } else if (target > matrix[row][col]) {
                    ++row;
                }
            }

            return false;
        } else {
            return false;
        }
    }
}

