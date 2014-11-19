public class WordGrid{
    private char[][] data;

    /**Initialize the gird to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int row, int cols){
	data = new char[row][cols];
    }

    /**Resets all values in the WordGrid to spaces ' '*/
    private void clear(){
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
		data[i][j] = ' ';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and each row
     *separated by new lines.
     */
    public String toString(){
	String s = "";
	for(int i = 0; i < data.length; i++){
	    s += "[";
	    for(int j = 0; j < data[i].length; j++){
		s+= " " + data[i][j];
	    }
	    s += " ]\n";
	}
	return s;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word, int row, int col){
	if(word.length() >= data[0].length){
	    return false;
	}
	for(int i = col; i < col + word.length(); i++){
	    if(/*<insert something here to check if null> && */ word.charAt(i - col) != data[row][i]){
		return false;
	    }
	}
	for(int i = col; i < col + word.length(); i++){
	    data[row][i] = word.charAt(i - col);
	}
	return true;
    }

}
