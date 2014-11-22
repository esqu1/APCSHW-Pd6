public class WordGrid{
    private char[][] data;

    /**Initialize the gird to the size specified and fill all of the positions
     *with spaces.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int row, int cols){
	data = new char[row][cols];
	clear();
    }

    /**Resets all values in the WordGrid to spaces ' '*/
    private void clear(){
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
		data[i][j] = ' ';
	    }
	}
    }

    /**Loads the word in a plaintext file into a array of Strings.
     *@return an array of strings containing the list of available words to load.
     */
    public String[] load(){
	File F = new File("words.txt");
	Scanner s = new Scanner(F);
	String str = "";
	while(s.hasNext()){
	    str += s.next();	    
	}
	return str;
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
     *The word is added based on the direction specified by the dirx and diry variables,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical location of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@param dirx ranges from -1 to 1, specifies the direction of the word in the horizontal direction.
     *@param diry ranges from -1 to 1, specifries the direciton of the word in the horizontal direction.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letter that do not match, then false is returned.
     */
    public boolean addWord(String word, int row, int col, int dirx, int diry){
	if(Math.abs(dirx) <= 1 || Math.abs(diry)){
	    return false;
	}
	if((Math.abs(dirx) == 1 && word.length() > data[0].length) || (Math.abs(diry) == 1 && word.length() > data.length)){
	    return false;
	}
	for(int i = 0; i < word.length(); i++){
	    if(data[row+i*dirx][col+i*diry] != ' ' && word.charAt(i) != data[row+i*dirx][col+i*diry]){
		return false;
	    }
	}
	for(int i = 0; i < word.length(); i++){
	    data[row+dirx][col+diry] = word.charAt(i);
	}
       
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical location of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordHorizontal(String word, int row, int col){
	if(word.length() > data[0].length){
	    return false;
	}
	for(int i = 0; i < word.length(); i++){
	    if(data[row][col+i] != ' ' && word.charAt(i) != data[row][col+i]){
		return false;
	    }
	}
	for(int i = 0; i < word.length(); i++){
	    data[row][col+i] = word.charAt(i);
	}
	return true;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical location of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordVertical(String word, int row, int col){
	if(word.length() > data.length){
	    return false;
	}
	for(int i = 0; i < word.length(); i++){
	    if(data[i + row][col] != ' ' && word.charAt(i) != data[i + row][col]){
		return false;
	    }
	}
	for(int i = 0; i < word.length(); i++){
	    data[i + row][col] = word.charAt(i);
	}
	return true;
    }

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top-left to bottom-right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical location of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     */
    public boolean addWordDiagonal(String word, int row, int col){
	if(word.length() > data.length || word.length() > data[0].length){
	    return false;
	}
	for(int i = 0; i < word.length(); i++){
	    if(data[row+i][col+i] != ' ' && word.charAt(i) != data[row+i][col+i]){
		return false;
	    }
	}
	for(int i = 0; i < word.length(); i++){
	    data[row+i][col+i] = word.charAt(i);
	}
	return true;
    }
    

}
