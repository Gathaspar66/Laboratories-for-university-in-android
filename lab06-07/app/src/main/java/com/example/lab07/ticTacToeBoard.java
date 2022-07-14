package com.example.lab07;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ticTacToeBoard extends BaseAdapter {
    private Context context;
    private int player; //Current player (for move)
    private int[][] board = new int[3][3]; //game board

    //Constructor
    public ticTacToeBoard(Context cont, String moves) {
        context=cont;

        //Filing empty board by moves history
        int mvs = 0;
        for (String move:moves.split("(?!^)")) {
            if(!move.equals(""))
                this.move(Integer.parseInt(move), mvs++%2);
        }
        //Setting Current Player
        player = mvs%2;
    }
    //Method make move
    private boolean move(int col, int player)
    {
        int position=col;
        int row = 0;
        int column=0;
        int temp=7;

        for(int i=0;i<3;i++){
            for(int y=0;y<3;y++) {
                if (temp == position) {
                    row = i;
                    column = y;
                }
                if(y!=2)
                temp++;
            }
                temp = temp - 5;
        }

        if(board[row][column]!=0){
            return false;
        }else{
            board[row][column] = player + 1;
            return true;
        }
    }
    //Public method making move for playing user
    public ticTacToeBoard add(long col){
        //If change `player++%2` to `player` there is no switching between players
        if(this.move((int)col, player++%2))
            return this;
        return null;
        //return only when moves are correct
    }
    @Override //Must be in adapter
    public int getCount() {
        return 3*3;
    }
    @Override //Must be in adapter
    public Object getItem(int position) {
        return position%3;
    }
    @Override //Must be in adapter
    public long getItemId(int position) {
        return position%3;
    }
    //Method for generate view of singe element in greed
    @Override //Must be in adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        //Create element - ImageView
        ImageView iv = new ImageView(context);
        //Calculate position of element into board array
        int col = position%3;
        int row = 2-position/3; // 2 because, rows are iterated from 0

        //Set appropriate image
        switch (board[row][col]){
            case 0:
                iv.setImageResource(R.drawable.circle);
                break;
            case 1:
                iv.setImageResource(R.drawable.player1);
                break;
            case 2:
                iv.setImageResource(R.drawable.player2);
                break;
        }

        //Seting size of image - 120x120 px
        iv.setLayoutParams(new LinearLayout.LayoutParams(120,120));
        return iv;
    }
    public int checkWin(){
        int inRow = 0;

        //Check rows
        for(int row=0; row<3; row++, inRow=0)
            for(int col=0;col<2;col++)
                if(board[row][col]==board[row][col+1]) {
                    inRow++;
                    if(inRow==2 && board[row][col]!=0)
                        return board[row][col];
                }else
                    inRow=0;

        //check cols
        for(int col=0;col<3;col++, inRow=0)
            for(int row=0;row<2;row++)
                if(board[row][col]==board[row+1][col]){
                    inRow++;
                    if(inRow==2 && board[row][col]!=0)
                        return board[row][col];
                }else
                    inRow=0;


        //Chceck rising horizontal

                for (int x=2, y=0; x >0 && y < 2; x--, y++, inRow=0)
                    if (board[x][y] == board[x - 1][y + 1]) {
                        inRow++;
                        if (inRow == 2 && board[x][y] != 0)
                            return board[x][y];
                    } else
                        inRow = 0;


        //Chceck falling horizontal

                for (int x=0, y=0; x < 2 && y < 2; x++, y++, inRow=0)
                    if (board[x][y] == board[x + 1][y + 1]) {
                        inRow++;
                        if (inRow == 2 && board[x][y] != 0)
                            return board[x][y];
                    } else
                        inRow = 0;

        return 0;
    }
}
