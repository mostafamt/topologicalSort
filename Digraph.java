package Digraph;
import java.util.ArrayList ;
/**
 *
 * @author mostafa
 */
public class Digraph 
{
    private final int V ;
    private int E ;
    private ArrayList<Integer> [] adjList ;
    
    public Digraph(int V)
    {
        this.V = V ;
        E = 0 ;
        adjList = new ArrayList[V];
        for (int i = 0; i < V ; i++)
            adjList[i] = new ArrayList<Integer>();
    }
    
    public int V() {   return V ;  }
    
    public int E() {   return E ;  }
    
    public void addEdge(int v , int w)
    {
        adjList[v].add(w);
        E++ ;
    }
    
    public Iterable<Integer> adj(int v)
    {   return adjList[v];      }
    
    public Digraph reverse()
    {
        Digraph R = new Digraph(V);
        for (int i = 0; i < V ; i++) 
            for(int w : adj(i))
                R.addEdge(w, i);
        return R ;
    }
    
    @Override
    public String toString()
    {
        String s = V+ " vertices , "+E+" edges\n";
        for (int i = 0; i < V ; i++) 
        {
            s += i + " :";
            for(int w : adj(i))
                s += " " + w;
            s += "\n";
        }
        return s ;
    }
}
