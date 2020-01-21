package org.blacksun.pediredla;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pediredla on 11/30/16.
 */
public class NQueens {

    Set<int[][]> nqueens(int[][] grid, int queens) {
        Set<int[][]> ans = new HashSet<int[][]>();
        if (grid.length == 0 || queens == 0)
            return ans;
        gridFill(0, 0, grid, queens, ans);
        return ans;
    }

    private void gridFill(int row, int col, int[][] grid, int queens, Set<int[][]> ans) {
        if (queens == 0) {
            int[][] temp = new int[grid.length][grid[0].length];
            for (int i = 0; i < temp.length; i++)
                for (int j = 0; j < temp.length; j++)
                    temp[i][j] = grid[i][j];
            ans.add(temp);
            return;
        }
        if (row > grid.length - 1 || col > grid[0].length - 1 || row < 0 || col < 0)
            return;
        int drow = row;
        int dcol = col;
        while (dcol >= 0) {
            if (grid[drow][dcol] == 1)
                return;
            dcol--;
        }
        dcol = col;
        while (drow >= 0) {
            if (grid[drow][dcol] == 1)
                return;
            drow--;
        }
        drow = row;
        while (drow >= 0 && dcol >= 0) {
            if (grid[drow][dcol] == 1)
                return;
            dcol--;
            drow--;
        }
        dcol = col;
        drow = row;
        while (drow < grid.length && dcol >= 0) {
            if (grid[drow++][dcol--] == 1)
                return;
        }
        grid[row][col] = 1;
        for (int i = 0; i < grid.length; i++) {
            if (queens == 0)
                return;
            gridFill(i, col + 1, grid, queens - 1, ans);
        }
        grid[row][col] = 0;
        gridFill(row + 1, col, grid, queens, ans);
    }

    public void printUtil(int[][] grid) {
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
