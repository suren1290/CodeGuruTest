package org.blacksun.pediredla;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Pediredla on 1/10/17.
 */
public class WordSearch {
    class XYCoordinate{
        int x;
        int y;
        int len;
        XYCoordinate(int row, int col, int l){
            x = row;
            y = col;
            len = l;
        }
    }
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||word==null||word.length()<0)
            return false;
        char[] w = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == w[0]){
                    if(bfsHelper(new XYCoordinate(i, j, 0), w, board))
                        return true;
                }
            }
        }
        return false;
    }
    private boolean bfsHelper(XYCoordinate coordinate, char[] w, char[][] ma){
        Queue<XYCoordinate> que = new LinkedList<XYCoordinate>();
        que.add(coordinate);
        char[][] board = new char[ma.length][ma[0].length];
        System.arraycopy(ma, 0, board, 0, ma.length);
        char[] search = new char[w.length];
        while(!que.isEmpty()){
            XYCoordinate curr = que.poll();
            search[curr.len] = w[curr.len];
            if(w.length-1==curr.len)
                return true;
            if(curr.x>0 && curr.len<w.length-1 && board[curr.x-1][curr.y]==w[curr.len+1]){
                que.offer(new XYCoordinate(curr.x-1, curr.y, curr.len+1));
            }
            if(curr.y>0 && curr.len<w.length-1 && board[curr.x][curr.y-1]==w[curr.len+1]){
                que.offer(new XYCoordinate(curr.x, curr.y-1, curr.len+1));
            }
            if(curr.x<board.length-1 && curr.len<w.length-1 && board[curr.x+1][curr.y]==w[curr.len+1]){
                que.offer(new XYCoordinate(curr.x+1, curr.y, curr.len+1));
            }
            if(curr.y<board[0].length-1 && curr.len<w.length-1 && board[curr.x][curr.y+1]==w[curr.len+1]){
                que.offer(new XYCoordinate(curr.x, curr.y+1, curr.len+1));
            }
        }
        return false;
    }
}
