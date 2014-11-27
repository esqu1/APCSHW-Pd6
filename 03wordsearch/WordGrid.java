import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class WordGrid{
    private char[][] data;
    private ArrayList<String> availables = new ArrayList<String>();
    private Random r = new Random();

    /**Initialize the grid to the size specified and fill all of the positions
     *with spaces. If an invalid input is given, the grid will initialize
     *to a 10x10 grid.
     *@param row is the starting height of the WordGrid
     *@param col is the starting width of the WordGrid
     */
    public WordGrid(int rows, int cols, long seed){
	if(rows > 1 && cols > 1){
	    data = new char[rows][cols];
	}else{
	    data = new char[10][10];
	}
	if(seed != 0){	
	    setSeed(seed);
	}
	clear();
    }

    /**Sets the seed of the Random object of the word search puzzle.
     *Allows for the same puzzle to be generated multiple times.
     */
    public void setSeed(long seed){
	r.setSeed(seed);
    }

    /**Resets all values in the WordGrid to spaces ' '*/
    private void clear(){
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
		data[i][j] = '_';
	    }
	}
    }

    /**Returns an ArrayList of the available words.
     *@return an ArrayList containing the words in the puzzle.
     */
    public ArrayList<String> getAvailables(){
	return availables;
    }

    public void loadWordsFromFile(String filename, boolean fillRandomLetters){
	Scanner s;
	File F = new File("words.txt");
	try{
	    s = new Scanner(F);
	}catch(FileNotFoundException e){
	    s = new Scanner(System.in);
	}
	ArrayList<String> str = new ArrayList<String>();
	while(s.hasNext()){
	    str.add(s.next());
	}
	randomAdd(str);
	if(fillRandomLetters){
	    fillRest();
	}
	    
    }

    public String wordsInPuzzle(){
	String s = "";
	for(int i = 0; i < getAvailables().size(); i++){
	    s += getAvailables().get(i) + " ";
	    if(i % 3 == 2){
		s += "\n";
	    }
	}
	return s;
	
    }

    /**Attempts to randomly add the available words to the Word Search puzzle.
     *
     */
    public void randomAdd(ArrayList<String> listOfWords){
	for(int i = 0; i < listOfWords.size(); i++){
	    for(int j = 0; j < 3; j++){
		if(addWord(listOfWords.get(i),
			   r.nextInt(data.length),
			   r.nextInt(data[0].length),
			   r.nextInt(3) - 1,
			   r.nextInt(3) - 1)){
		    availables.add(listOfWords.get(i));
		    break;
		}
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
	if(checkWord(word,row,col,dirx,diry)){
	    for(int i = 0; i < word.length(); i++){
		data[row+i*diry][col+i*dirx] = word.charAt(i);
	    }
	    return true;
	}
	return false;
    }

    /**Checks to see if a word can be added to the puzzle.
     *@param word is any text to be added to the word grid.
     *@param row is the vertical location of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@param dirx ranges from -1 to 1, specifies the direction of the word in the horizontal direction.
     *@param diry ranges from -1 to 1, specifries the direciton of the word in the horizontal direction.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letter that do not match, then false is returned.
     */
    public boolean checkWord(String word, int row, int col, int dirx, int diry){
	if(Math.abs(dirx) > 1 || Math.abs(diry) > 1 || (dirx == 0 && diry == 0) || (Math.abs(dirx) == 1 && word.length() > data[0].length) || (Math.abs(diry) == 1 && word.length() > data.length)){
	    return false;
	}
	for(int i = 0; i < word.length(); i++){
	    if((row+i*diry < 0 || row+i*diry >= data.length || col+i*dirx < 0 || col+i*dirx >= data[0].length) || data[row+i*diry][col+i*dirx] != '_' && word.charAt(i) != data[row+i*diry][col+i*dirx]){
		return false;
	    }
	}
	return true;
    }

    /**Fills the remaining empty parts of the puzzle with random characters.
     *
     */
    public void fillRest(){
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[0].length; j++){
		if(data[i][j] == '_'){
		    data[i][j] = (char)('a' + r.nextInt(26));
		}
	    }
	}
    }

    

}
