package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ngheChuot;
import model.qlttVeXO;

public class game extends JPanel {
	private int n, w, h, anan;
	private qlttVeXO maTran[][];
	private Image imgX, imgO;
	private int k;
	private static int dam = 1;

	public Stack<Integer> i = new Stack<>();
	public Stack<Integer> j = new Stack<>();

//
	public game(int n, int anan) {
		this.n = n;
		this.anan = anan;
		this.k = 0;
		if (this.n < 5) {
			dam = 7;
		} else {
			if (this.n < 9) {
				dam = 4;
			} else {
				if (this.n < 11) {
					dam = 3;
				} else {
					if (this.n < 20) {
						dam = 2;
					}
				}
			}
		}
		imgX = Toolkit.getDefaultToolkit().createImage(game.class.getResource("Xx.png"));
		imgO = Toolkit.getDefaultToolkit().createImage(game.class.getResource("Oo.png"));
		this.setBackground(Color.black);
		maTran = new qlttVeXO[this.n][this.n];
		//
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				maTran[i][j] = new qlttVeXO();
			}
		}
		
//		ngheChuot ch = new ngheChuot(this);
//		this.addMouseListener(ch);

	}
	//
	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	// paint
	@Override
	public void paint(Graphics g) {
		this.w = this.getWidth() / this.n;
		this.h = this.getHeight() / this.n;
		//
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				maTran[i][j].setX(j * w);
				maTran[i][j].setY(i * h);
			}
		}
		//
//		System.out.println(w + " " + h);
		Graphics2D g2d = (Graphics2D) g;

		g2d.clearRect(0, 0, this.getWidth(), this.getHeight());

		g2d.setColor(Color.lightGray);
		g2d.setStroke(new BasicStroke(dam));

		for (int i = 0; i < this.n - 1; i++) {
			g2d.drawLine((i + 1) * w, 0, (i + 1) * w, this.n * h);
			g2d.drawLine(0, (i + 1) * h, this.n * w, (i + 1) * h);
		}

		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				if (maTran[i][j].getVal() == qlttVeXO.Xx) {
					g2d.drawImage(imgX, j * w + w / 6, i * h + h / 6, w * 2 / 3, h * 2 / 3, this);
				}
				if (maTran[i][j].getVal() == qlttVeXO.Oo) {
					g2d.drawImage(imgO, j * w + w / 6, i * h + h / 6, w * 2 / 3, h * 2 / 3, this);
				}
			}
		}
	}

//truyền tọa độ vào hàm, hàm sẽ trả về vị trí ma tận theo chuỗi có dạng "i j"
	public String XDij(int xx, int yy) {
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				if (maTran[i][j].getX() < xx && xx <= maTran[i][j].getX() + this.w && maTran[i][j].getY() < yy
						&& yy <= maTran[i][j].getY() + this.h) {
					return i + " " + j;
				}
			}
		}
		return null;
	}

//

//tuyền vào hàm tọa độ hàm sẽ vẽ thay đổi dữ liệu và vẽ thêm XO vào bảng
	public void veLai(int ii, int jj) {

		if (maTran[ii][jj].getVal() == "") {
			if (k % 2 == 0) {
				maTran[ii][jj].setVal(qlttVeXO.Xx);
				i.push(ii);
				j.push(jj);
			}
			if (k % 2 == 1) {
				maTran[ii][jj].setVal(qlttVeXO.Oo);
				i.push(ii);
				j.push(jj);
			}
			k++;
		}
		this.repaint();
	}

//truyền vào hàm tạo độ hàm sẽ kiểm tra tại ô đó có thắng đc ko; thắng trả về 1, chưa thắng (còn tiếp tục chơi) trả về
	public boolean ktChienThang(int hh, int cc) {
		int an = 0;
		// hàng
		for (int i = cc - 1; i >= 0; i--) {
			if (maTran[hh][cc].getVal().equals(maTran[hh][i].getVal())) {
				an++;
				if (an == this.anan - 1) {
					return true;
				}
			} else {
				break;
			}
		}

		for (int i = cc + 1; i <= this.n - 1; i++) {
			if (maTran[hh][cc].getVal().equals(maTran[hh][i].getVal())) {
				an++;
				if (an == this.anan - 1) {
					return true;
				}
			} else {
				break;
			}
		}
		an = 0;

		// cột
		for (int i = hh - 1; i >= 0; i--) {
			if (maTran[hh][cc].getVal().equals(maTran[i][cc].getVal())) {
				an++;
				if (an == this.anan - 1) {
					return true;
				}
			} else {
				break;
			}
		}

		for (int i = hh + 1; i <= this.n - 1; i++) {
			if (maTran[hh][cc].getVal().equals(maTran[i][cc].getVal())) {
				an++;
				if (an == this.anan - 1) {
					return true;
				}
			} else {
				break;
			}
		}
		an = 0;

		// chéo nb
		try {
			for (int i = 1; i <= this.n; i++) {
				if (maTran[hh][cc].getVal().equals(maTran[hh + i][cc + i].getVal())) {
					an++;
					if (an == this.anan - 1) {
						return true;
					}
				} else {
					break;
				}
			}
		} catch (Exception e) {
		}

		try {
			for (int i = 1; i <= this.n; i++) {
				if (maTran[hh][cc].getVal().equals(maTran[hh - i][cc - i].getVal())) {
					an++;
					if (an == this.anan - 1) {
						return true;
					}
				} else {
					break;
				}
			}
		} catch (Exception e) {
		}
		an = 0;

		// chéo đb
		try {
			for (int i = 1; i <= this.n; i++) {
				if (maTran[hh][cc].getVal().equals(maTran[hh + i][cc - i].getVal())) {
					an++;
					if (an == this.anan - 1) {
						return true;
					}
				} else {
					break;
				}
			}
		} catch (Exception e) {
		}

		try {
			for (int i = 1; i <= this.n; i++) {
				if (maTran[hh][cc].getVal().equals(maTran[hh - i][cc + i].getVal())) {
					an++;
					if (an == this.anan - 1) {
						return true;
					}
				} else {
					break;
				}
			}
		} catch (Exception e) {
		}
		an = 0;

		return false;

	}

//hàm này xóa hết dư liệu và vẽ lại => chơi mới
	public void choiMoi() {

		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				maTran[i][j].setVal(qlttVeXO.ko);
			}
		}
		this.i.removeAll(i);
		this.j.removeAll(j);
		this.repaint();
	}

	public void xoaO(int i, int j) {
		maTran[i][j].setVal(qlttVeXO.ko);
		this.k=this.k-1;
		if(this.k<0) {
			this.k=0;
		}
		System.out.println(this.k);
		repaint();
	}
	
	

}
