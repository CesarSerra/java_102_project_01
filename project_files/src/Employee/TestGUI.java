package Employee;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;


public class TestGUI extends JFrame 
{
	private ArrayList<Employee> employees = null;
	private JPanel contentPane;
	private static final String FILENAME = "src/Employee/employee.xml";
	private int hoursWorked;
	private double payRate;
	private double grossPay;
	private double meanPay;
	private double medianPay;
	private double stdDeviation;
	private String display = " ";
	DecimalFormat number = new DecimalFormat("#,##0.00");
	StringBuilder sb = new StringBuilder();
	/**
	 * Launch the application.
	 */
    public static void swap (ArrayList <Employee> employee, int i, int j)
    {
       Employee temp = employee.get(i);
       employee.set(i, employee.get(j));
       employee.set(j, temp);
    }
    public static int findMaximum(ArrayList <Employee> employee, int i)
    {
        int j, max = i;
        for(j = i + 1; j < employee.size(); j++)
        {
           if (employee.get(j).getGrossPay() > employee.get(max).getGrossPay())
               max = j;
        }
        return max;
    }
    public static void selectionSort(ArrayList <Employee> employee)
    {
        int i, j;
        for(i = 0; i < employee.size(); i++)
        {
            int min = findMaximum(employee,i);
            swap(employee,i,min);
        }
    }
    public static void insertionSort(ArrayList <Employee> employee)
    {
        int i,j;
        for(i = 0; i < employee.size(); i++)
        {
            Employee temp = employee.get(i);
            j = i - 1;
            while (j >= 0 && employee.get(j).getLastName().compareToIgnoreCase(temp.getLastName()) > 0)
            {
                employee.set(j + 1, employee.get(j));
                j--;
            }
            employee.set(j + 1, temp);
        }
    }
	public void getMean()
	{
		double tempGrossPay = 0;
		for(int x=0;x<employees.size();x++)
		{					
			tempGrossPay = employees.get(x).getGrossPay() + tempGrossPay;
		}
		meanPay = tempGrossPay/employees.size();
	}
	public void getMedian()
	{
		selectionSort(employees);
		if(employees.size() % 2 == 0)
		{
			int tempHold = employees.size()/2;
			int tempHold1 = (employees.size()/2) + 1;
			medianPay = (employees.get(tempHold).getGrossPay() + employees.get(tempHold1).getGrossPay())/2;
		}
		else
		{
			medianPay = employees.get((employees.size()+1)/2).getGrossPay();
		}
	}
	public void getStdDeviation()
	{
		double temp = 0;
		for(int x = 0; x < employees.size(); x++)
		{
			double tempSum = 0;
			tempSum = employees.get(x).getGrossPay() - meanPay;		
			tempSum = (tempSum*tempSum);
			temp = temp + tempSum;
		}
		stdDeviation = temp;
	}
	public static void main(String[] args) 
	{
		
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					TestGUI frame = new TestGUI();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public TestGUI()
	{
		setResizable(false);
		initComponents();
	}
	private void initComponents() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 260);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu jMenuFile = new JMenu("File");
		menuBar.add(jMenuFile);
		
		JMenuItem jMenuItemClear = new JMenuItem("Clear");
		jMenuFile.add(jMenuItemClear);
		
		JMenuItem jMenuItemPrint = new JMenuItem("Print");
		jMenuFile.add(jMenuItemPrint);
		
		JMenuItem jMenuItemQuit = new JMenuItem("Quit");
		jMenuFile.add(jMenuItemQuit);
		
		JMenu jMenuEmployee = new JMenu("Employee Data");
		jMenuEmployee.setToolTipText("Add, Delete, Modify, and Search Employees");
		jMenuEmployee.setMnemonic('E');
		menuBar.add(jMenuEmployee);
		
		JMenuItem jMenuItemNewEmployee = new JMenuItem("New Employee");
		jMenuEmployee.add(jMenuItemNewEmployee);
		
		JMenuItem jMenuItemEditEmployee = new JMenuItem("Edit Employee");
		jMenuEmployee.add(jMenuItemEditEmployee);
		
		JMenuItem jMenuItemDeleteEmployee = new JMenuItem("Delete Employee");
		jMenuEmployee.add(jMenuItemDeleteEmployee);
		
		JMenuItem jMenuItemSearchEmployee = new JMenuItem("Search Employee");
		jMenuEmployee.add(jMenuItemSearchEmployee);
		
		JMenu jMenuStatistics = new JMenu("Statistics");
		jMenuStatistics.setMnemonic('S');
		menuBar.add(jMenuStatistics);
		
