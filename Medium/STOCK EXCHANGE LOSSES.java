import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> values=new ArrayList(n);
        for (int i = 0; i < n; i++) {
            values.add(in.nextInt());
        }
        
        int solution = 0;
       
        int max = n == 0 ? 0 : values.get(0);

        for(int value : values.subList( 1, values.size())){
            int dif = value - max;
            if (dif < solution) solution = dif;
            if (value > max) max = value;  
        }

        System.out.println(solution);
    }
}