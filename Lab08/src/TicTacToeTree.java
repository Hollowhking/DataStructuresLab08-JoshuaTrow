public class TicTacToeTree {

    // YOUR CODE GOES HERE
    
    public static String makeMove(String oldBoard, int position, String player) {
        return oldBoard.substring(0, position) + player + oldBoard.substring(position + 1);
    }

    public static int blankcount(String string) {
    	int blankcount=0;
		char[] chars = string.toCharArray();
		for (char i: chars) {
			if (i == ' ') {
				blankcount++;
			}
		}
		return blankcount;
    }
	public static TicTacToeTreeNode createNode(String board, String player) {
		//PSEUDO: 
		//1. find number of blank spaces on board
		//2. create index of where each blank is 
		//3. create a different board for each index point replacing said index point blank with the player string
		//4. end recursion when there are no blanks left on board  
		TicTacToeTreeNode child = new TicTacToeTreeNode();
		TicTacToeTreeNode childnode = new TicTacToeTreeNode();
		child.board = board;
		String nextPlayer;
		int blankcount=0,indexcounter=0;
		//workspace---------------------
		blankcount = blankcount(board);
		int[] index = new int[blankcount];
		for (int i=0;i<board.length();i++) {
			if (board.charAt(i) == ' ') {
				index[indexcounter]=i;
				indexcounter++;
			}
		}
		if (player == "x") {
			nextPlayer = "o";
		}
		else {
			nextPlayer = "x";
		}
		for (int i=0; i<blankcount;i++) {
			childnode = createNode(makeMove(board,index[i],player),nextPlayer);
			child.children.add(childnode);
			
		}
		return child;
	}
	public static String nodeToString(TicTacToeTreeNode node, int indent) {
        String result = "";
        if (indent == 0) {
        	result += "'" + node.board + "'\n";
        }
        for (int i=0; i<node.children.size();i++) {
            // add the indentation
        	for (int j=0; j<(node.children.get(i).board.length()-(blankcount(node.children.get(i).board)*2));j++) {
        		result += " ";
        	}
            //add the current node
        	//result += node.board;
            result += "'"+node.children.get(i).board+"'\n";
            // add all of the children, recursively
            result += nodeToString(node.children.get(i), indent + 1);
        }
        return result;
	}

	public static String treeToString(TicTacToeTreeNode root) {
		return nodeToString(root, 0);
	}
}
