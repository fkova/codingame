import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // Number of elements which make up the association table.
        int Q = in.nextInt(); // Number Q of file names to be analyzed.
        
        Map<String,String> mp=new HashMap();
        
        for (int i = 0; i < N; i++) {
            String EXT = in.next(); // file extension
            String MT = in.next(); // MIME type.
            mp.put(EXT.toLowerCase(), MT);
        }
        
        in.nextLine();
        for (int i = 0; i < Q; i++) {
            String FNAME = in.nextLine(); // One file name per line.
            String e="";
            
            if (FNAME.indexOf(".")!=-1){
                e=FNAME.substring(FNAME.lastIndexOf(".")+1).toLowerCase();
            }
            
            if(mp.get(e)!=null){
                   System.out.println(mp.get(e));
                }else {
                    System.out.println("UNKNOWN");
                }         
        }           
    }
}