/*
Harsh Agrawal
CS 570 B
CWID : 10475285
Fall 2021
*/

package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class Anagrams {
	
	final Integer[] primes={2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
	 
	 Map<Character,Integer> letterTable;
	 Map<Long,ArrayList<String>> anagramTable;
	public Anagrams() {
		buildLetterTable();
		anagramTable = new HashMap<Long,ArrayList<String>>();
		
	}
	
	private void processFile(String s) throws IOException {
		
		 
		FileInputStream fStream = new FileInputStream(s);
		BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
        String strLine;
        int i = 0;
        for(i = 0; (strLine = br.readLine()) != null ; i++){
			this.addWord(strLine);
		}
		br.close();
	}
	
	private void buildLetterTable() {
	    letterTable= new HashMap<Character,Integer>();
	    Character[] alphabets= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	   
	    for(int i = 0; i < 26; i++) {
			letterTable.put(alphabets[i], primes[i]);
		}
	
	} 
	
	private Long myHashCode(String s) {
		long mainKey=1;
		int j = 0;
		while(j < s.length()){
			mainKey= mainKey*(long)letterTable.get(s.charAt(j));
		j++;
		}
		return mainKey;
	}


    private ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
		
		ArrayList<Map.Entry<Long,ArrayList<String>>> lists = new ArrayList<>(); 
		int maxval = 0;
	    
		for (Map.Entry<Long,ArrayList<String>> entry : anagramTable.entrySet()) {
			
		  if(!(entry.getValue().size() <= maxval)) {
				lists.clear();
				lists.add(entry);
				maxval = entry.getValue().size();
			} 
		  else if(!(entry.getValue().size() != maxval)) {
				lists.add(entry);
			}
		}
		 return lists;
	}
    
    private void addWord(String s) {	
		
		 Long myhash = this.myHashCode(s);
		 if(!(anagramTable.get(myhash) != null)) {
			 ArrayList<String> a1 = new ArrayList<String>();
			 a1.add(s);
			 anagramTable.put(myhash, a1);
		} 
		else {
			anagramTable.get(myhash).add(s);
		}
	}
	
    
	public static void main(String[] args) {
		Anagrams a = new Anagrams();
		final long startTime = System.nanoTime();
		
		try {
			a.processFile ("words_alpha.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		ArrayList<Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries ();
		int analength = maxEntries.get(0).getValue().size();
		long mykey = maxEntries.get(0).getKey();
		final long estimatedTime = System.nanoTime() - startTime ;
		final double seconds = ((double)estimatedTime/1000000000);
		System.out.println("Elapsed  Time : " + seconds);
		System.out.println("Key of max anagrams : " + mykey);
		System.out.println("List of max anagrams : " + maxEntries.get(0).getValue());
		System.out.println("Length of max anagrams : " + analength);

	}

}
