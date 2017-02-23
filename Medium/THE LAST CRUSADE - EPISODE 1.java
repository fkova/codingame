import java.util.*;

class Player {

    private static Map<String,Integer> map=new HashMap();     

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // number of columns.
        int H = in.nextInt(); // number of rows.
        in.nextLine();
           
        for (int i = 0; i < H; i++) {
            // represents a line in the grid and contains W integers. Each integer represents one room of a given type.
            String LINE=in.nextLine();
            int[] codes=Arrays.asList(LINE.split(" ")).stream().mapToInt(Integer::parseInt).toArray();

            for(int j=0;j<W;j++){
                if(codes[j]!=0){
                    map.put(j+" "+i,codes[j]);
                }
            }                    
        }
        int EX = in.nextInt(); // the coordinate along the X axis of the exit (not useful for this first mission, but must be read).
        
        // game loop
        while (true) {
            int XI = in.nextInt();
            int YI = in.nextInt();
            String POS = in.next();
            
            String nextRoom= findNext(XI,YI,POS);

            System.out.println(nextRoom);
        }   
    }
    
    static String findNext(int x,int y,String from){
        
        String nextCell=null;
        int type=map.get(x+" "+y);
        
        switch(type){
            case 6:
            case 2:  
                if(from.equals("LEFT")){
                    nextCell=(x+1)+" "+y;
                }else{
                    nextCell=(x-1)+" "+y;
                }
                break;
            case 10: nextCell=(x-1)+" "+y; break;
            case 11: nextCell=(x+1)+" "+y; break;
            case 4:
                if(from.equals("TOP")){
                    nextCell=(x-1)+" "+y;
                }else{
                    nextCell=x+" "+(y+1);
                }
                break;
            case 5:
                if(from.equals("LEFT")){
                    nextCell=x+" "+(y+1);
                }else{
                    nextCell=(x+1)+" "+y;
                }
                break;
            default: nextCell=x+" "+(y+1); break;   
        }        
        
        return nextCell;
    }
}