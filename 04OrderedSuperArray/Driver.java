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
	SuperArray L = new SuperArray(2000);
	SuperArray M = new SuperArray(2000);
	SuperArray N = new SuperArray(2000);
	Random r = new Random();
	for(int i = 0; i < 2000; i++){
	    int m = r.nextInt(26) + 97;
	    L.add("" + (char)m);
	    M.add("" + (char)m);
	    N.add("" + (char)m);
	}
	long startTime = System.currentTimeMillis();
	L.sort();
	long endTime = System.currentTimeMillis();
	System.out.println("Arrays.sort(): " + (endTime - startTime));
	System.out.println(L);

	startTime = System.currentTimeMillis();
	M.insertionSort();
	endTime = System.currentTimeMillis();
	System.out.println("insertionSort(): " + (endTime - startTime));
	System.out.println(M);

	startTime = System.currentTimeMillis();
	N.selectionSort();
	endTime = System.currentTimeMillis();
	System.out.println("selectionSort(): " + (endTime - startTime));
	System.out.println(N);
									   
	

    }

}
