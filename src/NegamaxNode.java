public class NegamaxNode extends Node {

	static int numberOfEvals = 0;
	
	
	public NegamaxNode(int b, int d, int v, int i, int s, boolean isRoot) {
		super(b, d, v, i, s, isRoot);
	}
	public int computeNegamax(Node n, int depth, int alpha,int beta, boolean printing){
		if( depth == 0){
		    numberOfEvals++;
		    if(printing){
		    	System.out.println(printInfo(n, depth, alpha, beta, "Static"));
		    }
			return n.estimated_score;
		}
		int bestValue = -2147483648;
		int val = 0;
		
		for(int i = 0; i< n.ordered_children.size(); i++ ){
		    val = -computeNegamax(n.ordered_children.get(i), depth - 1, -beta, -alpha, printing);
		    bestValue = Math.max( bestValue, val );
		    alpha = Math.max( alpha, val );
		    if( alpha >= beta){
		        break;
		    }
		}
		if(printing){
			System.out.println(printInfo(n, depth, alpha, beta, "Static"));
		}
		return bestValue;
	}
	public String printInfo(Node n,int depth, int alpha, int beta, String method){
		
		return ("Depth="+ depth + " Node:Estimated Score="+ n.estimated_score+" Alpha="+alpha + " Beta=" + beta + 
				" Method="+ method);
	}

}