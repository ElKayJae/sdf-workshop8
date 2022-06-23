package vtp2022.day8;

// import java.util.Scanner;

public class MineSweeper {

    public String[][] board = new String[10][10];
    public Answer answer = new Answer();

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    
    public MineSweeper(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                // board[i][j] = String.valueOf(i) + String.valueOf(j) +" " ;
                board[i][j] = " | " ;
            }
        }
        
    }
    public void print(){
        System.out.print("\n  ");
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
        System.out.println("-".repeat(34));
        
    }
    
  
    public String[][] checkAnswer(int row, int col){
        //check if the answer and board already tally
        if(board[row][col]!=answer.getAnswerValue(row, col)){
            board[row][col] = answer.getAnswerValue(row, col);

            if (board[row][col].contains("0")){

                if (0!=row){
                    checkAnswer(row-1, col);
                    if (0 != col)checkAnswer(row-1, col-1);
                    if (9 != col)checkAnswer(row-1, col+1);
                }

                if (0 !=col) checkAnswer(row, col-1);
                if (9 !=col) checkAnswer(row, col+1);

                if (9!=row){
                    checkAnswer(row+1, col);
                    if (0!=col) checkAnswer(row+1, col-1);
                    if (9!=col) checkAnswer(row+1, col+1);
                }
            }
        }
        return board;
    }

    public String getValue(int row, int col){
        return board[row][col];
    }

}
