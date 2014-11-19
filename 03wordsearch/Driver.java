public class Driver{

    public static void main(String[] args){
	WordGrid p = new WordGrid(5,5);
	p.addWordHorizontal("bunny",3,0);
	p.addWordHorizontal("pie",2,1);
	p.addWordHorizontal("banana",2,3);
	p.addWordHorizontal("you",2,1);
	System.out.println(p);
    }

}
