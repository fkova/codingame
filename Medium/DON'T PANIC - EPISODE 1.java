import java.util.*;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int nbFloors = in.nextInt(); // number of floors
        int width = in.nextInt(); // width of the area
        int nbRounds = in.nextInt(); // maximum number of rounds
        int exitFloor = in.nextInt(); // floor on which the exit is found
        int exitPos = in.nextInt(); // position of the exit on its floor
        int nbTotalClones = in.nextInt(); // number of generated clones
        int nbAdditionalElevators = in.nextInt(); // ignore (always zero)
        int nbElevators = in.nextInt(); // number of elevators
        
        int epArr[] = new int[nbElevators+1]; 
        
        for (int i = 0; i < nbElevators; i++) {
            epArr[in.nextInt()]=in.nextInt();
        }  
        
        epArr[epArr.length-1]=exitPos;
        
        int round=1;
        int nbClones=0;
        boolean canblock=true;
        int prevFloor=0;
        
        // game loop
        while (true) {
            int cloneFloor = in.nextInt(); // floor of the leading clone
            int clonePos = in.nextInt(); // position of the leading clone on its floor    
            String direction = in.next(); // direction of the leading clone: LEFT or RIGHT
            
            if(prevFloor!=cloneFloor){
                canblock=true;
            }
            
            //spawing time 1,4,7,10,13
            if((round-1)%3==0){
               nbClones++;             
            }            
            
            //debug
            for(int i=0;i<epArr.length;i++){
                System.err.print(epArr[i]+" ");
            }
            System.err.println("\nclonePos: "+clonePos);
            System.err.println("nbClones: "+nbClones);
            
            if (nbFloors==1){
                if(clonePos==width-1 || clonePos==0){
                    System.out.println("BLOCK");
                }else{
                    System.out.println("WAIT");
                } 
            }else if(nbClones>=2){
                if(direction.equals("LEFT")){
                    if(epArr[cloneFloor]>clonePos && canblock){
                        System.out.println("BLOCK");
                        canblock=false;
                    }else{
                        System.out.println("WAIT");
                    }
                }else if(direction.equals("RIGHT")){
                    if(epArr[cloneFloor]<clonePos && canblock){
                        System.out.println("BLOCK");
                        canblock=false;
                    }else{
                        System.out.println("WAIT");
                    }
                }
            }else{
                if(clonePos==width-1 || clonePos==0){
                    System.out.println("BLOCK");
                    canblock=false;
                }else{
                    System.out.println("WAIT");
                } 
            }
            
            round++;
        }
    }
}