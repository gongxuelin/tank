package com.day01;

import java.awt.Color;
import java.awt.Graphics;

public class Tank {
	private int x,y;
	
	public static final int WIDTH=ResourceMgr.tankD.getWidth();
	public static final int HEIGHT=ResourceMgr.tankD.getHeight();
	
	private Dir dir=Dir.DOWN;
	
	private static final int SPEED=10;
	
	private  boolean moving=false;
	
	private TankFrame tankFrame;
	
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
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
/*		Color color=g.getColor();
		g.setColor(Color.yellow);//颜色缓存
		g.fillRect(x,y, 50, 50);//画笔，划线条的颜色
		g.setColor(color);//再画坦克里面的颜色
*/		

		switch (dir) {
		case LEFT:
			g.drawImage(ResourceMgr.tankL, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.tankU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.tankR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.tankD, x, y, null);
			break;
		default:
			break;
		}
		
		moving(g);
	}
	
	public void moving(Graphics g) {
		// TODO Auto-generated method stub
		if(!moving) {//默认false
			return;
		}
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
	}
	public void fire() {
		// TODO Auto-generated method stub
		//对象的引用
		System.out.println("x"+x);
//		tankFrame.bullet=new Bullet(this.x, this.y, this.dir);
		int fx=this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
		int fy=this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
		tankFrame.bulletList.add(new Bullet(fx,fy, this.dir,tankFrame));
	}
	
}
