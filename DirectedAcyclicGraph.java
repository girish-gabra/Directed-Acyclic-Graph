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
	
	public void addNode(String node){
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
		

		return true;
	}	
}
