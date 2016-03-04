
import java.io.PrintStream;
import java.util.List;

public class SimpleTreeWriterImpl implements SimpleTreeWriter {
	
	PrintStream strm ;
	String element;
	
	public SimpleTreeWriterImpl(){
		 strm = null ;
	}
	public SimpleTreeWriterImpl(PrintStream out) {
		this.strm = out;
	}
	@Override
	public void setDestination(PrintStream stream) {
		this.strm = stream ;
		}

	@Override
	public void write(BinaryTreeNode tree) {
		
		
		
	      
		 int height = Height(tree); 
	     int TextSize = TextSize(tree); 
	      
	      List<BinaryTreeNode> currentLevel = TreeUtils.levelZero(tree);// creates a node at the root level
	      int Remaining_items = currentLevel.size(); //kKeeping track of the number of nodes. So that we know when to the print the Dashes in the tree.
	      for (int i = 0; i<height; i++)
	      {
	         int SpaceBtwnNodes = SpaceBtwNode(height, i); //width between tow nodes in a given level
	         
	         int LeftWidth = SpaceAtLNode(SpaceBtwnNodes); //width from the left of line to the left-most node 
	         
	         LeftSpacing(LeftWidth,TextSize );
	     
	         for (BinaryTreeNode node: currentLevel)
	         {
	            Remaining_items = Remaining_items -1; //decrement number of nodes in level
	            
	            if (node == null)
	               NullNode();
	            
	            
	            else if (TreeUtils.isPlaceHolder(node))
	            	PrintPlaceHolder(TextSize);
	
	            else
	            {
	            	element = Integer.toString(node.getItem());
	               if( TextSize!=1 && node.getItem()<10){
	            	   strm.print("0"+node.getItem());
	            	   
	               }else{
	               strm.print(node.getItem().toString());}
	               for (int k=0; k < TextSize - element.length(); k++)
	            	   if(node.getItem()<10){
	                  strm.print(""); //Prints out nothing if the value greater than 10. 
	            	   }else{
	            		   strm.print(" "); //prints out the needed space so that all have the same text size.
	            	   }
	            }
	            if (Remaining_items != 0)
	            	
	               for (int j = 0; j < SpaceBtwnNodes*TextSize; j++)
	            	   if(Remaining_items%2!=0 && i!=0){
	                  strm.print("-"); //This prints out the dashes between nodes that have the same parent.
	            	   }else{
	            		   strm.print(" ");// This prints out spaces between the nodes that dont have the same parent.
	            	   }
	           
	         }
	         System.out.println("");;//This prints out the necessary space between each level of the tree.
	         currentLevel = TreeUtils.nextLevel(currentLevel);//This loops through the levels of the tree.
	         Remaining_items = currentLevel.size(); // We keep track of the number of the elements each level has.
	      }
	      
	  }
	
//Static Methods for Computing Spacing,Definitions are self explaintory	
	public static int Height(BinaryTreeNode node){
		return node.getHeight();
	}
	
	public static int TextSize(BinaryTreeNode node){
		int n = node.getLargest();
		String StrText = Integer.toString(n);
		return StrText.length();
		}
	
	public static int SpaceBtwNode(int Height, int Depth){
		int Calculation = (int)Math.pow(2,(Height-Depth))-1;
		return Calculation;
	}
	public static int SpaceAtLNode(int width){
		int Calculation = (int)Math.floor(width/2);
		return Calculation;
		}
	public static void LeftSpacing(int Lwidth, int Textwidth){
		for( int i = 0 ; i < Lwidth*Textwidth;i++){
			System.out.print(" ");
		}
	}
	public static void PrintPlaceHolder(int TextSize){
		 for (int k=0; k < TextSize; k++)
             System.out.print(" "); 
		}
	public static void NullNode(){
		System.out.print(" ");
	}

}
