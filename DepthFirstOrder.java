package Digraph;
import java.util.Queue ;
import java.util.LinkedList ;
import java.util.Deque ;
/**
 *
 * @author mostafa
 */
public class DepthFirstOrder 
{
    private boolean marked [];
    private Queue<Integer> pre ;
    private Queue<Integer> post ;
    private Deque<Integer> reversePost ;
    
    public DepthFirstOrder(Digraph G)
    {
        pre         = new LinkedList<>();
        post        = new LinkedList<>();
        reversePost = new LinkedList<>();
        marked = new boolean [G.V()];
        for (int i = 0; i < G.V() ; i++)
            if(!marked[i]) dfs(G, i);
    }
    
    public void dfs(Digraph G , int v)
    {
        System.out.println("v = " + v);
        pre.add(v);
        marked[v] = true ;
        for(int w : G.adj(v))
            if(!marked[w])  dfs(G, w);
        post.add(v);
        reversePost.push(v);
    }
    
    public Iterable<Integer> pre()
    {   return pre ;      }
    
    public Iterable<Integer> post()
    {   return post ;     }
    
    public Iterable<Integer> reversePost()
    {   return reversePost ;     }
    
}
