public class SuperArray{
    private String[] Array;
    private int size;

    //constructors
    public SuperArray(){
	Array = new String[10];
	size = 0;
    }

    public SuperArray(int s){
	Array = new String[s];
	size = 0;
    }

    public String toString(){
	String s = "[ ";
	for(int i = 0; i < size(); i++){
	    s += Array[i] + " ";
	}
	s += "]";
	return s;
    }

    public void add(String o){
	if(size == Array.length){
	    resize(size() + 5);
	}
	Array[size] = o;
	size += 1;
    }


    public void add(int index, String o){
	if(index < 0 || index > size() ){
	    throw new IndexOutOfBoundsException();
	}				
	if(size() == Array.length){
	    resize( size * 2 );
	}
	for(int i = Array.length - 1; i > index; i--){
	    Array[i] = Array[i - 1];
	}
	Array[ index ] = o;
	size++;
    }
	

    public int size(){
	return size;
    }

    public void resize(int newSize){
	String[] backup = new String[newSize];
	for(int i = 0; i < size(); i++){
	    backup[i] = Array[i];
	}
	Array = backup;
    }

    public String set(int index, String o){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String backup = Array[index];
	Array[index] = o;
	return backup;
    }

    public String get(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return Array[index];
    }

    public String remove(int index){
	if(index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	String[] backup = new String[size() - 1];
	for(int i = 0; i < index; i++){
	    backup[i] = Array[i];
	}
	for(int i = index; i < size() - 1; i++){
	    backup[i] = Array[i+1];
	}
	String tobe = Array[index];
	Array = backup;
	size -= 1;
	if(Array.length - size() >= 5){
	    resize(size() - 5);
	}
	return tobe;
    }
    public void clear(){
	for(int i = 0; i < size; i++){
	    set(i,null);
	}
	size = 0;
    }

    public void insertionSort(){
	
    }
}
