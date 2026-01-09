package model;

public class qlttVeXO {
	private int x, y;
	private String val;

	public static final String Xx = "x";
	public static final String Oo = "y";
	public static final String ko = "";

	public qlttVeXO() {
		this.val = qlttVeXO.ko;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

}
