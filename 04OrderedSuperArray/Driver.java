import java.util.*;
public class Driver{

    public void badInsertionSort(SuperArray L){
        OrderedSuperArray c = new OrderedSuperArray(50);
        while( L.size() > 0){ 
            c.add(L.remove(0));
        }
        while(c.size() > 0){
            L.add(c.remove(0));
        }
    }

    public static void main(String[] args){
	SuperArray L = new SuperArray(10000);
	SuperArray M = new SuperArray(10000);
	SuperArray N = new SuperArray(10000);
	OrderedSuperArray O = new OrderedSuperArray(50);
	Random r = new Random();
	for(int i = 0; i < 10000; i++){
	    int m = r.nextInt(26) + 97;
	    L.add("" + (char)m);
	    M.add("" + (char)m);
	    N.add("" + (char)m);
	}
	for(int i = 0; i < 50; i++){
	    int n = r.nextInt(26) + 97;
	    O.add("" + (char)n);
	}
	System.out.println(O);

	System.out.println(O.find("o"));
	
	long startTime = System.currentTimeMillis();
	L.sort();
	long endTime = System.currentTimeMillis();
	System.out.println("Arrays.sort(): " + (endTime - startTime));

	startTime = System.currentTimeMillis();
	M.insertionSort();
	endTime = System.currentTimeMillis();
	System.out.println("insertionSort(): " + (endTime - startTime));

	startTime = System.currentTimeMillis();
	N.selectionSort();
	endTime = System.currentTimeMillis();
	System.out.println("selectionSort(): " + (endTime - startTime));

									   
	

    }

}
