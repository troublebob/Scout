
public class AI_Assignment1 {

	public static void main(String[] args) {

		int b = 4, d = 8, v = 10 ,  i = 5,  s = 5;
		int alpha = -100000, beta = 100000;
		IterativeDeepeningPVR n0 = new IterativeDeepeningPVR(b, d, v, i, s, true);
		IterativeDeepeningPVR n1 = new IterativeDeepeningPVR(b, d, v, i, s, true);
		IterativeDeepeningPVR n2 = new IterativeDeepeningPVR(b, d, v, i, s, true);
		IterativeDeepeningPVR n3 = new IterativeDeepeningPVR(b, d, v, i, s, true);
		IterativeDeepeningPVR n4 = new IterativeDeepeningPVR(b, d, v, i, s, true);
		IterativeDeepeningPVR n5 = new IterativeDeepeningPVR(b, d, v, i, s, true);
		IterativeDeepeningPVR n6 = new IterativeDeepeningPVR(b, d, v, i, s, true);
		IterativeDeepeningPVR n7 = new IterativeDeepeningPVR(b, d, v, i, s, true);
		IterativeDeepeningPVR n8 = new IterativeDeepeningPVR(b, d, v, i, s, true);
		IterativeDeepeningPVR n9 = new IterativeDeepeningPVR(b, d, v, i, s, true);
		
		System.out.println(runTest(0, n0,d,alpha,beta));
		System.out.println(runTest(1, n1,d,alpha,beta));
		System.out.println(runTest(2, n2,d,alpha,beta));
		System.out.println(runTest(3, n3,d,alpha,beta));
		System.out.println(runTest(4, n4,d,alpha,beta));
		System.out.println(runTest(5, n5,d,alpha,beta));
		System.out.println(runTest(6, n6,d,alpha,beta));
		System.out.println(runTest(7, n7,d,alpha,beta));
		System.out.println(runTest(8, n8,d,alpha,beta));
		System.out.println(runTest(9, n9,d,alpha,beta));

	}
	public static String runTest(int testNode, IterativeDeepeningPVR n,int depth, int alpha, int beta){
		StringBuffer st = new StringBuffer();
		n.computeNegamax(n, depth, alpha, beta, false);
		System.out.println("N"+testNode+" AlphaBeta: "+ n.getNumberOfEvals());
		n.resetEvals();
		n.computeScout(n, depth, alpha, beta, false);
		System.out.println("N"+testNode+" Scout: "+ n.getNumberOfEvals());
		System.out.println(n.principalVariationString(n, depth, true));
		return st.toString();
	}

}
