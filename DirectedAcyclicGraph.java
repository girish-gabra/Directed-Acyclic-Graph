package dag;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;


public class DirectedAcyclicGraph {

	Set<String> nodes;
	Map<String, List<String>> neighbourMap;
	
	DirectedAcyclicGraph(){
		nodes = new HashSet<String>();
		neighbourMap = new HashMap<String,List<String>>();
	}
	
	private void addNode(String node){
		nodes.add(node);
	}
	
	public boolean addEdge(String source, String destination)
	{
		List<String> neighbours;
		
		if(!nodes.contains(source)){
			addNode(source);
		}
		
		if(!nodes.contains(destination)){
			addNode(destination);
		}
		
		if(!neighbourMap.containsKey(source)){
			neighbours = new ArrayList<String>();
		}else{
			neighbours = neighbourMap.get(source);			
		}
		neighbours.add(destination);
		neighbourMap.put(source, neighbours);
		
		/*check if added edge causes graph to be cyclic. If so, return false and remove
		  the added edge */
		if(hasCycle()){
			List<String> temp = neighbourMap.get(source);
			temp.remove(destination);
			return false;
			
		}
		
		return true;
	}
	
	private boolean hasCycle()
	{
		Set<String> whiteset = new HashSet<String>();	// set of vertices initially having all nodes
		Set<String> blackset = new HashSet<String>();	// set of vertices which has been completely explored
		Set<String> greyset = new HashSet<String>();	// set of vertices which is currently exploring	
		
		for( String node : nodes){
			whiteset.add(node);
		}
		
		for(int i=0; i<whiteset.size();i++)
		{
			String currentNode = whiteset.iterator().next();
			if(dfs(currentNode,whiteset,blackset,greyset)){
				return true;
			}
		}
		
		return false;
	}
	
	private boolean dfs(String currentNode, Set<String> whiteset, Set<String> blackset, Set<String> greyset)
	{
		shiftVertex(currentNode,whiteset, greyset);
		
		
		if(neighbourMap.containsKey(currentNode)){
			List<String> neighbours = neighbourMap.get(currentNode);
			for(String node:neighbours)
			{
				if (blackset.contains(node)) {
	                continue;
	            }
	            //if in gray set then cycle found.
	            if (greyset.contains(node)) {
	                return true;
	            }
	            if(dfs(node, whiteset, blackset, greyset)) {
	                return true;
	            }
				
				
			}
	
		}
		
		shiftVertex(currentNode,greyset,blackset);
		return false;
		
	}
	
	private void shiftVertex(String currentNode, Set<String> oldset, Set<String> newset)
	{
		oldset.remove(currentNode);
		newset.add(currentNode);
	}
	
}
