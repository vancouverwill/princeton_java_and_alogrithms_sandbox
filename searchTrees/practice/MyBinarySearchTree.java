package searchTrees.practice;

//import searchTrees.BinarySearchTreeSymbolTable.Node;

public class MyBinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root;
	
	private class Node {
		private Key key;	// sorted by key
		private Value val;		// associated data
		private Node left, right;
		private int N;
		
		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	
	 // is the symbol table empty?
    public boolean isEmpty() {
        return size() == 0;
    }
    
    // return number of key-value pairs in BST
    public int size() {
        return size(root);
    }
    
    private int size(Node x) {
    	if (x == null) return 0;
    	else return x.N;
    }
    
    public void put(Key key, Value val) {
    	if (val == null) { delete(key); return; }
    	root = put(root, key, val);
//    	assert check();
    }
    
    /*public void delete(Key key) {
        root = delete(root, key);
        assert check();
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    } */
    
    private Node put(Node x, Key key, Value val)
    {
    	if (x == null) return new Node(key, val, 1);
    	int cmp = key.compareTo(x.key);
    	if		(cmp < 0) x.left = put(x.left, key, val);
    	else if		(cmp > 0) x.right = put(x.right, key, val);
    	else		x.val = val;
    	x.N = 1 + size(x.left) + size(x.right);
    	return x;
    }
}
