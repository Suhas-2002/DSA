//Binary Search Tree
/*Operations --> Inserting a node, Deleting a node, Printing in Preorder, Inorder and Postorder*/

package Trees;

public class bst {
	class Node{
		int val;
		Node left, right;
		public Node(int val){
			this.val = val;
			this.left=this.right=null;
		}
	}

	Node root;
	bst(){root=null;}
	void insert(int val){root = insertnode(root,val);}
	void delete(int val){root = deletenode(root,val);}

	Node insertnode(Node root, int val){
		if (root == null){
			root = new Node(val);
			return root;
		}

		if(root.val < val){
			root.right = insertnode(root.right,val);
		}
		else if(root.val > val){
			root.left = insertnode(root.left,val);
		}
		return root;
	}

	Node deletenode(Node root, int val){
		if(root == null){
			return root;
		}

		if(val < root.val){
			root.left = deletenode(root.left,val);
		}
		else if(val > root.val){
			root.right = deletenode(root.right, val);
		}
		else{
			//0 or 1 child
			if(root.left == null){
				return root.right;
			}
			else if(root.right == null){
				return root.left;
			}
			//2 children
			root.val = minnode(root.right);
			root.right = deletenode(root.right, root.val);
		}
		return root;
	}

	int minnode(Node root){
		int min = root.val;
		while(root.left != null){
			min = root.left.val;
			root = root.left;
		}
		return min;
	}

	void preorder(){po(root);}
	void inorder(){io(root);}
	void postorder(){poo(root);}

	void po(Node root){
		if (root!=null){
			System.out.print(root.val+" ");
			po(root.left);
			po(root.right);
		}
	}

	void io(Node root){
		if (root!=null){
			io(root.left);
			System.out.print(root.val+" ");
			io(root.right);
		}
	}

	void poo(Node root){
		if (root!=null){
			poo(root.left);
			poo(root.right);
			System.out.print(root.val+" ");
		}
	}

	void print(){
		System.out.print("Preorder : ");
		preorder();
		System.out.println("");
		System.out.print("Inorder : ");
		inorder();
		System.out.println("");
		System.out.print("Postorder : ");
		postorder();
	}

	public static void main(String[] args) {
		bst tree = new bst();
		tree.insert(100);
		tree.insert(120);
		tree.insert(110);
		tree.insert(130);
		tree.insert(80);
		tree.insert(90);
		tree.insert(70);
		tree.delete(110);
		tree.print();
	}
}
