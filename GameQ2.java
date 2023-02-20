import java.awt.event.*;
import javax.swing.*;

class GameQ2 extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    GameQ2(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if(e.getActionCommand().equals("Bookmark"))
        {
            JButton bk=new JButton("Bookmark"+x);
            bk.setBounds(480,20+30*x,100,30);
            add(bk);
            bk.addActionListener(this);
            m[x]=current;
            x++;
            current++;
            set();
            if(current==9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for(int i=0,y=1;i<x;i++,y++)
        {
            if(e.getActionCommand().equals("Bookmark"+y))
            {
                if(check())
                    count=count+1;
                now=current;
                current=m[y];
                set();
                ((JButton)e.getSource()).setEnabled(false);
                current=now;
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this,"correct ans="+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1: Who developed PUBG ?");
            jb[0].setText("Darren Sugg");jb[1].setText("Brendan Greene");jb[2].setText("Forrest Lin");jb[3].setText("Micheal Condrey");
        }
        if(current==1)
        {
            l.setText("Que2: Which of the Following Vehicles cannot be driven in PUBG");
            jb[0].setText("Motorcycle");jb[1].setText("Buggy");jb[2].setText("Tractor");jb[3].setText("Aquarail");
        }
        if(current==2)
        {
            l.setText("Que3: Which is the fastest Vehicle In PUBG?");
            jb[0].setText("Dacia");jb[1].setText("UAZ");jb[2].setText("Motorcycle");jb[3].setText("Buggy");
        }
        if(current==3)
        {
            l.setText("Que4: Which of these has a adjustable Zoom in PUBG");
            jb[0].setText("2x");jb[1].setText("3x");jb[2].setText("4x");jb[3].setText("8x");
        }
        if(current==4)
        {
            l.setText("Que5: Which weapon or gun is the most Powerful?");
            jb[0].setText("SLR");jb[1].setText("UPM");jb[2].setText("AKM");jb[3].setText("AWM");
        }
        if(current==5)
        {
            l.setText("Que6: What is the highest rank in PUBG?");
            jb[0].setText("Conqueror");jb[1].setText("Crown");jb[2].setText("Grand Master");jb[3].setText("Ace");
        }
        if(current==6)
        {
            l.setText("Que7: When was the game first released?");
            jb[0].setText("Dec 20 2016");jb[1].setText("Dec 20 2017");jb[2].setText("Jun 20 2016");
            jb[3].setText("jan 20 2018");
        }
        if(current==7)
        {
            l.setText("Que8: What kind of ammunition is required In DBS gun");
            jb[0].setText("9mm");jb[1].setText("12 gauge");jb[2].setText("300 magnum");
            jb[3].setText("5.56mm");
        }
        if(current==8)
        {
            l.setText("Que9: How many Bolt Action Snipers are there in PUBG mobile");
            jb[0].setText("3");jb[1].setText("4");jb[2].setText("5");jb[3].setText("7");
        }
        if(current==9)
        {
            l.setText("Que10: Who is the publisher of the Pubg");
            jb[0].setText("Blizzard");jb[1].setText("EPIC");jb[2].setText("PUBG corporation");
            jb[3].setText("Microsoft");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[1].isSelected());
        if(current==1)
            return(jb[2].isSelected());
        if(current==2)
            return(jb[3].isSelected());
        if(current==3)
            return(jb[3].isSelected());
        if(current==4)
            return(jb[3].isSelected());
        if(current==5)
            return(jb[2].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[3].isSelected());
        if(current==8)
            return(jb[1].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }
    public static void main(String s[])
    {
        new GameQ2("Game Quiz");
    }
}
