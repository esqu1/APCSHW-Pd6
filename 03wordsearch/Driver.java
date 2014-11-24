import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.InterruptedException;
public class Driver{

    public static void pause(int n){
	try{
	    Thread.sleep(1000 * n);
	}catch(InterruptedException e){
	    Thread.currentThread().interrupt();
	}
    }

    public static void main(String[] args){
	Scanner s;
	WordGrid p = new WordGrid(7,7);
	File F = new File("words.txt");
	try{
	    s = new Scanner(F);
	}catch(FileNotFoundException e){
	    s = new Scanner(System.in);
	}
	ArrayList<String> str = new ArrayList<String>();
	while(s.hasNext()){
	    str.add(s.next());
	}
	System.out.println(str);

	p.randomAdd(str);
	System.out.println("Welcome, mortal! In a few milliseconds, you will be faced with a word search puzzle!");
	pause(2);
	System.out.println("Here are the words you will need to find:");
	pause(1);
	for(int i = 0; i < p.getAvailables().size(); i++){
	    System.out.print(p.getAvailables().get(i) + " ");
	    if(i % 3 == 2){
		System.out.println("");
	    }
	}	

	System.out.println("");
	System.out.println(p);
    }

}
