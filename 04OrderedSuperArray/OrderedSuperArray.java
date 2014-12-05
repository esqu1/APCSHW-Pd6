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
    /*
    public int find(String element){
	int max = Math.ceil(Math.log(size() / Math.log(2)));
	int s = size() / 2;

	while(!get(s).equals(element)){
	    if(Array){

	    }
	}		    
    }
    */
	
    
}
