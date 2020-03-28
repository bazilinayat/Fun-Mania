import javax.swing.SwingUtilities;

public class Main
{
public static void main(String args[])throws Exception
{
Load s = new Load();
s.setVisible(true);
Thread t1= Thread.currentThread();
t1.sleep(5000);
s.dispose();
new Game();
}
}
