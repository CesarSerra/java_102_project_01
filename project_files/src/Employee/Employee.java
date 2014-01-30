package Employee;
public class Employee 
{
	private String firstNameOfEmployee;
	private String lastNameOfEmployee;
	private int hoursWorked;
	private double payRate;
	
	public Employee()
	{
		this.firstNameOfEmployee = "";
		this.lastNameOfEmployee = "";
		this.hoursWorked = 0;
		this.payRate = 0;
	}
	public Employee(String firstName, String lastName, int hours, double pay)
	{
		if(firstName == null)
		{
			firstNameOfEmployee = "";
		}
		else
			firstNameOfEmployee = firstName;
		if(firstName == null)
		{
			lastNameOfEmployee = "";
		}
		else
			lastNameOfEmployee = lastName;
		hoursWorked = hours;
		payRate = pay;
	}
	public void setFirstName(String name)
	{
		firstNameOfEmployee = name;
	}
	public void setLastName(String name)
	{
		lastNameOfEmployee = name;
	}
	public void setPayRate(double pRate)
	{
		payRate = pRate;
	}
	public void setHours(int hours)
	{
		hoursWorked = hours;
	}
	public String getFirstName()
	{
		return firstNameOfEmployee;
	}
	public String getLastName()
	{
		return lastNameOfEmployee;
	}
	public int getHours()
	{
		return hoursWorked;
	}
	public double getPayRate()
	{
		return payRate;
	}
	public String getFullName()
	{
		StringBuilder sb = new StringBuilder();
		String fullName = sb.append(firstNameOfEmployee + " " + lastNameOfEmployee).toString();
		return fullName;
	}
	public double getGrossPay()
	{
		return hoursWorked * payRate;
	}
	public boolean equals(Employee worker)
	{
		if(this.getFirstName().equalsIgnoreCase(worker.getFirstName()) &&
				this.getLastName().equalsIgnoreCase(worker.getLastName()) &&
				this.getPayRate() == worker.getPayRate() &&
				this.getHours() == worker.getHours())
			return true;
		else
			return false;
	}
}
