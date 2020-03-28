import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import java.awt.event.ActionListener;

public class Load extends JFrame
{
private JLabel imglabel;
private ImageIcon img;
private static JProgressBar pbar;
Thread t=null;

public Load()
{
super("Load");
setSize(404,310);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setUndecorated(true);
JPanel content = (JPanel)getContentPane();
JLabel title = new JLabel("Fun Mania", JLabel.CENTER);
title.setForeground(Color.WHITE);
JLabel copyrt = new JLabel("Copright 2016,Nowrosjee Wadia College");
copyrt.setFont(new Font("TimesRoman", Font.BOLD, 14));
title.setFont(new Font("TimesRoman", Font.BOLD, 50));
content.add(title,BorderLayout.CENTER);
content.add(copyrt,BorderLayout.NORTH);
setVisible(true);
img = new ImageIcon("./res/nightBack.png");;
imglabel = new JLabel(img);
add(imglabel);

setLayout(null);
pbar=new JProgressBar();
pbar.setMinimum(0);
pbar.setMaximum(100);
pbar.setStringPainted(true);
pbar.setForeground(Color.DARK_GRAY);
imglabel.setBounds(0,0,404,310);
add(pbar);
pbar.setPreferredSize(new Dimension(310,30));
pbar.setBounds(0,290,404,20);
Thread t=new Thread()
{
public void run()
{
int i=0;
while(i<=100)
{
pbar.setValue(i);
try
{
sleep(50);
}
catch(InterruptedException ex)
{
Logger.getLogger(Load.class.getName()).log(Level.SEVERE,null,ex);
}
i++;
}
}
};
t.start();
}
}
