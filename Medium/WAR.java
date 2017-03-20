import java.util.*;

class Solution {
    private static Map<String, Integer> map = new HashMap<String, Integer>();        
     
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        List<Integer> w1 = new ArrayList();
        List<Integer> w2 = new ArrayList();
                
        int n = in.nextInt(); // the number of cards for player 1
        for (int i = 0; i < n; i++) {
            String cardp1 = in.next(); // the n cards of player 1
            q1.add(convertToInt(cardp1.substring(0,cardp1.length()-1)));
        }
        System.err.println();
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
            String cardp2 = in.next(); // the m cards of player 2   
            q2.add(convertToInt(cardp2.substring(0,cardp2.length()-1)));
        }

        int round=0;
        int winner=1;
        boolean pat=false;
              
        while(q1.size()>0 && q2.size()>0){
            
            if(w1.size()==0)
            round++;
            
            int a = q1.poll();
            int b = q2.poll();            
            
            if(a==b){               
                w1.add(a);
                w2.add(b);
                
                for(int i=1;i<=3;i++){
                    if(q1.peek()!=null && q2.peek()!=null){
                        w1.add(q1.poll());
                        w2.add(q2.poll());
                    }else{
                        pat=true;
                        break;
                    }
                }               
                        
            }else if(a>b){
                if(w1.size()==0){
                    q1.add(a);
                    q1.add(b);
                }else{
                    w1.add(a);
                    w2.add(b);
                    
                    for(int i : w1){
                        q1.add(i);
                    }
                    
                    for(int i : w2){
                        q1.add(i);
                    }
                    
                    w1.clear();
                    w2.clear();
                }
                
            }else{
                if(w1.size()==0){
                    q2.add(a);
                    q2.add(b);
                }else{
                    w1.add(a);
                    w2.add(b);
                    
                    for(int i : w1){
                        q2.add(i);
                    }
                    
                    for(int i : w2){
                        q2.add(i);
                    }
                    
                    w1.clear();
                    w2.clear();
                }
                
            }
        }
        
        if(q2.size()!=0) winner=2;

        System.err.println();
        
        if(pat){
            System.out.println("PAT");
        }else{
            System.out.println(winner+" "+round);
        }
        
    }
    
    public static int convertToInt(String s){
        try{
            return Integer.valueOf(s);
        }catch(Exception e){
            return map.get(s);
        }
    }
}