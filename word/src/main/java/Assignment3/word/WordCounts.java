package Assignment3.word;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class WordCounts {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File ("C:\\Users\\Jahan\\eclipse-workspace\\DataStructures\\src\\assignment3\\Song.txt");// connects to file
		  Scanner sc = new Scanner(file);
		  String[] WordArray = new String[516];
		  int i = 0;
		  while (sc.hasNext()) { 
			  WordArray[i] = sc.next();
			  WordArray[i] = WordArray[i].toLowerCase(); // array for every word in the song
			  i++;
		  }
		  
		  String[] UniqueArray = new String[1000];// make array for unique words
		  int j = 0;
		  int k = 0;
		  String hold;
		  while (j < 516) {
			  hold = WordArray[j];
			  if (IsUnique(UniqueArray,hold)) { // gets the unique words
				  UniqueArray[k] = WordArray[j];
				  k++;
			  }
			  j++;
		  }
		  
		  int CounterArray[] = new int [200];// counts how many times the word appears in the son array
		  int counter = 0;
		  for (int l = 0; l < k; l++) {	// algorithm to check the words
			  
			  for (int s = 0; s < WordArray.length-1; s++) {
				  if (UniqueArray[l].equals(WordArray[s]) ) {
					  counter ++;
				  }
				  
			  }
			  CounterArray[l] = counter;
			  System.out.print(CounterArray[l] + ": ");
			  System.out.println(UniqueArray[l]);
			  counter = 0;
		  }
	
		  sc.close();

	}
	
	public static boolean IsUnique(String [] Arr, String Test) { // checks if the word is unique
		boolean True = true;
		int i = 0;
		while (Arr[i] != null && True != false) {
			if (Arr[i].equals(Test)) {
				True = false;
			}
			i++;
		}
		
		return True;
	}

}
