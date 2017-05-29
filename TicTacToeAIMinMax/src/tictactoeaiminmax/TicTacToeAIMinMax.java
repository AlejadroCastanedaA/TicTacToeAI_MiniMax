
package tictactoeaiminmax;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeAIMinMax {
    public static final Random RANDOM=new Random();
    public static void main(String[] args) {
        Board b=new Board();
        Scanner scn=new Scanner(System.in);
        b.displayBoard();
        
        System.out.println("Select turn :\n 1. Computer move(X)  or 2. User Move (O) ");
        int choice =scn.nextInt();
        
        if(choice==Board.PLAYER_X){
            Point p =new Point(RANDOM.nextInt(3),RANDOM.nextInt(3));
            b.placeMove(p,Board.PLAYER_X);
            b.displayBoard();
        }
        
        while(!b.isGameOver()){
            boolean moveOk=true;
            do{
                if(!moveOk){
                    System.out.println("Cells already filed");
                }
                
                System.out.println("Your Move : ");
                Point userName=new Point(scn.nextInt(), scn.nextInt());
                moveOk=b.placeMove(userName, Board.PLAYER_O);
            }
            while(!moveOk);
            
            b.displayBoard();
            
            if(b.isGameOver())
                break;
            
            b.minimax(0,Board.PLAYER_X);
            System.out.println("Computer choose position : "+b.computerMove);
            b.placeMove(b.computerMove,Board.PLAYER_X);
            b.displayBoard();
        }
        
        if(b.hasPlayerWon(Board.PLAYER_X))
            System.out.println("You Los1t !");
        else if (b.hasPlayerWon(Board.PLAYER_O))
            System.out.println("You Win !");
        else
            System.out.println("Draw !");
                    
    }
}
