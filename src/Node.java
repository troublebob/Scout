import java.util.ArrayList;
import java.util.Random;

public class Node {

	static Random rn = new Random(0);
	
	int estimated_score;
	ArrayList<Node> ordered_children;
	String status = "";
	
	public Node(int b, int d, int v, int i, int s, boolean isRoot) {
		ordered_children = new ArrayList<Node>(); 
		int randomBranch = getRandomNumber(0, b-1);
		
		if (isRoot) {
			setEstimated_score(v + getRandomNumber(-i, +i));
		}
		
		if (d == 0) {
			setEstimated_score(v);
			
		} else {
			setEstimated_score(v + getRandomNumber(-i, +i)); 
			for (int x = 0; x < b; x++) {
				if (x == randomBranch) {
					Node n = new Node(b, d - 1, -v, i, s, false);
					n.status += " S ";
					ordered_children.add(n);
				}else{
					int newS = getRandomNumber(0, s);
					Node n = new Node(b, d - 1, -v + newS , i, s, false);
					n.status = " Z ";
					ordered_children.add(n);
				}
			}
		}
		status += "<" + randomBranch + ">";
	}
	
	public int getEstimated_score() {
		return estimated_score;
	}

	public void setEstimated_score(int estimated_score) {
		this.estimated_score = estimated_score;
	}
	
	public int getRandomNumber(int l, int h){
		return rn.nextInt(Math.abs(l) + Math.abs(h) + 1) - Math.abs(l);
	}


	public String toString(int d){
		StringBuffer st = new StringBuffer();
		for(int i = d; i > 0; i--){
			st.append('\t');
		}
		
		st.append(status+" ");
		st.append("est:");
		st.append(estimated_score);
		st.append('\n');
		for(int i = 0; i <ordered_children.size(); i++){
			st.append(ordered_children.get(i).toString(d-1));
		}

		return st.toString();

	}
}
