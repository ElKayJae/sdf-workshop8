package vtp2022.day8;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    //mvn compile exec:java -Dexec.mainClass="vtp2022.day8.App"
    public static void main( String[] args ){
        
        if(args.length>0) System.out.println(args[0]);

        Boolean stop=false;
        System.out.println( "Hello World!" );
        // MineSweeper mineSweeper = new MineSweeper();
        // mineSweeper.print();
        Scanner scanner = new Scanner(System.in);
        Answer answer = new Answer();
        MineSweeper board = new MineSweeper();

        int numOfMines = -1;
        while (numOfMines<10 || numOfMines>100) {
            System.out.print("Please set the number of mines(10-100): "); 
            numOfMines= Integer.parseInt(scanner.nextLine());
            
            if(numOfMines<=100 && numOfMines>=10)
            answer.setMines(numOfMines);
            else System.out.println("Invalid value");
        }
        System.out.println(numOfMines + " mines generated");

        // answer.print();
        answer.checkMines();
        board.setAnswer(answer);
        board.print();
        while (!stop) {
            System.out.print("Input row,col: ");
            String input = scanner.nextLine();
            String[] splitInput = input.split(",");
            int row =Integer.parseInt(splitInput[0]); 
            int col =Integer.parseInt(splitInput[1]); 
            board.checkAnswer(row,col);
            board.print();
            if (board.getValue(row, col).contains("*")){
                stop=true;
                System.out.println("You Lose!");
            }

        }
        
    }
}
