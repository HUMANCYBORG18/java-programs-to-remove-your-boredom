import java.awt.event.*;
import javax.swing.*;

class GameQ5 extends JFrame implements ActionListener {
    JLabel l;
    JRadioButton jb[] = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    GameQ5(String s) {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1 = new JButton("Next");
        b2 = new JButton("Bookmark");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);
        add(b2);
        set();
        l.setBounds(30, 40, 450, 20);
        jb[0].setBounds(50, 80, 100, 20);
        jb[1].setBounds(50, 110, 100, 20);
        jb[2].setBounds(50, 140, 100, 20);
        jb[3].setBounds(50, 170, 100, 20);
        b1.setBounds(100, 240, 100, 30);
        b2.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (check())
                count = count + 1;
            current++;
            set();
            if (current == 9) {
                b1.setEnabled(false);
                b2.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Bookmark")) {
            JButton bk = new JButton("Bookmark" + x);
            bk.setBounds(480, 20 + 30 * x, 100, 30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            set();
            if (current == 9)
                b2.setText("Result");
            setVisible(false);
            setVisible(true);
        }
        for (int i = 0, y = 1; i < x; i++, y++) {
            if (e.getActionCommand().equals("Bookmark" + y)) {
                if (check())
                    count = count + 1;
                now = current;
                current = m[y];
                set();
                ((JButton) e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if (e.getActionCommand().equals("Result")) {
            if (check())
                count = count + 1;
            current++;
            //System.out.println("correct ans="+count);
            JOptionPane.showMessageDialog(this, "correct ans=" + count);
            System.exit(0);
        }
    }

    void set() {
        jb[4].setSelected(true);
        if (current == 0) {
            l.setText("Que1: Who was the tinkers?");
            jb[0].setText("Harry");
            jb[1].setText("Phin");
            jb[2].setText("Davis");
            jb[3].setText("Peter parker");
        }
        if (current == 1) {
            l.setText("Que2:Spiderman Miles Morales released in the year:");
            jb[0].setText("2019");
            jb[1].setText("2023");
            jb[2].setText("2020");
            jb[3].setText("2022");
        }
        if (current == 2) {
            l.setText("Que3: The Spider miles morals is a prequel of");
            jb[0].setText("The new Spider man");
            jb[1].setText("The Amazing Spider man");
            jb[2].setText("Marvels spider man");
            jb[3].setText("Nothing");
        }
        if (current == 3) {
            l.setText("Que4: Who is the main character of GTA IV ?");
            jb[0].setText("Franklin");
            jb[1].setText("Dimitri");
            jb[2].setText("Roman");
            jb[3].setText("Niko Bellic");
        }
        if (current == 4) {
            l.setText("Que5: What city does the game take place in ?");
            jb[0].setText("Vice city");
            jb[1].setText("Iraq");
            jb[2].setText("San andreas");
            jb[3].setText("Liberty city");
        }
        if (current == 5) {
            l.setText("Que6: Who is the steriod pumping body builder ?");
            jb[0].setText("Dwayne");
            jb[1].setText("Packie");
            jb[2].setText("Brucie");
            jb[3].setText("Ray");
        }
        if (current == 6) {
            l.setText("Que7: What is a Shabriri grape?");
            jb[0].setText("Greatest delicacy");
            jb[1].setText("Eyeball");
            jb[2].setText("Forbidden Fruit");
            jb[3].setText("A Grape");
        }
        if (current == 7) {
            l.setText("Que8: How many blocks of iron ore does it take to make one iron ingot?");
            jb[0].setText("9");
            jb[1].setText("2");
            jb[2].setText("5");
            jb[3].setText("1");
        }
        if (current == 8) {
            l.setText("Que9: What are Creepers scared of?");
            jb[0].setText("The dark");
            jb[1].setText("Spiders");
            jb[2].setText("Cows");
            jb[3].setText("Cats");
        }
        if (current == 9) {
            l.setText("Que10: Who is the Endermen's leader?");
            jb[0].setText("Ender king");
            jb[1].setText("ENya");
            jb[2].setText("Ender Dragon");
            jb[3].setText("Donald trump");
        }
        l.setBounds(30, 40, 450, 20);
        for (int i = 0, j = 0; i <= 90; i += 30, j++)
            jb[j].setBounds(50, 80 + i, 200, 20);
    }

    boolean check() {
        if (current == 0)
            return (jb[1].isSelected());
        if (current == 1)
            return (jb[2].isSelected());
        if (current == 2)
            return (jb[3].isSelected());
        if (current == 3)
            return (jb[3].isSelected());
        if (current == 4)
            return (jb[3].isSelected());
        if (current == 5)
            return (jb[2].isSelected());
        if (current == 6)
            return (jb[1].isSelected());
        if (current == 7)
            return (jb[3].isSelected());
        if (current == 8)
            return (jb[1].isSelected());
        if (current == 9)
            return (jb[2].isSelected());
        return false;
    }

    public static void main(String s[]) {

        new GameQ5("Game Quiz");
    }
}