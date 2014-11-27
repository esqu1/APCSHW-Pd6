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
	if(args.length > 0){
	    Random rand = new Random();
	    int el0 = Integer.parseInt(args[0]);
	    int el1 = Integer.parseInt(args[1]);
	    long el2;
	    if(args.length > 2){
		el2 = Long.parseLong(args[2]);
	    }else{
		el2 = rand.nextLong();
	    }
	    boolean el3 = !(args.length > 3 && args[3].equals("1"));
	    WordGrid p = new WordGrid(el0,el1);
	    p.setSeed(el2);
	    p.loadWordsFromFile("words.txt",el3);
	    System.out.println("Welcome, mortal! In a few milliseconds, you will be faced with a word search puzzle!");
	    pause(2);
	    System.out.println("Here are the words you will need to find:\n" + p.wordsInPuzzle());
	    pause(2);
	    System.out.println(p);
	}else{
	    System.out.println("Usage:\n" +
			       "  java Driver <rows> <cols> [<random seed> [<display answer>]]\n" +
			       "\n" +
			       "  <rows> and <cols> specify the number of row and columns, respectively.\n" +
			       "  <random seed> is a long-type number that will generate a puzzle based on the seed.\n" +
			       "  <display answer> is set to 1 if you want the answer to be revealed.");

	}
	
    }

}
