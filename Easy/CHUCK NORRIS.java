import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        System.err.println(MESSAGE);
        
        byte[] bytes = MESSAGE.getBytes();       
        String binary=new String(); //1000011
        String encoded=new String(); //0 0 00 0000 0 00
        
        for(byte b: bytes){
            String a=Integer.toBinaryString(b);
            if(a.length()<7)
            a="0"+a;
            
            binary+=a;
            
        }
        
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='0'){
                encoded+="00 0";
            }else{
                encoded+="0 0";
            }
            
            
            for(int j=i;j<binary.length()-1;j++){
                if(binary.charAt(j)==binary.charAt(j+1)){
                    encoded+="0";  
                    i++;
                }else{break;}
            }
            if(i<binary.length()-1)
            encoded+=" ";
            
        }
        
        
        System.out.println(encoded);
    }
}