import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class MegaSort{
	public static void main( String [] args){
		BufferedReader reader;
		int lineCount = 0;
		try{
			reader = new BufferedReader(new FileReader("1m-ints.txt"));
			while (reader.readLine() != null) lineCount++;
			reader.close();
		}
		catch(IOException e){
			System.out.println("Error reading file!");
			e.printStackTrace();
		}
		int[] arr = new int[lineCount];
		int max = 0;

		try{
			reader = new BufferedReader(new FileReader("1m-ints.txt"));
			String line = reader.readLine();
			int count = 0;
			while (line != null){
				arr[count] = Integer.parseInt(line);	//Stores current line in array
				if (arr[count] > max)					//Checks max
					max = arr[count];
				line = reader.readLine();				//Goes to new line
				count++;		
			}
			reader.close();
		}
		catch(IOException e){
			System.out.println("Error reading file!");
			e.printStackTrace();
		}
		int[] temp = new int[max+1];					//Create a temp size of max +1
		for(int i = 0, end = arr.length; i < end; i++)	// For every number existing, increase temps index by one count
			temp[arr[i]]++;
		Arrays.fill(arr,0);								//Clear the array
		boolean next = false;	
		for(int i = 0, index = 0, end = arr.length ; i< end; i++){ //Copy temp into array
			next = false;										//Keep on going until hitting a non-zero temp
			while (!next){
				if (temp[index] == 0 )
					index++;
				else{											//If hit non-zero, minus it by one and put the temp as the indexed number in aray.
					temp[index]--;
					arr[i] = index;
					next = true;
				}
			}
		}
		for(int i = 0, end = arr.length; i < end; i++){
			System.out.println(arr[i]);
		}
	}
}