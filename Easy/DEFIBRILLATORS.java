import java.util.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double LON = Double.valueOf(in.next().replace(",","."));
        double LAT = Double.valueOf(in.next().replace(",","."));
        int N = in.nextInt();
        in.nextLine();
        
        double mindist=Double.MAX_VALUE;
        String name="";
        
        for (int i = 0; i < N; i++) {
            String DEFIB = in.nextLine();
            String [] d = DEFIB.split(";");
            double LON2=Double.valueOf(d[4].replace(",","."));
            double LAT2=Double.valueOf(d[5].replace(",","."));
            double x = (LON2 - LON)*Math.cos((LAT+LAT2)/2);
            double y = LAT2 - LAT;
            double dist=Math.sqrt(x*x+y*y)*6371;
            
            if(dist<mindist){
                mindist=dist;
                name=d[1];
            }            
        }

        System.out.println(name);
    }
}