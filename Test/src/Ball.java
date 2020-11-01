import javax.swing.*;
import java.awt.Graphics2D;
import java.awt.Rectangle;
 
public class Ball extends JPanel{
private static final int ballsize=60;
 int x=0; //小球的默认位置
 int y=0;
 int incx=1; //这是小球位置要移动的方向
 int incy=1;
 private Game tennis;
public Ball(Game tennis)
{
this.tennis=tennis;
}
void moveBall() //这个方法就是不断更新小球的位置
{
 
if(x+incx>tennis.getWidth()-ballsize) //如果小球移动后的位置超出窗体范围的话,移动方向就是一直-1;因为要考虑球的大小所以-60
incx=-1;
if(x+incx<0) //同理
incx=1;
if(y+incy>tennis.getHeight()-ballsize)
tennis.gameOver();
if(y+incy<0)
incy=1;
if (collision()) //如果检测到碰撞就改变方向
{
incy = -1;
y = tennis.racquet.getTopY() - ballsize;//这个是矫正球的位置,为了防止碰撞导致的就球拍和小球重叠
tennis.score++;
}
x+=incx;
y+=incy;
}
public void paint(Graphics2D g)
{
g.fillOval(x, y, ballsize, ballsize); 
}
public Rectangle getBounds()//返回Rectangle类型的小球
{
return new Rectangle(x,y,ballsize,ballsize);
}
private boolean collision()  //这个是检测碰撞
{
return tennis.racquet.getBounds().intersects(getBounds()); //用intersects方法判断小球是否和球拍相交
}
}