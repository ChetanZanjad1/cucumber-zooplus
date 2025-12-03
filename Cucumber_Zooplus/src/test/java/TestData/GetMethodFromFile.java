
 
package TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class GetMethodFromFile {

public String GetXpathFrompaymentDetails(String KeyEntry) throws FileNotFoundException, IOException {
	
	Properties prop = new Properties();
	prop.load(new FileInputStream("src\\test\\java\\TestData\\payment_Details"));
	return prop.getProperty(KeyEntry);
} 

}