		JMenuItem jMenuItemMean = new JMenuItem("Mean");
		jMenuStatistics.add(jMenuItemMean);
		
		JMenuItem jMenuItemMedian = new JMenuItem("Median");

		jMenuStatistics.add(jMenuItemMedian);
		
		JMenuItem jMenuItemStandardDeviation = new JMenuItem("Standard Deviation");
		jMenuItemStandardDeviation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
			}
		});
		jMenuStatistics.add(jMenuItemStandardDeviation);
		
		JMenuItem jMenuItemAllThree = new JMenuItem("All Three");
		jMenuStatistics.add(jMenuItemAllThree);
		
		JMenu jMenuHelp = new JMenu("Help");
		jMenuHelp.setMnemonic('H');
		menuBar.add(jMenuHelp);
		
		JMenuItem jMenuItemAbout = new JMenuItem("About");
		jMenuHelp.add(jMenuItemAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton jButtonQuit = new JButton("Quit");
		jButtonQuit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		jButtonQuit.setMnemonic('Q');
		jButtonQuit.setBounds(12, 165, 185, 25);
		contentPane.add(jButtonQuit);
		
		JButton jButtonDisplay = new JButton("Display Gross Pay");
		jButtonDisplay.setMnemonic('D');
		jButtonDisplay.setBounds(12, 127, 185, 25);
		contentPane.add(jButtonDisplay);
		
		final JComboBox jEmployeeComboBox = new JComboBox();
		jEmployeeComboBox.setBounds(12, 77, 185, 24);
		contentPane.add(jEmployeeComboBox);
		
		JLabel jLabelSelectEmployee = new JLabel("Select Employee:");
		jLabelSelectEmployee.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jLabelSelectEmployee.setBounds(12, 52, 185, 27);
		contentPane.add(jLabelSelectEmployee);
		
		JLabel jLabelEmployeeGrossPay = new JLabel("Employee Gross Pay Statistics");
		jLabelEmployeeGrossPay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jLabelEmployeeGrossPay.setHorizontalAlignment(SwingConstants.CENTER);
		jLabelEmployeeGrossPay.setBounds(12, 13, 543, 25);
		contentPane.add(jLabelEmployeeGrossPay);
		
		JScrollPane jDisplayScrollPane = new JScrollPane();
		jDisplayScrollPane.setBackground(Color.WHITE);
		jDisplayScrollPane.setBounds(218, 62, 337, 128);
		contentPane.add(jDisplayScrollPane);
		
		final JTextArea jDisplayTextArea = new JTextArea();
		jDisplayTextArea.setEnabled(false);
		jDisplayTextArea.setDisabledTextColor(Color.BLACK);
		jDisplayTextArea.setEditable(false);
		jDisplayScrollPane.setViewportView(jDisplayTextArea);
		
		//splash screen


		employees = ReadXML.readFromXML(FILENAME);
		if (employees == null) 
		{
			Component frame = null;
			JOptionPane.showMessageDialog(frame,
				    "File could not be found.",
				    "File Error",
				    JOptionPane.WARNING_MESSAGE);
			System.exit(0);
		}
		int count = employees.size();
		for(int x = 0;x<count;x++)
		{
			
			jEmployeeComboBox.addItem(employees.get(x).getFullName());
		}
		jMenuItemMean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getMean();
				sb.append("The Mean Gross Pay for All Employees is: " + number.format(meanPay) + "\n");
				display = sb.toString();
				jDisplayTextArea.setText(display);
			}
		});
		jButtonDisplay.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				int selectedIndex = jEmployeeComboBox.getSelectedIndex();
				hoursWorked = employees.get(selectedIndex).getHours();
				payRate = employees.get(selectedIndex).getPayRate();
				grossPay = hoursWorked * payRate;
				sb.append("Employee: " + employees.get(selectedIndex).getFullName() + "\n" + 
				"Hours Worked: " + number.format(hoursWorked) + "\n" + "Pay Rate: " + number.format(payRate)
						+ "\n" + "Gross Pay: " + number.format(grossPay) + "\n");
				display = sb.toString(); 
				jDisplayTextArea.setText(display);
				
			}
		});
		jMenuItemClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				jDisplayTextArea.setText(" ");
			}
		});
		jMenuItemMedian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getMedian();
				sb.append("The Median Gross Pay for All Employees is: " + number.format(medianPay) + "\n");
				display = sb.toString();
				jDisplayTextArea.setText(display);
				
			}
		});
		
		
	}
}

