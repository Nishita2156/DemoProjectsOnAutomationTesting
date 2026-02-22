package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver dr;
	
	public GenericUtils(WebDriver dr) {
		this.dr=dr;
		
	}
 
	public void switchWindowToChild() {
		Set<String> s1=dr.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		String parentWindow=i1.next();
		String childWindow=i1.next();
		dr.switchTo().window(childWindow);
	}
}
