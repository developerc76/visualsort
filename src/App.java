import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BubbleSort {
	public void bubblesort(int a[]) {
		for (int d = 0; d < a.length - 1; d++) {
			for (int i = 0; i < a.length - d - 1; i++) {
				if (a[i] > a[i+1]) {
					int temp = a[i]; 
					a[i] = a[i+1]; 
					a[i+1] = temp; 
					return;
				}
			}
		}
	}
	
	public boolean isSorted(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i+1]) {
				return false; 
			}
		}
		return true; 
	}
	
}
public class App extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L; // default
	BubbleSort test = new BubbleSort(); 
	int a[] = {8, 2, 4, 1, 3};
	JLabel list = new JLabel("8 2 4 1 3"); 
	JPanel panel = new JPanel(); 
	JFrame frame = new JFrame(); 
	ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("resources/sorting.jpg"));
	JButton bubblesort = new JButton("NEW LIST"); 
	JButton next = new JButton("NEXT STEP"); 
	
	
	public App() {
		JLabel sortType = new JLabel("Bubble Sort Step-by-Step                  "
				+ "                                                             "); 
		
		bubblesort.addActionListener(this);
		bubblesort.setBounds(50, 50, 200, 30);
		next.addActionListener(this);
		next.setBounds(100, 100, 200, 30);
		frame.setIconImage(icon.getImage());
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 300, 300));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(sortType); 
		panel.add(bubblesort); 
		panel.add(next);
		panel.add(list); 
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setTitle("visualsort"); 
		frame.setSize(400, 400); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.pack(); 
		frame.setVisible(true); 
	}
	
	public static void main(String[] args) {
		new App(); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bubblesort) {
			for (int i = 0; i < 5; i++) {
				a[i] = (int)(Math.random() * 10) + 1; 
			}
			String n = ""; 
			for (int i = 0; i < a.length; i++) {
				n += a[i]; 
				n += " "; 
			}
			list.setText(n); 
		} else if (e.getSource() == next) {
			test.bubblesort(a);
			String n = ""; 
			for (int i = 0; i < a.length; i++) {
				n += a[i]; 
				n += " "; 
			}
			list.setText(n);
			frame.setVisible(true); 
			if (test.isSorted(a)) {
				list.setText("Press NEW LIST to create a new list, the current list is now sorted");
			}
		}
	}

}
