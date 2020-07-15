import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class myFrame extends JFrame {

	private JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 20, 0);
	private myPanel panel = new myPanel();
	private int level;

	public myFrame() throws HeadlessException {

		super();
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		JPanel sliderPanel = new JPanel();
		sliderPanel.add(slider);
		slider.addChangeListener(new SliderListener());
		Container container = getContentPane(); 
		container.add(sliderPanel, BorderLayout.SOUTH);
		container.add(panel, BorderLayout.CENTER);

	}
	
	
	private class SliderListener implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent arg0) {
			// TODO Auto-generated method stub
			int value = slider.getValue();
			if(value != level) {

				level = value;
				panel.setLevel(level);
				System.out.println(level);
				repaint();
				
			}
			
		}
		
		
		
		
	}

}
