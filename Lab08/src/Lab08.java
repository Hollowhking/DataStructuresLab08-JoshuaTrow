public class Lab08 {
    public static void main(String[] args) {
        //String board = "xxox xo o";
    	String board = "x ox xo o";
    	//String board = "         ";
        TicTacToeTreeNode root = TicTacToeTree.createNode(board, "x");
        System.out.print(TicTacToeTree.treeToString(root));
    }
}
