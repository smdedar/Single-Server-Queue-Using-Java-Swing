package testChart;

import java.awt.EventQueue;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class showintable {

	private JFrame frame;
	private JTable table;
	
	
	
	static int n=10;
	int[] a = new int[n];
	 
	
	
	
	int minimum = 1;
	int maximum = 5;
	int[] arrivalTime = new int[n];
	int[] serviceTime = new int[n];
	int[] serviceStart = new int[n];
	int[] serviceEnd = new int[n];
	int[] spendTime = new int[n];
	int[] waitTime = new int[n];
	int[] idleTime = new int[n];
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showintable window = new showintable();
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
	public showintable() {
		initialize();
		
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 813, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 98, 777, 172);
		frame.getContentPane().add(scrollPane);
	
//**********************************************************************************************************************************************************//
		/// Table Calculation Start
		for (int i = 0; i < n; i++) {

			arrivalTime[i] = minimum + (int) (Math.random() * maximum);
			serviceTime[i] = minimum + (int) (Math.random() * maximum);
		}

		//Arrays.sort(arrivalTime);

		for (int i = 0; i < n; i++) {
			if (i == 0) {
				serviceStart[i] = arrivalTime[i];
				serviceEnd[i] = serviceStart[i] + serviceTime[i];
			} else {
				if (arrivalTime[i] <= serviceEnd[i - 1]) {
					serviceStart[i] = serviceEnd[i - 1];
					serviceEnd[i] = serviceStart[i] + serviceTime[i];
				} else {
					serviceStart[i] = arrivalTime[i];
					serviceEnd[i] = serviceStart[i] + serviceTime[i];
				}
			}
		}
		
	/// Table Calculation End
		
		
		for (int i = 0; i < n; i++) {
			spendTime[i] = serviceEnd[i] - arrivalTime[i];
		if(i==0){
			waitTime[i]=0;
			idleTime[i]=0;
		}else{
			waitTime[i] = serviceStart[i] - arrivalTime[i];
			idleTime[i] = serviceStart[i] - serviceEnd[i-1];
		}
			
			
		}
		
		for (int i = 0; i < n; i++) {
			a[i] = 0;
		}

		for (int i = 0; i < n; i++) {
			if (arrivalTime[i] <= 3 && serviceEnd[i] >= 3) {
				a[0]++;
			}

			if (arrivalTime[i] <= 6 && serviceEnd[i] >= 6) {
				a[1]++;
			}

			if (arrivalTime[i] <= 9 && serviceEnd[i] >= 9) {
				a[2]++;
			}

			if (arrivalTime[i] <= 12 && serviceEnd[i] >= 12) {
				a[3]++;
			}
			
			if (arrivalTime[i] <= 15 && serviceEnd[i] >= 15) {
				a[4]++;
			}
		}
//**********************************************************************************************************************************************************//		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NO","Arrival Time", "Service Time","Service Start","Service End","Spend Time","Wait TIme","Idle Time"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Show Chart");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				chart p1 = new chart("Single Server Queue Graph");
				p1.setVisible(true);
				p1.setBounds(100, 100, 450, 450);
				
			}
		});
		btnNewButton.setBounds(209, 325, 328, 44);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Single Server Queue");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(132, 23, 546, 44);
		frame.getContentPane().add(lblNewLabel);
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		
		for (int i = 0; i < n; i++) {
			model.addRow(new Object[] {i+1,arrivalTime[i],serviceTime[i],serviceStart[i],serviceEnd[i],spendTime[i],waitTime[i],idleTime[i]}); //Add Data To Table
		}
		

	}
	
	
//**********************************************************************************************************************************************************//		
	/// Graph Calculation Start
	public int[] testas() {

		return a;

	}
}


