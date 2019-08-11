package automationpractice.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utilities {
	
public static Select dropDownUtilities(WebElement ele, String value){
		
		Select obj1 = new Select(ele);
		obj1.selectByValue(value);
		return obj1;
	}

public static String getAlphaNumericString(int n) 
{ 

    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                + "0123456789"
                                + "abcdefghijklmnopqrstuvxyz"; 

    StringBuilder sb = new StringBuilder(n); 

    for (int i = 0; i < n; i++) { 
		int index = (int) (AlphaNumericString.length() * Math.random());
		sb.append(AlphaNumericString.charAt(index));
	}

	return sb.toString();
}

}
