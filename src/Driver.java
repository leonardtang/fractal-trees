import java.awt.Toolkit;

import javax.swing.JFrame;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		myFrame piet = new myFrame();
		piet.setTitle("Tree");
		Toolkit tk = Toolkit.getDefaultToolkit();
		int xSize = ((int) tk.getScreenSize().getWidth());
		int ySize = ((int) tk.getScreenSize().getHeight());
		piet.setSize(xSize, ySize);
		piet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		piet.setVisible(true);
	}

}
