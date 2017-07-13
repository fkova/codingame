import java.util.*;

class Solution {

    public static void main(String args[]) {        
        Scanner in = new Scanner(System.in);
        int nbPlaces = in.nextInt();
        int nbTours = in.nextInt();
        int nbGroups = in.nextInt();
        
        int[] p = new int[nbGroups]; 
        
        for (int i = 0; i < nbGroups; i++) {   
            p[i]=in.nextInt();
        }
        
        int[] gains = new int[nbGroups];
		int[] p2 = new int[nbGroups];
		
		for (int i = 0; i < nbGroups; i++) {
		    int currentIndex = i;
		    gains[i] = 0;
		    while (true) {
		        int nextGp = p[currentIndex];
		        if (gains[i] + nextGp > nbPlaces) {
		            break;
		        }
		        gains[i] += nextGp;
		        
		        currentIndex++;
		        if (currentIndex == nbGroups) {
		            currentIndex = 0;
		        }
		        
		        if (currentIndex == i) {
		            break;
		        }
		    }
		    p2[i] = currentIndex;
		}
		
		long total = 0;
		int currentIndex = 0;
		
		for (int i = 0; i < nbTours; i++) {
		    total += gains[currentIndex];
		    currentIndex = p2[currentIndex];
		}

        System.out.println(total);       
    }
}