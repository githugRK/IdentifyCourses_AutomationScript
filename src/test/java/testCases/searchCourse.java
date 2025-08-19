package testCases;


import org.testng.annotations.Test;

import pageClasses.FilterPage;
import pageClasses.HomePage;
import testBase.BaseClass;


public class searchCourse extends BaseClass{
	@Test
	public void courseList()
	{
		logger.info("Strating TC_002_Search For Course");
		HomePage hp = new HomePage(driver);
		
		logger.info("Search for Web Development");
		hp.searchForCourse("Web Development");
		
		FilterPage fp = new FilterPage(driver);
		logger.info("Filtering ---> lanuage: English and Level:Beginning");
		fp.clickEnglish();
		fp.clickBeginner();
		fp.coursesDetails();
	}
}