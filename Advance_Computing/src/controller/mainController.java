package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import logic.countmatch;

@Controller
public class mainController {
	
	public mainController() {
		// TODO Auto-generated constructor stub
		System.out.println("into cons");
	}

	@RequestMapping(value="/mainpage",method=RequestMethod.GET)
	public ModelAndView pagetrasfer(@RequestParam("iname") String pname) throws IOException{
		String kname=pname;
		String[] countarray=kname.split(" ");
		for(int i=0;i<countarray.length;i++){
			
			if(countarray[i].contains("frequency")){
				 ModelAndView modelAndView = new ModelAndView("frequency");
				 countmatch c1= new countmatch();
					String cname=countarray[0].toString();
					
					
					HashMap<String,Integer> hashMap= new HashMap<String,Integer>();
					int counter = 0;
					ArrayList<String> arrayList = new ArrayList<String>();
					File folder = new File("C:\\Users\\Krunal\\Krunal\\computing\\src\\textfile\\");
					File[] listOfFiles = folder.listFiles();
					
					 for (int i1 = 0; i1 < listOfFiles.length; i1++) {
					      if (listOfFiles[i1].isFile()) {
					    	  arrayList.add("C:\\Users\\Krunal\\Krunal\\computing\\src\\textfile\\"+listOfFiles[i1].getName());
					       // System.out.println( listOfFiles[i].getName());
					      } 
					      }
					 for(int i1=0;i1<arrayList.size();i1++){
						 org.jsoup.nodes.Document doc1 = Jsoup.parse(new File(arrayList.get(i1)), "UTF-8", "www.w3sfjj.com");
						 String text = doc1.text();
						 String[] matchingword=text.split(" ");
						 Arrays.sort(matchingword);
						 for(int j=0;j<matchingword.length;j++){
							 if(matchingword[j].equals(cname)){
								 counter++;
							 }
						 }
						 //System.out.println(listOfFiles[i].getName()+"file contain**********"+counter+"**********words");
						 hashMap.put(listOfFiles[i1].getName(),counter);
						 
						 matchingword=null;
						 counter=0;
					 }

					 /*System.out.println("size"+hashMap.size());
					 System.out.println("Before Sorting:");
			         Set set = hashMap.entrySet();
			         Iterator iterator = set.iterator();
			         while(iterator.hasNext()) {
			               Map.Entry me = (Map.Entry)iterator.next();
			               System.out.print(me.getKey() + ": ");
			               System.out.println(me.getValue());
			         }*/
			         
					 System.out.println("Searched results:");
			         Map<Integer, String> map = sortByValues(hashMap); 
			         Set set2 = map.entrySet();
			         Iterator iterator2 = set2.iterator();
			         List lskey = new ArrayList<>();
			         List lsvalue = new ArrayList<>();
			         while(iterator2.hasNext()) {
			              Map.Entry me2 = (Map.Entry)iterator2.next();
			              if(!me2.getValue().equals(0)){
			            	 // System.out.print(me2.getKey() + ": ");
			            	  lskey.add(me2.getKey());
			            	  //modelAndView.addObject("key",me2.getKey());
			            	  //System.out.println(me2.getValue()+"  times occured");
			            	  lskey.add(me2.getValue());
			            	 // modelAndView.addObject("value",me2.getValue());
			            
			              }
			         }
			         modelAndView.addObject("key",lskey);
			         modelAndView.addObject("value",lsvalue);
					
				 return modelAndView;
				
			}
			
			else if(countarray[i].contains("editdistance")){
				ModelAndView modelAndView = new ModelAndView("editdistance");
				HashMap<String,Integer> hashMap= new HashMap<String,Integer>();
				String[] matchingword;
				countmatch c1= new countmatch();
				String name=countarray[0].toString();
				System.out.println(name);
				
				ArrayList<String> arrayList = new ArrayList<String>();
				File folder = new File("C:\\Users\\Krunal\\Krunal\\computing\\src\\textfile\\");
				File[] listOfFiles = folder.listFiles();
				
				 for (int k = 0; k < listOfFiles.length; k++) {
				      if (listOfFiles[k].isFile()) {
				    	  arrayList.add("C:\\Users\\Krunal\\Krunal\\computing\\src\\textfile\\"+listOfFiles[k].getName());
				       // System.out.println( listOfFiles[i].getName());
				      } 
				      }
				 for(int j=0;j<arrayList.size();j++){
					 org.jsoup.nodes.Document doc1 = Jsoup.parse(new File(arrayList.get(i)), "UTF-8", "www.w3sfjj.com");
					 String text = doc1.text();
					 matchingword=text.split(" ");
					 for(int l=0;l<matchingword.length;l++){
						 int a=c1.minDistance(name, matchingword[l]);
						 hashMap.put(matchingword[l],a);
					 }
			
					 
				 }
		         Map<Integer, String> map = sortByValues(hashMap);
		         Set set2 = map.entrySet();
		         Iterator iterator2 = set2.iterator();
		         String[] words= new String[5];
		         int kp=0;
		         System.out.println("====================================");
		         System.out.println("List of related words of given word");
		         System.out.println("====================================");
		         while(iterator2.hasNext() && kp<5) {
		        	 Map.Entry me2 = (Map.Entry)iterator2.next();
		        	 //me2.getKey();
		        	 if(kp<5){
		        		 
		        		 //System.out.println(me2.getKey());
		        		 kp++;
		        	 }
		        	 else{
		        		 
		        	 }
		         }
		         
		         return modelAndView;
			}
			
			
		}
		return null;
		
	}
	
	@RequestMapping(value="/backpage",method=RequestMethod.GET)
	public ModelAndView page(){
		ModelAndView andView = new ModelAndView("index");
		return andView;
	}
	private static HashMap sortByValues(HashMap map) {
		List list = new LinkedList(map.entrySet());
	       // Defined Custom Comparator here
	       Collections.sort(list, new Comparator() {
	            public int compare(Object o1, Object o2) {
	               return ((Comparable) ((Map.Entry) (o1)).getValue())
	                  .compareTo(((Map.Entry) (o2)).getValue());
	            }
	       });
	       
	       Collections.reverse(list);
	       // Here I am copying the sorted list in HashMap
	       // using LinkedHashMap to preserve the insertion order
	       HashMap sortedHashMap = new LinkedHashMap();
	       for (Iterator it = list.iterator(); it.hasNext();) {
	              Map.Entry entry = (Map.Entry) it.next();
	              sortedHashMap.put(entry.getKey(), entry.getValue());
	       } 
	       System.out.println();
	       return sortedHashMap;	}
	
	
}
