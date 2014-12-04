import java.util.*;
public class Driver{

    public void badInsertionSort(SuperArray L){
        OrderedSuperArray c = new OrderedSuperArray();
        while( L.size() > 0){ 
            c.add(L.remove(0));
        }
        while(c.size() > 0){
            L.add(c.remove(0));
        }
    }

    public static void main(String[] args){
	SuperArray M = new SuperArray(2000);
	Random r = new Random();
	for(int i = 0; i < 2000; i++){
	    int m = r.nextInt(26) + 97;
	    M.add("" + (char)m);
	}
	
	M.insertionSort();
	System.out.println(M);

    }

}
