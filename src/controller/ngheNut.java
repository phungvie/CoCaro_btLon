package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import model.qlttVeXO;
import view.cuaSoJf;
import view.game;

public class ngheNut implements ActionListener {
	private game kO;

	public ngheNut(game kO) {
		this.kO = kO;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Chơi mới") {
			kO.choiMoi();
		}
		if (e.getActionCommand() == "Quay lại" && !kO.i.empty() && !kO.i.empty()) {

			int ii = kO.i.peek();
			int jj = kO.j.peek();

			kO.i.pop();
			kO.j.pop();
			kO.xoaO(ii, jj);

		}
	}

}
