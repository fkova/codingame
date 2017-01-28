import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String temps = in.nextLine(); // the n temperatures expressed as integers ranging from -273 to 5526
        
        System.err.println(temps);
        
        if(temps != null && !temps.equals("")){
            
            Integer[] arr = Arrays.asList(temps.split(" ")).stream()
            .map( el -> Integer.valueOf(el))   
            .toArray(Integer[]::new);
        
            int min=Integer.MAX_VALUE;
            
            for(Integer i : arr){
                if(Math.abs(i)<Math.abs(min)){
                    if(Arrays.asList(arr).contains(Math.abs(min))){
                        min=Math.abs(i);
                    }else{
                        min=i;
                        }
                }
            }
            
            System.out.println(min);
        
        }else{
            System.out.println("0");
        }
    }
}