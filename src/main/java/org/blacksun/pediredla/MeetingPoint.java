package org.blacksun.pediredla;

import java.util.*;

/**
 * Created by Pediredla on 11/28/16.
 */
public class MeetingPoint {
    public int shortestDistance(int[][] grid) {
        if (grid.length == 0 || grid == null)
            return 0;
        Queue<XY> que = new LinkedList<XY>();
        XY wall = null;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = -1;
                    que.add(new XY(i, j));
                }
                if (grid[i][j] == 2) {
                    wall = new XY(i, j);
                    grid[i][j] = -2;
                }
            }
        }
        Map<XY, int[][]> grids = new HashMap<XY, int[][]>();
        while (!que.isEmpty()) {
            int[][] temp = new int[grid.length][grid[0].length];
            Queue<XY> iter = new LinkedList<XY>();
            XY te = que.poll();
            iter.add(te);
            while (!iter.isEmpty()) {
                XY t = iter.poll();
                int r = t.row;
                int c = t.col;
                if (r > 0 && temp[r - 1][c] == 0 && (r - 1 != wall.row && c != wall.col)) {
                    temp[r - 1][c] = temp[r][c] + 1;
                    iter.add(new XY(r - 1, c));
                }
                if (c > 0 && temp[r][c - 1] == 0 && (r != wall.row && c - 1 != wall.col)) {
                    temp[r][c - 1] = temp[r][c] + 1;
                    iter.add(new XY(r, c - 1));
                }
                if (r < temp.length - 1 && temp[r + 1][c] == 0 && (r + 1 != wall.row && c != wall.col)) {
                    temp[r + 1][c] = temp[r][c] + 1;
                    iter.add(new XY(r + 1, c));
                }
                if (c < temp[0].length - 1 && temp[r][c + 1] == 0 && (r != wall.row && c + 1 != wall.col)) {
                    temp[r][c + 1] = temp[r][c] + 1;
                    iter.add(new XY(r, c + 1));
                }
            }
            grids.put(te, temp);
        }
        for (XY e : grids.keySet()) {
            int[][] curr = grids.get(e);
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] != -1 || grid[i][j] != -2) {
                        grid[i][j] += curr[i][j];
                    }
                }
            }
        }
        List<Integer> val = new ArrayList<Integer>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    grid[i][j] = 1;
                } else if (grid[i][j] == -2) {
                    grid[i][j] = 2;
                } else {
                    val.add(grid[i][j]);
                }
            }
        }
        Collections.sort(val);
        return val.get(0);
    }

    class XY {
        int row;
        int col;

        XY(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
}
