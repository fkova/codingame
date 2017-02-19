import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        
        int minX = 0;
        int maxX = W - 1;
        int minY = 0;
        int maxY = H - 1;

        while (true) {
            String bombDir = in.next();
            
            if(bombDir.charAt(0)=='U'){
              maxY = Y0 - 1;
            }else if(bombDir.charAt(0)=='D'){
              minY = Y0 + 1;
            }
            
            if(bombDir.indexOf('L')!=-1){
              maxX = X0 - 1;
            }else if (bombDir.indexOf('R')!=-1){
              minX = X0 + 1;
            }
            
            X0 = (int) ( maxX + minX ) / 2;
            Y0 = (int) ( maxY + minY ) / 2;
            
            System.out.println(X0+" "+Y0);
        }
    }
}