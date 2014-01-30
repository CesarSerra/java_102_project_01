package Employee;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class EmployeeDialog extends JDialog {
	private Employee employee= null;
	private EmployeeGUI parent;
	private JTextField firstnNamejTextField;
	private JTextField lastNamejTextField;
	private JTextField payRatejTextField;
	private JTextField hoursWorkedjTextField;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 * @wbp.parser.constructor
	 */
	public EmployeeDialog(EmployeeGUI gui) {
		setResizable(false);
		init();
		parent = gui;
		employee = new Employee();
	}
	
	public EmployeeDialog(Employee employeeToEdit) {
		init();
		if (employeeToEdit == null) {
			dispose();
		}
		employee = employeeToEdit;
		populateDialogWithEmployee();
	}
	
	private void init() {
		setBounds(100, 100, 450, 154);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						if (validateInput()) {
							commitChanges();
						}
					}
					
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				{
					JPanel panel = new JPanel();
					getContentPane().add(panel, BorderLayout.CENTER);
					panel.setLayout(new GridLayout(4, 2, 0, 0));
					{
						JLabel firstNamejLabel = new JLabel("First Name");
						panel.add(firstNamejLabel);
					}
					{
						firstnNamejTextField = new JTextField();
						panel.add(firstnNamejTextField);
						firstnNamejTextField.setColumns(10);
					}
					{
						JLabel lastNamejLabel = new JLabel("Last Name");
						panel.add(lastNamejLabel);
					}
					{
						lastNamejTextField = new JTextField();
						panel.add(lastNamejTextField);
						lastNamejTextField.setColumns(10);
					}
					{
						JLabel payRatejLabel = new JLabel("Pay Rate");
						panel.add(payRatejLabel);
					}
					{
						payRatejTextField = new JTextField();
						panel.add(payRatejTextField);
						payRatejTextField.setColumns(10);
					}
					{
						JLabel hoursWorkedjLabel = new JLabel("Hours Worked");
						panel.add(hoursWorkedjLabel);
					}
					{
						hoursWorkedjTextField = new JTextField();
						panel.add(hoursWorkedjTextField);
						hoursWorkedjTextField.setColumns(10);
					}
				}
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
					
				});
				
			}
		}
	}
	
	private void populateDialogWithEmployee() {
		if (employee == null) { 
			return;
		}
		
		
	}
	
	private boolean validateInput() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void commitChanges() {
		
		
		
		if (parent != null) {
			parent.addEmployee(employee);
		}
		dispose();
	}
	

}
