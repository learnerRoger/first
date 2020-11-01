import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
 
public class Ball extends JPanel{
private static final int ballsize=60;
 int x=0; //С���Ĭ��λ��
 int y=0;
 int incx=1; //����С��λ��Ҫ�ƶ��ķ���
 int incy=1;
 private Game tennis;
public Ball(Game tennis)
{
this.tennis=tennis;
}
void moveBall() //����������ǲ��ϸ���С���λ��
{
 
if(x+incx>tennis.getWidth()-ballsize) //���С���ƶ����λ�ó������巶Χ�Ļ�,�ƶ��������һֱ-1;��ΪҪ������Ĵ�С����-60
incx=-1;
if(x+incx<0) //ͬ��
incx=1;
if(y+incy>tennis.getHeight()-ballsize)
tennis.gameOver();
if(y+incy<0)
incy=1;
if (collision()) //�����⵽��ײ�͸ı䷽��
{
incy = -1;
y = tennis.racquet.getTopY() - ballsize;//����ǽ������λ��,Ϊ�˷�ֹ��ײ���µľ����ĺ�С���ص�
tennis.score++;
}
x+=incx;
y+=incy;
}
public void paint(Graphics2D g)
{
g.fillOval(x, y, ballsize, ballsize); 
}
public Rectangle getBounds()//����Rectangle���͵�С��
{
return new Rectangle(x,y,ballsize,ballsize);
}
private boolean collision()  //����Ǽ����ײ
{
return tennis.racquet.getBounds().intersects(getBounds()); //��intersects�����ж�С���Ƿ�������ཻ
}
}