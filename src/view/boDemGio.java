package view;

import java.awt.Font;
import java.awt.Label;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class boDemGio extends JLabel {
	private int giay;
	private Timer time;
	private String phut;
	private String g;
	private String gio;
	private String tenNv;
	
	private Timer timer;
	private TimerTask task;

	public boDemGio(String tenNv) {
		this.tenNv=tenNv;
		this.giay = 30;
		this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		this.setHorizontalAlignment(CENTER);
		phut = String.valueOf(this.giay / 60);
		g = String.valueOf(this.giay % 60);
		gio = String.valueOf(this.giay / (60 * 60));
		if (this.giay / 60 < 10) {
			phut = String.valueOf("0" + this.giay / 60);
		}
		if (this.giay % 60 < 10) {
			g = String.valueOf("0" + this.giay % 60);
		}
		if (this.giay / (60 * 60) < 10) {
			gio = String.valueOf("0" + this.giay / (60 * 60));
		}
//		this.setText(gio + " : " + phut + " : " + g);
		this.setText(phut + " : " + g);
	}

	public boDemGio(String tenNv,int giay) {
		this.tenNv=tenNv;
		this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		this.setHorizontalAlignment(CENTER);
		this.giay = giay;
		phut = String.valueOf(this.giay / 60);
		g = String.valueOf(this.giay % 60);
		gio = String.valueOf(this.giay / 60 * 60);
		if (this.giay / 60 < 10) {
			phut = String.valueOf("0" + this.giay / 60);
		}
		if (this.giay % 60 < 10) {
			g = String.valueOf("0" + this.giay % 60);
		}
		if (this.giay / (60 * 60) < 10) {
			gio = String.valueOf("0" + this.giay / (60 * 60));
		}
//		this.setText(gio + " : " + phut + " : " + g);
		this.setText(phut + " : " + g);
	}
	public void thayDoiText(int giay) {
		this.giay = giay;
		phut = String.valueOf(this.giay / 60);
		g = String.valueOf(this.giay % 60);
		gio = String.valueOf(this.giay / 60 * 60);
		if (this.giay / 60 < 10) {
			phut = String.valueOf("0" + this.giay / 60);
		}
		if (this.giay % 60 < 10) {
			g = String.valueOf("0" + this.giay % 60);
		}
		if (this.giay / (60 * 60) < 10) {
			gio = String.valueOf("0" + this.giay / (60 * 60));
		}
//		this.setText(gio + " : " + phut + " : " + g);
		this.setText(phut + " : " + g);
	}
	public void bdBoDemGio() {
	    timer = new Timer();
	    task = new TimerTask() {

	      public void run() {
	    	if(giay<=0) {
	    		time.cancel();
	    	}
	        giay--;
			phut = String.valueOf(giay / 60);
			g = String.valueOf(giay % 60);
			gio = String.valueOf(giay / 60 * 60);
			if (giay / 60 < 10) {
				phut = String.valueOf("0" + giay / 60);
			}
			if (giay % 60 < 10) {
				g = String.valueOf("0" + giay % 60);
			}
			if (giay / (60 * 60) < 10) {
				gio = String.valueOf("0" + giay / (60 * 60));
			}
//			this.setText(gio + " : " + phut + " : " + g);
			setText(phut + " : " + g);
	      }
	    };
	    timer.schedule(task, 1000, 1000);
	  }

	

}
