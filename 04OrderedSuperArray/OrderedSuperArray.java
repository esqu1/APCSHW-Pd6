public class OrderedSuperArray extends SuperArray{

    public void add(int index, String element){
	add(element);
    }

    public OrderedSuperArray(int length){
	super(length);
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
    
    public int find(String element){
	int max = (int) Math.ceil(Math.log(size() / Math.log(2)));
	int s = size() / 2;
	int tries = 0;
	int upperLimit = 0;
	int lowerLimit = size() - 1;

	while(!get(s).equals(element)){
	    System.out.println(s + " with " + tries + " tries");
	    if(tries > max){
		return -1;
	    }
	    if(element.compareTo(get(s)) < 0){
		lowerLimit = s;
		s = (s + upperLimit) / 2;
	    }else{
		upperLimit = s;
		s = (s + lowerLimit) / 2;
	    }
	    tries+= 1;
	}
	if(get(0).equals(element)){
	    return 0;
	}
	if(get(s).equals(element)){
	    while(s > 0){
		s--;
		if(!get(s).equals(element)){
		    return s+1;
		}
	    }
	}
	System.out.println(2);
	return -1;
    }
	
    
}
