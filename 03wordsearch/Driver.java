import java.util.*;
public class Driver{

    public static void main(String[] args){
	WordGrid p = new WordGrid(10,10);
	p.load("words.txt");
	p.randomAdd();
	System.out.println(p);
    }

}
