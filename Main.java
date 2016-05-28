package dag;
import java.util.Scanner;
public class Main {

	public static void main(String[] args)
	{
		DirectedAcyclicGraph dag = new DirectedAcyclicGraph();
		
		Scanner s = new Scanner(System.in);
		
		/* Taking input from user through stdin*/
		char ch='Y';
		do
		{
			System.out.println("Enter source and destination");
			String source = s.next();
			String destination = s.next();
			System.out.println(dag.addEdge(source, destination));
			
			System.out.println("Do you want to continue? Y or N");
			 ch = s.next().charAt(0);
		}while(ch=='Y' ||ch=='y');
		s.close();
		
	}
	
}
