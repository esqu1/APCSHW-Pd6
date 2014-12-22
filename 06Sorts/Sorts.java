import java.util.*;

public class Sorts{

    public static String name(){
	return "Lin,Brandon";
    }

    public static int period(){
	return 6;
    }

    public static int[] randomArrayofInts(int length){
	int[] c = new int[length];
	Random r = new Random();
	for(int i = 0; i < length; i++){
	    c[i] = r.nextInt(10000);
	}
	return c;
    }

    public static void insertion(int[] c){
	for(int i = 1; i < c.length; i++){
	    int j = i;
	    int temp = c[j];
	    while(j > 0 && temp < c[j-1]){
		c[j] = c[j-1];
		j--;
	    }
	    c[j] = temp;
	}
    }

    public static void selection(int[] c){
	for(int i = 0; i < c.length; i++){
	    int min = i;
	    for(int j = i+1; j < c.length; j++){
		if(c[j] < c[min]){
		    min = j;
		}
	    }
	    int temp = c[i];
	    c[i] = c[min];
	    c[min] = temp;
	}
    }

    public static void bubble(int[] c){
	boolean status = true;
	for(int i = c.length; i > 0; i--){
	    for(int j = 0; j < i-1; j++){
		if(c[j] > c[j+1]){
		    int temp = c[j+1];
		    c[j+1] = c[j];
		    c[j] = temp;
		    status = false;
		}
	    }
	    if(status){
		break;
	    }else{
		status = true;
	    }
	}
    }

    public static void radix(int[] c){
	ArrayList<ArrayList<Integer>> bucket = new ArrayList<ArrayList<Integer>>();
	for(int i = 0; i < 10; i++){
	    bucket.add(new ArrayList<Integer>());
	}	    
	int digs = 0;
	while(true){		
	    for(int i = 0; i < c.length; i++){
		bucket.get((c[i] / (int)Math.pow(10,digs)) % 10).add(c[i]);
	    }
	    if(bucket.get(0).size() == c.length){
		return;
	    }
	    int counter = 0;
	    for(int i = 0; i < bucket.size(); i++){
		for(int j = 0; j < bucket.get(i).size(); j++){
		    c[counter] = bucket.get(i).get(j);
		    counter += 1;
		}
		bucket.get(i).clear();
	    }
	    digs += 1;
	}
    }
    
}
