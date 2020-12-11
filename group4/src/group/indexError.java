package group;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class indexError extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//indexError frame = new indexError();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//Create the frame and label
	public indexError() {
		setAlwaysOnTop(true);
		setBounds(100, 100, 549, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// To tell user should input the record index within 1 to 100 and not repeat
		JLabel lblCategory = new JLabel("The records index should within 1 to 100 or the records index should not be repeat.");
		lblCategory.setBounds(26, 35, 497, 76);
		contentPane.add(lblCategory);

	}
}
