public class BSTree {
	private BSTNode root;
	private String str;
	
	public boolean find(String value) {
		return find(value, root);
	}
		
	public boolean find(String value, BSTNode node) {
		if(node == null) {
			return false;
		}
		if(node.getData().compareTo((String) value) == 0) {
			return true;
		} else if(node.getData().compareTo((String) value) < 0) {
			return find(value, node.getLeft()); 
		} else {
			return find(value, node.getRight());
		}
	}
		
	public BSTNode insert(String value) {
		return insert(value, root);
	}
		
	public BSTNode insert(String value, BSTNode node) {
		if(node == null) {
			return new BSTNode(value);
		}
		if(node.getData().compareTo((String) value) < 0) {
			node.setLeft(insert(value, node.getLeft()));
			return node;
		} else {
			node.setRight(insert(value, node.getRight()));
			return node;
		}
	}
		
	public BSTNode delete(String value) {
		return delete(value, root);
	}
		
	public BSTNode delete(String value, BSTNode node) {
		if(node == null) {
			return null;
		}
		if(node.getData().compareTo((String) value) == 0) {
			if(node.getLeft() == null) {
				return node.getRight();
			} else if(node.getRight() == null) {
				return node.getLeft();
			} else {
				if(node.getRight().getLeft() == null) {
					node.setData(node.getRight().getData());
					node.setRight(node.getRight().getRight());
					return node;
				} else {
					node.setData(removeSmallest(node.getRight()));
					return node;
				}
			}
		} else if(value.compareTo((String) node.getData()) < 0) {
			node.setLeft(delete(value, node.getLeft()));
			return node;
		} else {
			node.setRight(delete(value, node.getRight()));
			return node;
		}
	}
		
	public String removeSmallest(BSTNode node) {
		if(node.getLeft().getLeft() == null) {
			String smallest = node.getLeft().getData();
			node.setLeft(node.getLeft().getRight());
			return smallest;
		} else {
			return removeSmallest(node.getLeft());
		}
	}
		
	public String toStringPreOrder() {
		return toStringPreOrder(str, root);
	}
		
	public String toStringPreOrder(String str, BSTNode node) {
		if(node == null) {
			str += "";
			return str;
		}
		str += node.getData();
		toStringPreOrder(str, node.getLeft());
		toStringPreOrder(str, node.getRight());
		return str;
	}
		
	public String toStringInOrder() {
		return toStringInOrder(str, root);
	}
		
	public String toStringInOrder(String str, BSTNode node) {
		if(node == null) {
			str += "";
			return str;
		}
		toStringInOrder(str, node.getLeft());
		str += node.getData();
		toStringInOrder(str, node.getRight());
		return str;
	}
}
