import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*<applet code="game" height=400 width=400>
</applet>*/

public class game extends Applet implements ActionListener
{
	Button b1,b2,b3,b4,b5;
	Label l1;
	TextField t1;
	int x=300,y=300,r=100;
	
	public void init()
	{
		b1=new Button("  <<  ");
		b1.addActionListener(this);
		add(b1);
		b2=new Button("  >> ");
		b2.addActionListener(this);
		add(b2);
		b3=new Button("  Up  ");
		b3.addActionListener(this);
		add(b3);
		b4=new Button("  Down ");
		b4.addActionListener(this);
		add(b4);
		l1=new Label("Enter the radius of circle : ");
		add(l1);
		t1=new TextField(20);
		add(t1);
		b5=new Button("  Click Me !!!!!!!!!!! ");
		b5.addActionListener(this);
		add(b5);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			x=x-50;
			repaint();
		}
		if(e.getSource()==b2)
		{
			x=x+50;
			repaint();
		}
		if(e.getSource()==b3)
		{
			y=y-50;
			repaint();
		}
		if(e.getSource()==b4)
		{
			y=y+50;
			repaint();
		}
		if(e.getSource()==b5)
		{
			r=Integer.parseInt(t1.getText());
			repaint();
		}
	}


	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.fillOval(x,y,r,r);

	}

	public static void main(String args[])
	{	
		game gm=new game();
	}
}