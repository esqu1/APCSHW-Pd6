import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class WordGrid{
    private char[][] data;
    private ArrayList<String> availables = new ArrayList<String>();

    /**Initialize the grid to the size specified and fill all of the positions
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

    /**Returns an ArrayList of the available words.
     *@return an ArrayList containing the words in the puzzle.
     */
    public ArrayList<String> getAvailables(){
	return availables;
    }
    

    /**Attempts to randomly add the available words to the Word Search puzzle.
     *
     */
    public void randomAdd(ArrayList<String> listOfWords){
	Random r = new Random();
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
	fillRest();
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
	if(Math.abs(dirx) > 1 || Math.abs(diry) > 1){
	    return false;
	}
	if(dirx == 0 && diry == 0){
	    return false;
	}
	if((Math.abs(dirx) == 1 && word.length() > data[0].length) || (Math.abs(diry) == 1 && word.length() > data.length)){
	    return false;
	}
	for(int i = 0; i < word.length(); i++){
	    if((row+i*diry < 0 || row+i*diry >= data.length || col+i*dirx < 0 || col+i*dirx >= data[0].length) || data[row+i*diry][col+i*dirx] != ' ' && word.charAt(i) != data[row+i*diry][col+i*dirx]){
		return false;
	    }
	}
	for(int i = 0; i < word.length(); i++){
	    data[row+i*diry][col+i*dirx] = word.charAt(i);
	}
	return true;      
    }

    public void fillRest(){
	Random r = new Random();
	for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[0].length; j++){
		if(data[i][j] == ' '){
		    data[i][j] = (char)('a' + r.nextInt(26));
		}
	    }
	}
    }

    

}
