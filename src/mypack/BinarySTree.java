package mypack;

public class BinarySTree {
	
	static BTreeNode insert(int data,BTreeNode root) {
		if (root==null) 
			root=new BTreeNode(data);
		
		else 
			if (data<root.data)
		         root.left=insert(data,root.left);
		    else 
			      root.right=insert(data,root.right);
		return root;
		         
	}

	static void preorder(BTreeNode node) {
		if (node==null) return;
		else {
			System.out.print(node.data+" ");
			preorder(node.left);
			preorder(node.right);
		}
	}
	
	static BTreeNode search(int d,BTreeNode node) {
		if(node==null) return node;
		if(node.data==d)
			return node;
		else if(d<node.data)
			return search(d,node.left);
		else
			return search(d,node.right);
	}
	
	static BTreeNode delete(int d,BTreeNode node) {
		if(node==null) return node;
		if(d<node.data)
			node.left=delete(d,node.left);
		else if(d>node.data)
			node.right=delete(d,node.right);
		else {
			if(node.left==null) return node.right;
			else if(node.right==null) return node.left;
			node.data=minTree(node.right);
			node.right=delete(node.data,node.right);
		}
		return node;
	}
	
	
	
	static int minTree(BTreeNode node) {
		int vmin=node.data;
		while(node.left!=null) {
			vmin=node.left.data;
			node=node.left;
			
		}
		return vmin;
	}
	
	static void visualTree(BTreeNode root,int level,boolean hasright) {
        String rightchar="├─";
        String leftchar="└─";
               
        if (root!=null)
            System.out.print(root.data);
        if (level>0)
            if (hasright)
                System.out.println("(R)");
            else
                System.out.println("(L)");
            else
                System.out.println();
        if (root.right!=null) {
            if (hasright) System.out.print("│");
            for (int i = 0; i <= level-1; i++)
                System.out.print("  ");
            System.out.print(rightchar);
            visualTree(root.right,level+1,true);
        }
       
        if (root.left!=null) {
            if (hasright) System.out.print("│");
            for (int i = 0; i <= level-1; i++)
                System.out.print("  ");
                System.out.print(leftchar);
                visualTree(root.left,level+1,false);
        }
    }
	
	static void postorder(BTreeNode node) {
		if (node==null) return;
		else {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data+" ");
		}
	}
	
	static void inorder(BTreeNode node) {
		if (node==null) return;
		else {
			inorder(node.left);
			System.out.print(node.data+" ");
			inorder(node.right);
		
		}
	}
	
	public static void main(String[] args) {
		BTreeNode root=null;
		root=insert(60,root);
		root=insert(40,root);
		root=insert(50,root);
		root=insert(25,root);
		root=insert(30,root);
		root=insert(29,root);
		root=insert(56,root);
		
		/*new BTreeNode(1);
		root.left=new BTreeNode(2);
		root.right=new BTreeNode(3);
		
		root.left.left=new BTreeNode(4);
		root.left.right=new BTreeNode(5);
		
		root.right.left=new BTreeNode(6);
		root.right.right=new BTreeNode(7);*/
		System.out.println("\nPre order");
		preorder(root);
		System.out.println("\nPost order");
		postorder(root);
		System.out.println("\nIn order");
	    inorder(root);
	    BTreeNode s=search(90,root);
	    if(s!=null)
	    	System.out.println("Data found"+s.data);
	    else
	    	System.out.println("Data not found 90");
	    System.out.println("Minimum is"+minTree(root));
	    visualTree(root,0,true);
	    root=delete(60,root);
	    inorder(root);
	    System.out.println();
	    visualTree(root,0,false);
	    	
		
}


}
