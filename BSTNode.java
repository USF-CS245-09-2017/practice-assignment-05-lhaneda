
public class BSTNode {
	private String data;
	private BSTNode left;
	private BSTNode right;
	
	public BSTNode(String data) {
		this.setData(data);
	}
		
	public BSTNode(String data, BSTNode left, BSTNode right) {
		this.setData(data);
		this.setLeft(left);
		this.setRight(right);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}
}
