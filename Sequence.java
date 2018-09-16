import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Sequence {
	//create array to put the values of the input.txt
	static ArrayList<Integer> list = new ArrayList<Integer>();
	//keep track of the highest cycle count
	static int count;
	//keeps the value of the current cycle count
	static int bigger;
	
	//constructs sequence
	public Sequence(int count,int prevcount) {
		Sequence.count=count;
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
        Sequence.bigger=0;
        
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
        		Sequence.count=0;
        		//call algorithm function
        		algo(j,Counts);
        		//if the new cycle count is bigger then previous, set biggest cycle count equal to current
        		if(Sequence.count>Sequence.bigger) {
        			Sequence.bigger=Sequence.count;
        		}  		
        	}
        	System.out.print("Highest Sequence is: ");
        	System.out.println(Sequence.bigger);		
        	//write to the file
        	out.write(start+" ");
        	out.write(end+" ");
        	
        	out.write(Sequence.bigger+ "\n");
        	Sequence.bigger=0;
			Sequence.bigger=0;       	
        }
        input.close();
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
        	
        	Sequence.count++;
        	System.out.println(Sequence.count);;
            
            return Sequence.count;
    	}
    	return Sequence.count;
    }
    public static int ifEven(int curr ,Sequence Counts){   
    	curr=curr/2; 	
    	Sequence.count++;
        return algo(curr, Counts); 
    }
    public static int ifOdd(int curr, Sequence Counts) {
    	curr=(curr*3)+1;
    	Sequence.count++;
        return algo(curr, Counts);
    }
    
}
