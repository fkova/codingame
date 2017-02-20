import java.util.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int [] xArray=new int[N];
        int [] yArray=new int[N]; 
        double median;
    
        for (int i = 0; i < N; i++) {
            xArray[i]=in.nextInt();
            yArray[i]=in.nextInt();
        }

        //count median
        Arrays.sort(yArray);    
        if (yArray.length % 2 == 0)
        median = ((double)yArray[yArray.length/2] + (double)yArray[yArray.length/2 - 1])/2;
        else
        median = (double) yArray[yArray.length/2];        
        
        //count vertical cables length
        long vCable=0;
        for(long y : yArray){
            vCable+=Math.abs(y-Math.round(median));
        }
        
        //sum horisontal cable and vertical cables length 
        Arrays.sort(xArray);
        if(xArray.length>1){
            System.out.println(xArray[xArray.length-1]-xArray[0]+vCable);
        }
        else{
            System.out.println(0);
        }
    }
}