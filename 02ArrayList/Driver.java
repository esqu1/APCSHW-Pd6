import java.util.*;
public class Driver{

    public static void main(String[] args){
	if(args.length > 0){
	    ArrayList<Integer> L = new ArrayList<Integer>(200000);
	    for(int i = 0; i < 200000; i++){
		L.set(i,i);
	    }
	    String element = args[0];
	    if(element.equals("1")){
		System.out.println("Randomizin' smartly.");
		ArrayListMethods.randomize(L);
		System.out.println("Done.");
	    }else if(element.equals("2")){
		System.out.println("This might be right...");
		ArrayListMethods.randomize2(L);
		System.out.println("Done.");
	    }else if(element.equals("3")){
		System.out.println("This is stupid.");
		ArrayListMethods.stupidRandom(L);
		System.out.println("Done.");
	    }else{
		System.out.println("Invalid input. Enter \"java Driver.java\" to check the usage.");
	    }
	}else{
	    System.out.println("Usage:\n" +
			       "java Driver.java <number>\n" +
			       "<number> corresponds to the following actions:\n" +
			       "1: Randomize by swapping elements.\n" +
			       "2: Randomize by appending to the end of the list.\n" +
			       "3: Randomize stupidly.");
	}
    }
			       
		
		

}
