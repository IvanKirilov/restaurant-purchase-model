package Restaurant21012017;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class RestaurantMain extends JFrame {
	private JLabel PorkCounter, SoupCounter, WineCounter, Pork, Soup, Wine, Purchase;
	private JFrame frame;
	private JPanel panel;
	private JButton PorkMinus, PorkPlus, SoupMinus, SoupPlus, WineMinus, WinePlus, Add;
	private ListenForButton lb;
	private int value, previous, porks, wines, soups;
	private double sum;
	private String total;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantMain window = new RestaurantMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public RestaurantMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 526, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lb = new ListenForButton();

		panel = new JPanel();
		panel.setBounds(0, 11, 500, 261);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		Pork = new JLabel("Pork 3.12");
		Pork.setBounds(303, 11, 56, 14);
		panel.add(Pork);

		Soup = new JLabel("Soup 0.45");
		Soup.setBounds(303, 36, 56, 14);
		panel.add(Soup);

		Wine = new JLabel("Wine 1.70");
		Wine.setBounds(303, 61, 56, 14);
		panel.add(Wine);

		PorkMinus = new JButton("-");
		PorkMinus.setBounds(250, 7, 41, 23);
		PorkMinus.addActionListener(lb);
		panel.add(PorkMinus);

		SoupMinus = new JButton("-");
		SoupMinus.setBounds(250, 32, 43, 23);
		SoupMinus.addActionListener(lb);
		panel.add(SoupMinus);

		SoupPlus = new JButton("+");
		SoupPlus.setBounds(369, 32, 41, 23);
		SoupPlus.addActionListener(lb);
		panel.add(SoupPlus);

		WineMinus = new JButton("-");
		WineMinus.setBounds(250, 57, 43, 23);
		WineMinus.addActionListener(lb);
		panel.add(WineMinus);

		WinePlus = new JButton("+");
		WinePlus.setBounds(369, 57, 41, 23);
		WinePlus.addActionListener(lb);
		panel.add(WinePlus);

		PorkCounter = new JLabel("0");
		PorkCounter.setBounds(197, 11, 17, 14);
		panel.add(PorkCounter);

		SoupCounter = new JLabel("0");
		SoupCounter.setBounds(197, 36, 17, 14);
		panel.add(SoupCounter);

		WineCounter = new JLabel("0");
		WineCounter.setBounds(197, 61, 23, 14);
		panel.add(WineCounter);

		PorkPlus = new JButton("+");
		PorkPlus.setBounds(369, 7, 41, 23);
		PorkPlus.addActionListener(lb);
		panel.add(PorkPlus);

		Purchase = new JLabel("Purchase");
		Purchase.setBounds(20, 126, 480, 14);
		panel.add(Purchase);

		Add = new JButton("Add");
		Add.setBounds(303, 197, 89, 23);
		Add.addActionListener(lb);
		panel.add(Add);
	}

	private class ListenForButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == PorkMinus) {
				previous = Integer.parseInt(PorkCounter.getText());
				value = previous - 1;
				if (value >= 0) {
					PorkCounter.setText(value + "");
				}
			}
			if (e.getSource() == PorkPlus) {
				previous = Integer.parseInt(PorkCounter.getText());
				value = previous + 1;
				PorkCounter.setText(value + "");
			}
			if (e.getSource() == SoupMinus) {
				previous = Integer.parseInt(SoupCounter.getText());
				value = previous - 1;
				if (value >= 0) {
					SoupCounter.setText(value + "");
				}
			}
			if (e.getSource() == SoupPlus) {
				previous = Integer.parseInt(SoupCounter.getText());
				value = previous + 1;
				SoupCounter.setText(value + "");
			}
			if (e.getSource() == WineMinus) {
				previous = Integer.parseInt(WineCounter.getText());
				value = previous - 1;
				if (value >= 0) {
					WineCounter.setText(value + "");
				}
			}
			if (e.getSource() == WinePlus) {
				previous = Integer.parseInt(WineCounter.getText());
				value = previous + 1;
				WineCounter.setText(value + "");
			}
			if (e.getSource() == Add) {

				sum = 0;

				sum += Integer.parseInt(PorkCounter.getText()) * 3.12;
				sum += Integer.parseInt(SoupCounter.getText()) * 0.45;
				sum += Integer.parseInt(WineCounter.getText()) * 1.70;

				String total = "";

				porks = Integer.parseInt(PorkCounter.getText());
				soups = Integer.parseInt(SoupCounter.getText());
				wines = Integer.parseInt(WineCounter.getText());

				if (soups == 0) {
					if (porks == 0) {
						if (wines == 0) {

							JOptionPane.showMessageDialog(RestaurantMain.this, "Input qantity!", "Warning!",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				}

				if (porks > 0) {
					total += (porks + " pork portions; ");
				}
				if (soups > 0) {
					total += (soups + " soup portions; ");
				}
				if (wines > 0) {
					total += (wines + " glasses of wine; ");
				}
				total += "Your purchase is: " + sum;
				Purchase.setText(total);
			}

		}
	}
}
