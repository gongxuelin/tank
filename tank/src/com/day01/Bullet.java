package com.day01;

import java.awt.Graphics;

//子弹类
public class Bullet {
	private  static final int SPEED=10;
	
	public static final int WIDTH=ResourceMgr.bulletD.getWidth();
	public static final int HEIGHT=ResourceMgr.bulletD.getHeight();

	private int x,y;
	private Dir dir;
	private TankFrame tankFrame;
	
	private boolean living=true;
	
	public Bullet(int x, int y, Dir dir,TankFrame tankFrame) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tankFrame=tankFrame;
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
	public Dir getDir() {
		return dir;
	}
	public void setDir(Dir dir) {
		this.dir = dir;
	}
	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		if(!living) {
		   tankFrame.bulletList.remove(this);
		}
//		Color color=g.getColor();
//		
//		g.setColor(Color.RED);
//		
//		g.fillOval(x,y, WIDTH, HEIGHT);//画笔，重画
//
//		g.setColor(color);
		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
			break;
		default:
			break;
		}		
		
		
		
		moving(g);
	}
	
	public void moving(Graphics g) {
		// TODO Auto-generated method stub
		switch (dir) {
		case LEFT:
			x-=SPEED;
			break;
		case UP:
			y-=SPEED;
			break;
		case RIGHT:
			x +=SPEED;
			break;
		case DOWN:
			y +=SPEED;
			break;
		default:
			break;
		}
		
		if(x<0||y<0||
				x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT) {
			living=false;
		}
	}
	
	
}
