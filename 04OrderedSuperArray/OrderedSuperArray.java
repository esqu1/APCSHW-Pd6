public class OrderedSuperArray extends SuperArray{

    public void add(int index, String element){
	add(element);
    }

    public void add(String element){
	if(size() == 0){
	    super.add(element);
	}else{
	    int index = size();
	    while( index > 0 && get(index - 1).compareTo(element) > 0){
		index--;
	    }
	    super.add(index,element);
	}
    }
    /**
    public void add(String element){
	int index = size() - 1;
	while(true){
	    if(size() == 0){
		super.add(element);
		break;
	    }else if(index == -1){
		super.add(0,element);
		break;
	    }else if(element.compareTo(get(index)) > 0 ){
		super.add(index+1,element);
		break;
	    }else{
		index--;
	    }
	 
	}
	
    }
    **/
    
}
