public class TicTacToeTree {

    // YOUR CODE GOES HERE
    
    public static String makeMove(String oldBoard, int position, String player) {
        return oldBoard.substring(0, position) + player + oldBoard.substring(position + 1);
    }

	public static TicTacToeTreeNode createNode(String board, String player) {
		//PSEUDO: 
		//1. find number of blank spaces on board
		//2. create index of where each blank is 
		//3. create a different board for each index point replacing said index point blank with the player string
		//4. end recursion when there are no blanks left on board  
		
		
		//TicTacToeTreeNode child = new TicTacToeTreeNode();
		String nextPlayer,newboard=board;
		
		int blankcount=0,boardcount=0,indexcounter=0;

		//workspace---------------------
		char[] chars = board.toCharArray();
		for (char i: chars) {
			if (i == ' ') {
				blankcount++;
			}
		}
		int[] index = new int[blankcount];
		for (int i=0;i<board.length();i++) {
			if (board.charAt(i) == ' ') {
				index[indexcounter]=i;
				indexcounter++;
				//System.out.println(i);
			}
		}
		String[] boards = new String[blankcount];
		for (int i=0; i<blankcount;i++) {
			boards[i] = board.substring(0,index[i])+player+board.substring(index[i]+1);
			for (int j=0;j<(board.length()-blankcount);j++) {
				System.out.print(" ");
			}
			System.out.print(boards[i]);
			System.out.println("");
		}
		if (player == "x") {
			nextPlayer = "o";
		}
		else {
			nextPlayer = "x";
		}
		for (int i=0; i<blankcount;i++) {
			createNode(boards[i],nextPlayer);
		}
		//System.out.println(blankcount);
		
		return null;
		
		//-----------------------
		//return createNode(newboard,nextPlayer);
		
		//return child;
	}
	public static String nodeToString(TicTacToeTreeNode node, int indent) {
		return null;
	}

	public static String treeToString(TicTacToeTreeNode root) {
		return null;
	}
}