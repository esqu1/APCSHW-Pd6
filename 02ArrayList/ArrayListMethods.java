import java.util.*;
public class ArrayListMethods{

    public static void collapseDuplicates(ArrayList<Integer> L){
	for(int i = 0; i < L.size() - 1; i++){
	    while(true){
		if(L.get(i) == L.get(i+1)){
		    L.remove(i+1);
		}else{
		    break;
		}
	    }
	}
    }

    public static void randomize(ArrayList<Integer> L){
	Random r = new Random();
	for(int i = 0; i < L.size(); i++){
	    int place = r.nextInt(L.size());
	    int temp = L.get(place);
	    L.set(place,L.get(i));
	    L.set(i,temp);
	}
    }


    public static void main(String[] args){
	ArrayList<Integer> L = new ArrayList<Integer>();
	int[] A = {1,9,3,3,4,2,2,2,7,8,8,8,8,9};
	for(int i = 0; i < A.length; i++){
	    L.add(A[i]);
	}
	collapseDuplicates(L);
	System.out.println(L);
	ArrayList<Integer> M = new ArrayList<Integer>();
	for(int i = 0; i < 10; i++){
	    M.add(i);
	}
	System.out.println(M);
	randomize(M);
	System.out.println(M);
    }

	


}
