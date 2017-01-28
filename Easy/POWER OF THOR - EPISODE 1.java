import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
            
            String dir="E";
            
            int h=lightX-initialTX;
            int w=lightY-initialTY;
            
            System.err.println("h:"+h+" w:"+w);
            
            if(h>0 && w==0){
                dir="E"; initialTX++;                
            }else if(h<0 && w==0){
                dir="W"; initialTX--;          
            }else if(h==0 && w<0){
                dir="N"; initialTY++;            
            }else if(h==0 && w>0){
                dir="S"; initialTY--;    
            }else if(h<0 && w>0){
                dir="SW"; initialTX--;initialTY++;   
            }else if(h>0 && w>0){
                dir="SE"; initialTX++;initialTY++;   
            }else if(h<0 && w<0){
                dir="NW"; initialTX--;initialTY--;   
            }else if(h>0 && w<0){
                dir="NE"; initialTX++;initialTY--;   
            }
                       
            // A single line providing the move to be made: N NE E SE S SW W or NW
            System.out.println(dir);
        }
    }
}