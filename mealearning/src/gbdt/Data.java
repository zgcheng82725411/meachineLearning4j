package gbdt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Data {
	private ArrayList<ArrayList<String>> trainData=new ArrayList<ArrayList<String>>();
	public ArrayList<ArrayList<String>> getTrainData() {
		return this.trainData;
	}
 
	public Data() {
		String dataPath="resource//LinearSample.txt";
		Scanner in;
		try {
			in = new Scanner(new File(dataPath));
			while (in.hasNext()) {
				String line=in.nextLine();
				String []strs=line.trim().split(",");
				ArrayList<String> tmp=new ArrayList<>();
				for(int i=0;i<strs.length;i++)
				{
					tmp.add(strs[i]);	
				}
				this.trainData.add(tmp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 	
}
