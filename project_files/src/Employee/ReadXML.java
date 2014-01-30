package Employee;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;


public class ReadXML 
{
	public static ArrayList<Employee> readFromXML(String file)
	{
		try {
			File xmlFile = new File(file);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			
			ArrayList<Employee> employeeList = new ArrayList<Employee>();
			
			NodeList nList = doc.getElementsByTagName("Employee");
			for (int temp = 0; temp < nList.getLength(); temp++)
			{
				Node nNode = nList.item(temp);
				
//				System.out.println("HP" + nNode.getNodeName() +"\n" + nNode.getClass().toString());
				
				
				String firstName = "";
				String lastName = "";
				int hoursWorked = 0;
				double payRate = 0;
				NodeList childs = nNode.getChildNodes();
				for(int tempLoop = 0; tempLoop< childs.getLength(); tempLoop++)
				{

					if(childs.item(tempLoop).getNodeName().equalsIgnoreCase("firstname"))
					{
						firstName = childs.item(tempLoop).getTextContent();
					}
					else if(childs.item(tempLoop).getNodeName().equalsIgnoreCase("lastname"))
					{
						lastName = childs.item(tempLoop).getTextContent();
					}
					else if(childs.item(tempLoop).getNodeName().equalsIgnoreCase("hoursworked"))
					{
						hoursWorked = Integer.parseInt(childs.item(tempLoop).getTextContent());
					}
					else if(childs.item(tempLoop).getNodeName().equalsIgnoreCase("payrate"))
					{
						payRate = Double.parseDouble(childs.item(tempLoop).getTextContent());
					}					
					
				}
				
				Employee newEmployee = new Employee(firstName,lastName,hoursWorked,payRate);
				employeeList.add(newEmployee);
				
			}
			
			return employeeList;
					
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return null;
	}
	
	public static boolean commitToFile(ArrayList<Employee> employees, String filePath) 
	{

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			Document employeeDoc;
			DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
			employeeDoc = docBuilder.newDocument();

			Element rootElement = employeeDoc.createElement("Company");
			
			final int count = employees.size();
			for (int i = 0; i < count; ++i) {
				final Employee employee = employees.get(i);
				Element employeeElement = employeeDoc.createElement("Employee");
				Element firstNameElement = (Element) employeeDoc.createElement("FirstName");
                firstNameElement.setTextContent(employee.getFirstName());
				Element lastNameElement = (Element) employeeDoc.createElement("LastName");
                firstNameElement.setTextContent(employee.getLastName());
				Element hoursWorkedElement = (Element) employeeDoc.createElement("HoursWorked");
                firstNameElement.setTextContent(Integer.toString(employee.getHours()));
				Element payRateElement = (Element) employeeDoc.createElement("PayRate");
                firstNameElement.setTextContent(Double.toString(employee.getPayRate()));                
                
                rootElement.appendChild(employeeElement);
				rootElement.appendChild(firstNameElement);
				rootElement.appendChild(lastNameElement);
				rootElement.appendChild(hoursWorkedElement);
				rootElement.appendChild(payRateElement);
			}
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(rootElement);
			
			StreamResult result = new StreamResult(new File(filePath));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			transformer.transform(source, result);

		} catch (Exception e) {
			return false;
		}

		return true;
	}

}