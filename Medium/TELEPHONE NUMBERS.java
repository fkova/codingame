import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<String> nums=new ArrayList();
        for (int i = 0; i < N; i++) {
            nums.add(in.next());
        }

        Collections.sort(nums);
        
        int memory=0;
        String previousNum="";
        boolean check=true;
        
        for(String s : nums){        
            char[] arr=s.toCharArray();
            
            int i=0;
            for(char c : arr){
                if(previousNum.length()>i){
                    if(previousNum.charAt(i)!=c || !check){
                        check=false;
                        memory++;
                    }
                }else{
                    memory++;
                }
                i++;
            }
            
            check=true;
            previousNum=s;
        }
        
        System.out.println(memory);
    }
}