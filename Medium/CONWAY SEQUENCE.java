import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int L = in.nextInt();      
        List<Integer> row =new ArrayList<>();
        List<Integer> nextRow =new ArrayList<>();              
        row.add(R);
        
        for(int i=0;i<L;i++){
            if(L==i+1){
                break;
            }
            
            int count=0;
            int num=row.get(0);
            
            for (int j = 0; j < row.size(); j++) {
                if(num==row.get(j)){
                    count++;    
                }else{
                    nextRow.add(count);
                    nextRow.add(num);
                    num=row.get(j);
                    count=1;
                }  
                
                if(j+1==row.size()){
                    nextRow.add(count);
                    nextRow.add(num);
                }   
            }                    
            
            row.clear();
            row.addAll(nextRow);
            nextRow.clear();
        }
        
        System.out.println(row.toString().replaceAll("[,\\]\\[]", ""));
    }
}