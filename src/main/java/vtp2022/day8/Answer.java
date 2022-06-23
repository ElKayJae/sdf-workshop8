package vtp2022.day8;

import java.util.Random;

public class Answer {

    public String[][] board = new String[10][10];

    public String[][] getBoard() {
        return board;
    }

    public String getAnswerValue(int row, int col){
        return board[row][col];
    }

    public Answer(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = " | "  ;
            }
        }
        
    }

    //define number of mines

    public String [][] setMines(int num){
        Random random = new Random();
        for (int i = 0; i < num;) {
            int random1 = random.nextInt(10);
            int random2 = random.nextInt(10);
            if ( !board[random1][random2].equals("*| ")){
                board[random1][random2] = "*| " ;
                i++;
            }
        }
        return board;

    }

    public String[][] checkMines(){

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                int count = 0;
                if (0!=i){
                    if (0!=j){
                        if (board[i-1][j-1].contains("*")) count++;
                    }
                    if (9!=j){
                        if (board[i-1][j+1].contains("*")) count++;
                    }
                    if (board[i-1][j].contains("*")) count++;
                }
                if (0!=j){
                    if (board[i][j-1].contains("*")) count++;
                }
                if (9!=j){
                    if (board[i][j+1].contains("*")) count++;
                }

                if (9!=i){
                    if(0!=j){
                        if (board[i+1][j-1].contains("*")) count++;
                    }
                    if (9!=j){
                        if (board[i+1][j+1].contains("*")) count++;
                    }
                    if (board[i+1][j].contains("*")) count++;
                }
                if (!board[i][j].contains("*"))
                board[i][j]=String.valueOf(count+"| ") ;
            }  
        }
        return board;
    }
    

    public void print(){
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print( " " + i +" ");
            }

        System.out.print("\n"+"-".repeat(34)+"\n");
        
        for (int i = 0; i < board.length; i++) {
            System.out.print(i+" | ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                }
            System.out.println();
        }
        System.out.print("-".repeat(34));
    }   
    

}
