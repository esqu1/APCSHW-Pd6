import java.util.*;

public class Driver{

    public static void main(String[] args){
	int[] L = {10,6,9,4,5,8,1,2,1};
	Sorts.bubble(L);
	for(int el : L){
	    System.out.println(el);
	}
    }
}