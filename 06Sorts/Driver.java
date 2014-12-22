import java.util.*;

public class Driver{

    public static void main(String[] args){

	int[] tester = Sorts.randomArrayofInts(20000);

	int[] Array1 = Arrays.copyOf(tester,20000);
	long startTime = System.currentTimeMillis();
	Sorts.insertion(Array1);
	long endTime = System.currentTimeMillis();
	System.out.println("Insertion: " + (endTime - startTime));

	int[] Array2 = Arrays.copyOf(tester,20000);
	startTime = System.currentTimeMillis();
	Sorts.selection(Array2);
	endTime = System.currentTimeMillis();
	System.out.println("Selection: " + (endTime - startTime));
	
	int[] Array3 = Arrays.copyOf(tester,20000);
	startTime = System.currentTimeMillis();
	Sorts.bubble(Array3);
	endTime = System.currentTimeMillis();
	System.out.println("Bubble: " + (endTime - startTime));

	int[] Array4 = Arrays.copyOf(tester,20000);
	startTime = System.currentTimeMillis();
	Sorts.radix(Array4);
	endTime = System.currentTimeMillis();
	System.out.println("Radix: " + (endTime - startTime));

	int[] Array5 = Arrays.copyOf(tester,20000);
	startTime = System.currentTimeMillis();
	Arrays.sort(Array5);
	endTime = System.currentTimeMillis();
	System.out.println("Arrays.sort: " + (endTime - startTime));
    }
}
