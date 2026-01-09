package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.qlttVeXO;
import view.cuaSoJf;
import view.game;

public class ngheChuot implements MouseListener {
	private game keO1;
	private cuaSoJf cs;

	public ngheChuot( cuaSoJf cs,game keO1) {
		this.cs=cs;
		this.keO1 = keO1;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String[] a = keO1.XDij(e.getX(), e.getY()).split(" ");
		int i = Integer.parseInt(a[0]);
		int j = Integer.parseInt(a[1]);
		keO1.veLai(i, j);

		if (keO1.ktChienThang(i, j) && keO1.getK() % 2 == 1) {
			JOptionPane.showMessageDialog(new JFrame(), "X thắng rồi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			keO1.choiMoi();
		}
		if (keO1.ktChienThang(i, j) && keO1.getK() % 2 == 0) {
			JOptionPane.showMessageDialog(new JFrame(), "O thắng rồi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			keO1.choiMoi();
		}
		
		this.amThanh();
		
//		try {
//			Clip clip=AudioSystem.getClip();
//			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("click.wav"));
//			clip.open(audioInputStream);
//			clip.start();
//		} catch (Exception e1) {
//			e1.printStackTrace();
//		}


		
		
		
		
	}
	
	private synchronized void amThanh() {
		Thread th=new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Clip clip=AudioSystem.getClip();
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("click.wav"));
					clip.open(audioInputStream);
					clip.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		th.start();
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
//mersweb
}
