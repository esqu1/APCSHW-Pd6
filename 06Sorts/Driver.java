import java.util.*;

public class Driver{

    public static void main(String[] args){
	int[] L = {10,6,9,4,5,8,1,2,1};
	Sorts.bubble(L);
	for(int el : L){
	    System.out.println(el);
	}

	int[] M = {100,68,967,4,556,88,13,244,10};
	Sorts.radix(M);
	for(int el : M){
	    System.out.println(el);
	}
    }
}
