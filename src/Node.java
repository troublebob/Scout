import java.util.ArrayList;


public class Node {

	int estimated_score;
	ArrayList<Node> ordered_children;
	
	public Node(int b, int d, int v, int i, int s) {
		if (d != 0) {
			for (int x = 0; x < b; x++) {
				ordered_children.add(new Node(b, d - 1, v, i, s));
			}
		}
	}

	public int getEstimated_score() {
		return estimated_score;
	}

	public void setEstimated_score(int estimated_score) {
		this.estimated_score = estimated_score;
	}

	public ArrayList<Node> getOrdered_children() {
		return ordered_children;
	}

	public void setOrdered_children(ArrayList<Node> ordered_children) {
		this.ordered_children = ordered_children;
	}
	
	public String toString(){
		StringBuffer st = new StringBuffer();
		st.append(estimated_score);
		st.append('\t');
		
		for (int i = 0; i < ordered_children.size(); i++) {
			st.append('-');
			st.append(ordered_children.get(i).toString());
		}
	
		return st.toString();
		
	}
}
