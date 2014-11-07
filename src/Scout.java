
public class Scout extends NegamaxNode {

	public Scout(int b, int d, int v, int i, int s, boolean isRoot) {
		super(b, d, v, i, s, isRoot);
	}

	public int computeScout(Node n, int depth, int alpha,int beta, boolean printing){
		int midpoint = (alpha + beta)/2;
		int newAlpha = midpoint -1;
		int newBeta = midpoint + 1;
		int v = computeNegamax(n, depth, newAlpha, newBeta, printing);
		if(v > newAlpha && v<= midpoint ){
			return midpoint;
		}

		if(v < 0){
			return computeScout(n, depth, alpha, newBeta, printing);
		} else {
		return computeScout(n, depth, newAlpha, beta, printing);
		}
	}
}
