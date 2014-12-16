import java.util.*;

public class Driver{

    public static void main(String[] args){
	int[] L = {56,23,5,12,87,34};
	Sorts.bubble(L);
	for(int el : L){
	    System.out.println(el);
	}
    }
}