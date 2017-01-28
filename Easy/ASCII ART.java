import java.util.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        in.nextLine();
        String T = (in.nextLine()).toUpperCase();
        
        for (int i = 0; i < H; i++) {
            String ROW = in.nextLine();
            String ROW2="";
            
            for(char c: T.toCharArray()){
               int index="ABCDEFGHIJKLMNOPQRSTUVWXYZ?".indexOf(c);
                if(index!=-1){           
                    ROW2+=ROW.substring(L*index,L*index+L);
                }else{
                    ROW2+=ROW.substring(L*26,L*26+L); //index of ?
                }
            }
            
            System.out.println(ROW2);
        }             
    }
}