public class Driver{

    public static void main(String[] args){
	System.out.println("idea".compareTo("hi"));
	OrderedSuperArray L = new OrderedSuperArray();
	L.add("hi");
	System.out.println(L);
	System.out.println(L.size());
	L.add("idea");
	System.out.println(L);
	L.add("apple");
	System.out.println(L);
    }

}
