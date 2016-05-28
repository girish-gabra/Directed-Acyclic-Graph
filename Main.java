package dag;

public class Main {

	public static void main(String[] args)
	{
		DirectedAcyclicGraph dag = new DirectedAcyclicGraph();
		
		System.out.println(dag.addEdge("A", "A"));
		System.out.println(dag.addEdge("A", "C"));
		System.out.println(dag.addEdge("C", "D"));
		System.out.println(dag.addEdge("C", "E"));
		System.out.println(dag.addEdge("D", "G"));
		System.out.println(dag.addEdge("D", "E"));
		System.out.println(dag.addEdge("E", "A"));
		
		
	}
	
}
