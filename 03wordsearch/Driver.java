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
	    WordGrid p;
	    Random rand = new Random();
	    Scanner s;
	    if(args.length > 2){
		p = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),Long.parseLong(args[2]));
	    }else{
		p = new WordGrid(Integer.parseInt(args[0]),Integer.parseInt(args[1]),rand.nextLong());
	    }
	    if(args.length > 3 && args[3].equals("1")){
		p.loadWordsFromFile("words.txt",false);
	    }else{
		p.loadWordsFromFile("words.txt",true);
	    }
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
