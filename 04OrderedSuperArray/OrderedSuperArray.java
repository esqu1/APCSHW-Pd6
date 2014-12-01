public class OrderedSuperArray extends SuperArray{

    public void add(int index, String element){
	int j = index;
	/*
	while(true){
	    if(element.compareTo(get(j)) < 0){
		Object[] backupfull = new Object[size() + 1];
		for(int i = 0; i < index; i++){
		    backupfull[i] = Array[i];
		}
		backupfull[index] = o;
		for(int i = index; i < size(); i++){
		    backupfull[i+1] = Array[i];
		}
		break;
	    }else{
		i--;
	    }
	    }*/
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
