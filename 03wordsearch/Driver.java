import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Driver{

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
	
       	p.randomAdd();
	System.out.println(p);
    }

}
