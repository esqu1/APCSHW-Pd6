public class OrderedSuperArray extends SuperArray{

    public void add(int index, String element){
	add(element);
    }
    
    public void add(String element){
	int index = size() - 1;
	while(true){
	    if(index <= -1){
		super.add(0,element);
		break;
	    }else if(element.compareTo(get(index)) < 0){
		super.add(index,element);
		break;
	    }else{
		index--;
	    }
	 
	}
    }
    
}
