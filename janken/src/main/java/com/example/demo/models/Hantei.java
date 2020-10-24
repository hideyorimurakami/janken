package com.example.demo.models;

import lombok.Getter;

@Getter
public class Hantei {
	private int cpu;
	private int you;
	private int round;
	private int win;
	private int lose;
	private int draw;



	public Hantei() {
		super();
	}

	public String  judge(int you) {
		this.cpu= (int)(Math.random() *3 + 1);
		this.you = you;
		round++;
		int i = you - cpu;
		switch(i) {
		case 0:
			draw++;
			return "あいこ！";
		case 1:
			lose++;
			return "あなたの負けです！";
		case -2:
			lose++;
			return "あなたの負けです！";
		default:
			win++;
			return "あなたの勝ちです！";
		}
	}
}
