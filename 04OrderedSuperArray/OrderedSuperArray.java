public class OrderedSuperArray extends SuperArray{

    public void add(int index, String element){
	add(element);
    }
    
    public void add(String element){
	int index = size() - 1;
	while(true){
	    if(element.compareTo(get(index)) < 0){
		add(index,element);
	    }else{
		index--;
	    }
	 
	}
    }
    
}
