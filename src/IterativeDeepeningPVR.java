
public class IterativeDeepeningPVR extends Scout {
		
	public IterativeDeepeningPVR(int b, int d, int v, int i, int s, boolean isRoot) {
		super(b, d, v, i, s, isRoot);
	}

	public String principalVariationString(Node n, int depth, boolean isRoot ){
		
		StringBuffer st = new StringBuffer();
		int alpha =-2147483648;
		int beta = 2147483647; 
		
		if(isRoot){
			st.append("Parent, ");
		}
		if (depth > 0){
			int tempValue = n.ordered_children.get(0).estimated_score;
			int index = 0;
			for(int i = 1; i < n.ordered_children.size(); i++){
				if(n.ordered_children.get(i).estimated_score < tempValue){
					index = i;
					tempValue = n.ordered_children.get(i).estimated_score;
				}
			}
			st.append("Index: " + index + " nega: "+ computeNegamax(n, depth, alpha, beta, false) +", ");
			st.append(principalVariationString(n.ordered_children.get(index), depth - 1, false));
		}
		return st.toString();

	}
  
}
