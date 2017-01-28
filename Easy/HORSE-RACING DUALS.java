import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> list1=new ArrayList();

        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            list1.add(pi);
        }
        
        Collections.sort(list1);
        int dif=Integer.MAX_VALUE;
        
        for(int i=0;i<list1.size()-1;i++){
            dif=Math.min(dif,Math.abs(list1.get(i)-list1.get(i+1)));
        }
        
        System.out.println(dif);
    }
}