import java.util.*;

class Solution {

    static String LETTERS;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        List<String> words=new ArrayList<>();
        for (int i = 0; i < N; i++) {
            words.add(in.nextLine());
        }
        LETTERS= in.nextLine();
        int maxScore=0;
        String winner="";
        
        words.removeIf(w -> checkWord(w));
        
        for(String s : words){
            int score=getPoint(s);
            if(score>maxScore){
                maxScore=score;
                winner=s;
            }
        }

        System.out.println(winner);
    }
    
    public static int getPoint(String str){ 
        char[] chars = str.toCharArray();
        int score=0;
        
        for(char c : chars){
            if("eaionrtlsu".indexOf(c)!=-1){
                score++;
            }else if("dg".indexOf(c)!=-1){
                score+=2;
            }else if("bcmp".indexOf(c)!=-1){
                score+=3;
            }else if("fhvwy".indexOf(c)!=-1){
                score+=4;
            }else if("k".indexOf(c)!=-1){
                score+=5;
            }else if("jx".indexOf(c)!=-1){
                score+=8;
            }else if("qz".indexOf(c)!=-1){
                score+=3;
            }  
        }
        
        return score;
    }
    
    public static boolean checkWord(String str){
        char[] chars = str.toCharArray();
        String l=LETTERS;
        
        for(char c : chars){
            if(l.indexOf(c)==-1){
                return true; //remove
            }
            l=l.replaceFirst("" +c, "");            
        }
        
        return false; //ok
    }
      
}