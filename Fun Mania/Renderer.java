

import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Renderer extends JPanel {
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		if(PianoTiles.pt != null){
			PianoTiles.pt.render(g);			
		}

	} 
}
