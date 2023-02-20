import java.awt.event.*;
import javax.swing.*;

class GameQ4 extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0,x=1,y=1,now=0;
    int m[]=new int[10];
    GameQ4(String s)
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
            l.setText("Que1: Which is not an Elden Ring class?");
            jb[0].setText("Samurai");jb[1].setText("Assassin");jb[2].setText("Hero");jb[3].setText("Vagabond");
        }
        if(current==1)
        {
            l.setText("Que2: Who shattered the Elden Ring?");
            jb[0].setText("Rennala");jb[1].setText("Radagon");jb[2].setText("Marika");jb[3].setText("Godfrey");
        }
        if(current==2)
        {
            l.setText("Que3: Lamar is the best friend to which character?");
            jb[0].setText("Trevor");jb[1].setText("Lester");jb[2].setText("Amanda");jb[3].setText("Franklin");
        }
        if(current==3)
        {
            l.setText("Que4: Which character has the best Driving skills");
            jb[0].setText("Micheal");jb[1].setText("Jimmy");jb[2].setText("Trevor");jb[3].setText("Franklin");
        }
        if(current==4)
        {
            l.setText("Que5: Who stole a fragment of the Rune of Death?");
            jb[0].setText("Rennala");jb[1].setText("Radagon");jb[2].setText("Marika");jb[3].setText("Ranni");
        }
        if(current==5)
        {
            l.setText("Que6: Who is the Prince of Death?");
            jb[0].setText("Rykard");jb[1].setText("Mohg");jb[2].setText("Godwyn");jb[3].setText("Morgott");
        }
        if(current==6)
        {
            l.setText("Que7: What is a Shabriri grape?");
            jb[0].setText("Greatest delicacy");jb[1].setText("Eyeball");jb[2].setText("Forbidden Fruit");
            jb[3].setText("A Grape");
        }
        if(current==7)
        {
            l.setText("Que8:  Who is the main character in Resident Evil 4?");
            jb[0].setText("Ada wong");jb[1].setText("tommy vercetti");jb[2].setText("Solid snake");
            jb[3].setText("Leon kennedy");
        }
        if(current==8)
        {
            l.setText("Que9: What is the currency used in Resident Evil 4 ?");
            jb[0].setText("Coins");jb[1].setText("Euros");jb[2].setText("Dollar");jb[3].setText("Peseta");
        }
        if(current==9)
        {
            l.setText("Que10: What is Chamber's real name?");
            jb[0].setText("Black Blades");jb[1].setText("The Godskin");jb[2].setText("The Crucible Knights");
            jb[3].setText("The Golden order");
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

        new GameQ4("Game Quiz");
    }
}

