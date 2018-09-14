import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;


public class Sequence {
	//create array to put the values of the input.txt
	static ArrayList<Integer> list = new ArrayList<Integer>();
	//keep track of the highest cycle count
	static int count;
	//keeps the value of the current cycle count
	static int bigger;
	
	//constructs sequence
	public Sequence(int count,int prevcount) {
		this.count=count;
		this.bigger=bigger;
	}
	
	
    public static void main (String[] args) throws IOException {
      
    	//create new sequence with current cycle 0 and biggest cycle 0
        Sequence Counts=new Sequence(0,0);
     
        //open up the input file
        Scanner input = new Scanner (new File("input.txt"));
       
        //create a output file to write to
        Writer out = new FileWriter("output.txt");

        //while file is not finished
        while(input.hasNext()) {
        	//add the integers to the sequence list
        	list.add(input.nextInt());
        }
        
        //prints the completed list
        System.out.println(list);
        //System.out.println(list.size());   
        Counts.bigger=0;
        
       //for loop that iterates through the list in pairs, index {0,1},{2,3}..etc
        for(int i=0;i<list.size()-1;i+=2) {
        	int start=list.get(i);
            int end= list.get(i+1);
        	
        	System.out.print("This is the start: ");
    		System.out.println(start);
    		System.out.print("This is the end: ");
    		System.out.println(end);
    		//second loop that will increase the value of the {x,y} x value
        	for(int j=start;j<end;j++) {
        	
        		//reset cycle count to zero.
        		Counts.count=0;
        		//call algorithm function
        		algo(j,Counts);
        		//if the new cycle count is bigger then previous, set biggest cycle count equal to current
        		if(Counts.count>Counts.bigger) {
        			Counts.bigger=Counts.count;
        		}
        		

        	}
        	System.out.print("Highest Sequence is: ");
        	System.out.println(Counts.bigger);
			
        	//write to the file
        	out.write(start+" ");
        	out.write(end+" ");
        	
        	out.write(Counts.bigger+ "\n");
        	Sequence.bigger=0;
			Counts.bigger=0;
        	
        	
        }
        out.close();
        
    


    }
    
    public static int algo(int curr, Sequence Counts) {
    ///curr is 1
    //end is 10
    	if(curr!=1) {
	        
    		if(curr%2==0) {

    			ifEven(curr, Counts);
    		}
    		else if(curr%2!=0) {

    			ifOdd(curr,Counts);
    		}

    	}
    	
    	else if(curr==1){
    		System.out.print("This is count of current ");
        	
        	Counts.count++;
        	System.out.println(Counts.count);;
            
        	Counts.count=count;

            return Counts.count;
    	}
    	
    	
    	
    	return Counts.count;
		
    	
		
    	
    }
    
    
    public static int ifEven(int curr ,Sequence Counts){
    
    	curr=curr/2;
    	
    	Counts.count++;
        return algo(curr, Counts);
    
    }
    
    public static int ifOdd(int curr, Sequence Counts) {
    	curr=(curr*3)+1;
    	Counts.count++;
        return algo(curr, Counts);


    }
    
}