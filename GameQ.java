import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GameQ extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    GameQ(String s)
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
            l.setText("Que1: What year was the Super Nintendo Entertainment System (SNES) released?");
            jb[0].setText("1991");jb[1].setText("1992");jb[2].setText("1996");jb[3].setText("1995");
        }
        if(current==1)
        {
            l.setText("Que2: Who is the man with the white infernous and white clothes?");
            jb[0].setText("Ryder");jb[1].setText("Diaz");jb[2].setText("Lance Vance");jb[3].setText("Kent paul");
        }
        if(current==2)
        {
            l.setText("Que3:  Who is your boss as you proceed through the game?");
            jb[0].setText("Don Forelli");jb[1].setText("Mark Forelli");jb[2].setText("Lance Forelli");jb[3].setText("Sonny Forelli");
        }
        if(current==3)
        {
            l.setText("Que4: Who actually provides the voice on all the telephone missions?");
            jb[0].setText("Diaz");jb[1].setText("Colen");jb[2].setText("Ronney");jb[3].setText("Never Told");
        }
        if(current==4)
        {
            l.setText("Que5: dante called _____ a deadwieght?");
            jb[0].setText("V");jb[1].setText("Vergil");jb[2].setText("Lady");jb[3].setText("Nero");
        }
        if(current==5)
        {
            l.setText("Que6: Who cuts neros Arm?");
            jb[0].setText("V");jb[1].setText("Dante");jb[2].setText("Morrison");jb[3].setText("Vergil");
        }
        if(current==6)
        {
            l.setText("Que7: who made Dante's guns Ebony & Ivory?");
            jb[0].setText("Nico");jb[1].setText("Nell Goldstein");jb[2].setText("Trish");
            jb[3].setText("lady");
        }
        if(current==7)
        {
            l.setText("Que8: who is the protagonist of ghost of tsushima?");
            jb[0].setText("Taka");jb[1].setText("Lord Shimura");jb[2].setText("kyuton khan");
            jb[3].setText("Jin sakai");
        }
        if(current==8)
        {
            l.setText("Que9: What the name of the weapon which the protagonist uses?");
            jb[0].setText("Katana");jb[1].setText("Spear");jb[2].setText("Duel Katana");jb[3].setText("Long Bow");
        }
        if(current==9)
        {
            l.setText("Que10: which game is the game of the year 2022?");
            jb[0].setText("Neon white");jb[1].setText("GOWR");jb[2].setText("Elden ring");
            jb[3].setText("Stray");
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
        new GameQ("Games Quiz");
    }
}

