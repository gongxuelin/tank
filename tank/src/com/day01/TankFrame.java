package com.day01;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TankFrame  extends Frame{
	
	static final int GAME_WIDTH=800,GAME_HEIGHT=600;
	
	//封装，继承，多态
	Tank myTank=new Tank(200, 600,Dir.DOWN,this);
	
	List<Tank>  tankList=new ArrayList<>();
	
	List<Bullet> bulletList=new ArrayList<Bullet>();
	
	public TankFrame() {
		// TODO Auto-generated constructor stub
		
		 setSize(GAME_WIDTH,GAME_HEIGHT);
		 setResizable(false);//窗口是否可以变化
		 setVisible(true);//可见
		 
		 setTitle("坦克1");//标题
		 
		 this.addKeyListener(new myKeyListener());
		 
		 addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub 
				super.windowClosing(e);
				System.exit(0);
			}
		});
	}
	
	Image offScreenImage = null;
	@Override
	public void update(Graphics g) {
		//解决闪烁问题，在paint之前会被调用，从缓存中画图片，之后直接把图片显示在电脑上
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	@Override
	public void paint(Graphics g) {
		
		// TODO Auto-generated method stub
		myTank.paint(g);
		//迭代器处理每个子弹中超出边界就删除
		for (int i = 0; i < bulletList.size(); i++) {
			bulletList.get(i).paint(g);
		}
		
		//画坦克
		for (Iterator iterator = tankList.iterator(); iterator.hasNext();) {
			Tank tank = (Tank) iterator.next();
			tank.paint(g);
		}
	}
	
	//添加键盘监听事件
	class myKeyListener extends KeyAdapter{
		
		boolean BL=false;
		boolean BU=false;
		boolean BR=false;
		boolean BD=false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
//			x+=200;
			int key=e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_LEFT:
				BL=true;
				break;
			case KeyEvent.VK_UP:
				BU=true;
				break;
			case KeyEvent.VK_RIGHT:
				BR=true;
				break;
			case KeyEvent.VK_DOWN:
				BD=true;
			default:
				break;
			}
//			repaint();//重画
			System.out.println("key pressed");
			setMainTankDir();
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println("key Released");
			int key=e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_LEFT:
				BL=false;
				break;
			case KeyEvent.VK_UP:
				BU=false;
				break;
			case KeyEvent.VK_RIGHT:
				BR=false;
				break;
			case KeyEvent.VK_DOWN:
				BD=false;
				
			case KeyEvent.VK_CONTROL:
				myTank.fire();
			default:
					break;
			}
			setMainTankDir();
		}
		
		private void setMainTankDir() {
			
			if(!BL&&!BU&&!BR&&!BD) {
				myTank.setMoving(false);
			}else {
				myTank.setMoving(true);
				if(BL)  myTank.setDir(Dir.LEFT);;
				if(BU)  myTank.setDir(Dir.UP);;
				if(BR)  myTank.setDir(Dir.RIGHT);;
				if(BD)  myTank.setDir(Dir.DOWN);;
			}
		}
	}
}
