package selWithMavenTestNG;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchingWindows {

	WebDriver driver;
	@Test
	public void switchWind()
	{
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");
		driver.manage().window().maximize();
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		Set<String> allWin = driver.getWindowHandles();
		System.out.println("Total Windows ="+allWin.size());
		String win1=null;
		String win2=null;
		Iterator<String> itr=allWin.iterator();
		while(itr.hasNext())
		{
			win1=itr.next();  //next() method reads and store in win1 and pointer moves to next element
			win2=itr.next();
			
		}
		System.out.println("Window1 ="+win1);
		System.out.println("Window2 ="+win2);
		System.out.println("Window1 title="+driver.getTitle());
		driver.switchTo().window(win2);
		System.out.println("Window2 title="+driver.getTitle());

		//fetch enabled property value of SignUp link
		boolean chkEnbleSignUp=driver.findElement(By.linkText("Sign Up")).isEnabled();
		System.out.println(chkEnbleSignUp);
		if(chkEnbleSignUp==true)
		{
			System.out.println("Passed...");
		}
		else
		{
			System.out.println("Failed...");
		}
		driver.quit();
		
	}
}
