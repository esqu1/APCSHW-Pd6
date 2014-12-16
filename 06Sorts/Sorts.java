public class Sorts{

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
	    c[min] = c[temp];
	}
    }

    public static void bubble(int[] c){

    }
}