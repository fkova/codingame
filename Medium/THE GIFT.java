import java.util.*;
import java.util.stream.IntStream;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int C = in.nextInt();
        int[] budget=new int[N];
        int[] solution=new int[N];
        
        for (int i = 0; i < N; i++) {
            budget[i]=in.nextInt();
            solution[i]=0;
        }

        Arrays.sort( budget );
        int sum = IntStream.of(budget).sum();
        
        if(sum<C){
            System.out.println("IMPOSSIBLE");
        }else{   
            while(C>0){
                for(int i=N-1;i>=0;i--){
                    if(C>0 && solution[i]<budget[i]){
                        solution[i]++;
                        C--; 
                    }
                }
            }
            
            for (int i = 0; i<N; i++) {
                System.out.println(solution[i]);
            }
        }        
    }
}