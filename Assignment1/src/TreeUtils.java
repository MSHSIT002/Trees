import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Utility procedures for binary tree structures.
 * 
 * @version 25/2/2015
 */
public class TreeUtils {
        
    /**
     * Determine whether one tree node structure is similar (has the same structure) as another.
     */
    public static boolean similar(BinaryTreeNode treeStructOne, BinaryTreeNode treeStructTwo) {
    	
		
    	if(treeStructOne == null && treeStructTwo == null){ return true ;}
    	
    	else if((treeStructOne == null && treeStructTwo != null) || (treeStructOne == null && treeStructTwo != null) ){ return false;}
    	
    	else if(treeStructOne.hasLeft() == treeStructTwo.hasLeft() && treeStructOne.hasRight() == treeStructTwo.hasRight()){
    		
    		return similar(treeStructOne.getLeft(),treeStructTwo.getLeft()) && similar(treeStructOne.getRight(),treeStructTwo.getRight());}
    	
    	else
    		return false;
    	
    	
    	
    	
		
    }
    
    /**
     * Obtain a list containing the root node of the given structure i.e. tNode itself.
     */
    public static List<BinaryTreeNode> levelZero(BinaryTreeNode tNode) {
    	
      List<BinaryTreeNode> ZerothLevel = new ArrayList<BinaryTreeNode>();
      ZerothLevel.add(tNode);
		return ZerothLevel;
    }
    
    
    /**
     * Given a list of nodes, obtain the next level. 
     * 
     * <p>
     * If the tree structure is incomplete, <code>BinaryTreeNode.EMPTY_NODE</code> is inserted as a place holder for each
     * missing node.
     * </p>
     */
    public static List<BinaryTreeNode> nextLevel(List<BinaryTreeNode> level) {    
		List<BinaryTreeNode> Levels = new ArrayList<BinaryTreeNode>();
		
		
		 for (BinaryTreeNode node: level)
	      {

	         if (node != null)
	         {
	            if (node.hasLeft())
	               Levels.add(node.getLeft());
	            else
	               Levels.add(BinaryTreeNode.EMPTY_NODE);
	            if (node.hasRight())
	               Levels.add(node.getRight());
	            else
	               Levels.add(BinaryTreeNode.EMPTY_NODE);
	         }  
	      }
	      return Levels;  
    }
    
    
    /**
     * public static List<BinaryNodeTree> nextLevel(List<BinaryTreeNode> level{
     * 	List<BinaryTreeNode> Levels = new ArrayList<BinaryTreeNode>();
     * 	
     * 
     *		for( int i = 0 ; i < Levels.size() ; i++){
     *				
     *				if(Levels.get(i) != null){
     *								
     *						if(Levels.get(i).hasLeft()){Levels.add(Levels.get(i).getLeft())}else{Levels.add(BinaryTreeNode.EMPTY_NODE)}
     *						if(Levels.get(i).hasRight()){Levels.add(Levels.get(i).getRight())}else{Levels.add(BinaryTreeNode.EMPTY_NODE)}
     *						}
     *						return Levels ;
     *				}
   
     * 
     * */
    
    
    
    /**
     * Determine whether node is a place holder i.e. <code>node==BinaryTreeNode.EMPTY_NODE</code>
     */
    public static boolean isPlaceHolder(BinaryTreeNode node) {
		return (node.getItem() == null);
		
    }
    
}
