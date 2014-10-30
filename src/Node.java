import java.util.ArrayList;
import java.util.Random;

public class Node {

	int estimated_score;
	ArrayList<Node> ordered_children;

	public Node(int b, int d, int v, int i, int s) {
		ordered_children = new ArrayList<Node>(); 
		int randomBranch = getRandomNumber(0,b);
		if (d == 0){
			this.estimated_score = v;
		}else if (d != 0) {
			this.estimated_score= v + getRandomNumber(i*-1,i);
			for (int x = 0; x < b; x++) {
				if (x == randomBranch){
					ordered_children.add(new Node(b, d - 1, v * -1, i, s));
				}else{
					int newS = getRandomNumber(0, s);
					ordered_children.add(new Node(b, d - 1, (v * -1) + newS , i, s));
				}
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

	public int getRandomNumber(int l, int h){
		Random rn = new Random();
		return rn.nextInt(h-l) - 1;
	}


	public String toString(int d){
		StringBuffer st = new StringBuffer();
		for(int i = d; i > 0; i--){
			st.append('\t');
		}
		st.append('*');
		st.append(estimated_score);
		st.append('\n');
		for(int i = 0; i <ordered_children.size(); i++){
			st.append(ordered_children.get(i).toString(d-1));
		}


		return st.toString();

	}
}
