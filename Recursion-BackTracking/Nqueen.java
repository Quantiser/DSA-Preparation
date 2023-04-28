/*The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

  */
import java.util.*;
  class Nqueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solve(board,0,res,n);
        return res;
        
    }
    public void solve(char[][] board,int colIndex,List<List<String>> res, int n){
        if(colIndex==n){
            res.add(construct(board));
            return;
        }
        for(int row=0;row<board.length;row++){
            if(validate(board,row,colIndex)){
                board[row][colIndex]='Q';
                solve(board,colIndex+1,res,n);
                board[row][colIndex]='.';
            }
        }
    }
    public boolean validate(char[][] board,int x,int y){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<y;j++){
                if(board[i][j]=='Q' && (x+y==i+j || x+j==y+i || x==i)){
                    return false;
                }
            }
        }
        return true;
    }
    public List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public static void main(String[] args) {
        Nqueen s = new Nqueen();
        List<List<String>> res = s.solveNQueens(4);
        for(List<String> l:res){
            for(String str:l){
                System.out.println(str);
            }
            System.out.println();
        }
    }
}