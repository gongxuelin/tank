package com.day01;

import com.sun.javafx.font.freetype.FTFactory;

public class Main {
		public static void main(String[] args)  throws Exception{
			
			TankFrame tankFrame=new TankFrame();//自己的坦克
			
			//初始化坦克
			for (int i = 0; i < 5; i++) {
				tankFrame.tankList.add(new Tank(50+i*80, 400,Dir.DOWN, tankFrame));
			}
			
			while (true) {
				Thread.sleep(50);
				tankFrame.repaint();
			}
		} 
}
