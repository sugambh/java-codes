import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;


/* implementation of  leaf/node of a tree */

class Node{
	String data;	
	Node left;
	Node right;
	Node(String input){
		data=input;
		left=null;
		right=null;
		
	}
	public void setLeft(Node left){
        this.left = left;
    }
    public void setRight(Node right){
        this.right = right;
    }
    public Node getLeft(){
        return this.left;
    }        
    public Node getRight(){
        return this.right;
    }
    public String getData(){
        return this.data;
    }
}





/*  Implementation of tree class*/

class Tree
{
	 FileWriter f;
	 public void openfile()
	 { 
		f = new FileWriter("output.txt");
	 }
	 public void closefile()
	 {
		f.close();
	 }
	 public Node root; // ?
	 public Tree()
     	 {
         root = null;
	 }
	 public boolean isEmpty()
	 {
         return root == null;
     	 }
	 public void insert(String value)
     	 {
         root = insert(root, value);
	 }

	 private Node insert(Node node, String value)
	 {
         if (node == null)
             node = new Node(value);
         else
         {
	     String current=node.getData();
	     int data=current.compareTo(value);
             if (data<0)
                 node.right = insert(node.right,value);
             else
                 node.left = insert(node.left, value);
         }
         return node;
     	}
	public void inorder(Node r)
     	{
        if (r != null)
        {
            inorder(r.getLeft());
            //System.out.println(r.getData() +" ");
	    f.write(r.getData());
            inorder(r.getRight());

         }

     	}

	
	
}



/* main class of this project */
public class Assignment1 {
	
	
	public static void main(String[] args) throws IOException
	{
		FileReader in = new FileReader("sample") ;
		BufferedReader text= new BufferedReader(in);
		String  thisLine = null;
		Tree mytree=new Tree();
		while ((thisLine = text.readLine()) != null) {
			System.out.println(thisLine);
			mytree.insert(thisLine);
			
			
			//System.out.println(mytree.root.data);
		
			}
		System.out.println("*********************************");
		System.out.println("Inorder Traversal");
		mytree.openfile();
		mytree.inorder(mytree.root);
		mytree.closefile();
		text.close();

	}
}



