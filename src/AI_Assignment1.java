
public class AI_Assignment1 {

	public static void main(String[] args) {
		
		int b = 2, d = 3, v = 10 ,  i = 5,  s = 5;
		
		Node n = new Node(b, d, v, i, s, true);
		System.out.println(n.toString(d));
		
		NegamaxNode nm = new NegamaxNode(b, d, v, i, s, true);
		System.out.println(nm.computeNegamax(n, 3, -1000, 1000,true));

	}

}
