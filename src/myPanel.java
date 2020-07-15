import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class myPanel extends JPanel {

	private int level;
	private Color[] colors = new Color[21];

	public myPanel() {

		super();
		Color background = new Color(204, 255, 229);
		this.setBackground(background);
		this.setSize(getSize());
		for (int i = 0; i < colors.length; i++) {
			Color c = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
			colors[i] = c;
		}

	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));

		

		super.paintComponent(g2);
		Color brown = new Color(102, 51, 0);
		g2.setColor(brown);
		g2.drawLine(getWidth() / 2, getHeight() - 20, getWidth() / 2, getHeight() - 70);
		tree(g, getWidth() / 2, getHeight() - 70, 3, 50, level, colors);

	}

	public void tree(Graphics g, int x, int y, int branches, int length, int level, Color[] colors) {

		int angle;
		int b;
		double radians = 0;
		int max = (int) (Math.random() * 200);
		Color c = colors[level]; 
		Graphics2D g2 = (Graphics2D) g;
		
		if (level <= 0)
			return;

		for (int i = 0; i < branches; i++) {

			if(i != branches / 2) {

				angle = max / branches * (i) - max / branches;
				angle += 90;
				angle += (int) (Math.random() * 40);
				angle -= 20;
				radians = Math.toRadians(angle);

				if(level > 18) {
					g2.setStroke(new BasicStroke(3));
				}
				
				else {
					g2.setStroke(new BasicStroke(2));
				}
							
				g2.setColor(c);
				g2.drawLine(x, y, (int) (x + length * Math.cos(radians)), (int) (y - length * Math.sin(radians)));

				
				tree(g, (int) (x + length * Math.cos(radians)), (int) (y - length * Math.sin(radians)),
						(int) (Math.random() * 3 + 2), (int) (4 * level), level - 1, colors);

			}

		}

	}

}
