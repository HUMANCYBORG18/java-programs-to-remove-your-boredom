import java.awt.event.*;
import javax.swing.*;

class GameQ3 extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    GameQ3(String s)
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
            l.setText("Que1: who made Valorant");
            jb[0].setText("Epic games");jb[1].setText("Riot Games");jb[2].setText("RockStar Games");jb[3].setText("Mojang");
        }
        if(current==1)
        {
            l.setText("Que2: When was the BETA released?");
            jb[0].setText("JUN 3");jb[1].setText("MAY 15");jb[2].setText("APR 7");jb[3].setText("MAR 8");
        }
        if(current==2)
        {
            l.setText("Que3: What was Valorant's old name?");
            jb[0].setText("VALO-7");jb[1].setText("CoreKnights");jb[2].setText("League of agents");jb[3].setText("Project A");
        }
        if(current==3)
        {
            l.setText("Que4: How many knives does jett have on R?");
            jb[0].setText("3");jb[1].setText("7");jb[2].setText("6");jb[3].setText("5");
        }
        if(current==4)
        {
            l.setText("Que5: How many rounds are needed to win the game?");
            jb[0].setText("16");jb[1].setText("12");jb[2].setText("15");jb[3].setText("13");
        }
        if(current==5)
        {
            l.setText("Que6: Whats viper's real name?");
            jb[0].setText("spher");jb[1].setText("lily");jb[2].setText("Sabine");jb[3].setText("Lissandra");
        }
        if(current==6)
        {
            l.setText("Que7: Who is the oldest Valorant agent");
            jb[0].setText("Sova");jb[1].setText("reyna");jb[2].setText("Brimstone");
            jb[3].setText("Viper");
        }
        if(current==7)
        {
            l.setText("Que8:  Which agent has the longest Signature Ability?");
            jb[0].setText("Phoenix");jb[1].setText("BrimeStone");jb[2].setText("Reyna");
            jb[3].setText("Omen");
        }
        if(current==8)
        {
            l.setText("Que9: What's the most accurate gun in Valorant?");
            jb[0].setText("Vandal");jb[1].setText("Guardian");jb[2].setText("Phantom");jb[3].setText("Operator");
        }
        if(current==9)
        {
            l.setText("Que10: What is Chamber's real name?");
            jb[0].setText("Charles Le Clerc");jb[1].setText("Pierre Gasly");jb[2].setText("Vincent Fabron");
            jb[3].setText("Jean Luc Picard");
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

        new GameQ3("Game Quiz");
    }
}


