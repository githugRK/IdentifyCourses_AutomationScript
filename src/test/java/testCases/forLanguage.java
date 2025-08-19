package testCases;

import org.testng.annotations.Test;

import pageClasses.FilterPage;
import pageClasses.HomePage;
import testBase.BaseClass;

public class forLanguage extends BaseClass{
	@Test
	public void courseList()
	{
		logger.info("Strating TC_003 search for language learning");
		
		HomePage hp = new HomePage(driver);
		hp.searchForCourse("Language Learning");
		
		logger.info("Fliter languages");
		
		FilterPage fp = new FilterPage(driver);
		logger.info("languages with level count");
		
		fp.selectLanguage();
		logger.info("TestCase:3 executed successfully");
	}
}