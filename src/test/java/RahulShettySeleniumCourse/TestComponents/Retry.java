package RahulShettySeleniumCourse.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
//test
public class Retry implements IRetryAnalyzer {
	
	int count = 0;
	int maxRun =1;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if (count<maxRun) {
			count++;
			return true;
		}
		return false;
	}
	
	

}
