package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ngheChuot;
import controller.ngheNut;
import model.qlttVeXO;

public class cuaSoJf extends JFrame {
	private int n, anan;
	private JButton nutChoiMoi;
	private JButton nutQuayLai;
	private JButton nutTuyChon;
	private game veCaiBang1;
	private boDemGio thoiGianA;
	private boDemGio thoiGianB;

	public cuaSoJf(int n, int anan) {
		this.n = n;
		this.anan = anan;
		this.init();
		this.setVisible(true);
	}

	public void init() {

		this.setTitle("Cờ Caro");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setLayout(new BorderLayout());

		JPanel thanhChucNang = new JPanel();
		thanhChucNang.setLayout(new FlowLayout());


		nutChoiMoi = new JButton("Chơi mới");
		nutQuayLai = new JButton("Quay lại");
		nutTuyChon = new JButton("Tùy Chọn");

		thanhChucNang.add(nutChoiMoi);
		thanhChucNang.add(nutQuayLai);
		thanhChucNang.add(nutTuyChon);
		thanhChucNang.setBackground(Color.black);

		//

		veCaiBang1 = new game(this.n, anan);
		veCaiBang1.setPreferredSize(new Dimension(720, 720));
		ngheChuot ch = new ngheChuot(this, veCaiBang1);
		veCaiBang1.addMouseListener(ch);
		//

//		JPanel thanhThongTin =new JPanel();
//		JLabel thoiGianA=new JLabel("00:00");
//		thoiGianA.setLayout(new FlowLayout());
//		JLabel thoiGianB=new JLabel("00:00");
//		thoiGianB.setLayout(new FlowLayout());
//		thanhThongTin.setLayout(new GridLayout(1, 2));
//		thanhThongTin.add(thoiGianA);
//		thanhThongTin.add(thoiGianB);
//		thoiGianA.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
//		thoiGianB.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		//
		JPanel thanhThongTin = new JPanel();
		thoiGianA = new boDemGio("A");
		thoiGianB = new boDemGio("B");
		thanhThongTin.setLayout(new GridLayout(1, 2));
		thanhThongTin.add(thoiGianA);
		thanhThongTin.add(thoiGianB);

		//
		panel.add(veCaiBang1, BorderLayout.CENTER);
		panel.add(thanhChucNang, BorderLayout.SOUTH);
		panel.add(thanhThongTin, BorderLayout.NORTH);

		ngheNut ac = new ngheNut(veCaiBang1);
		nutChoiMoi.addActionListener(ac);
		nutQuayLai.addActionListener(ac);

		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
	}



}
