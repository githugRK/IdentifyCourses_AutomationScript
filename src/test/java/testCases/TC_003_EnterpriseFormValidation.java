package testCases;

import org.testng.annotations.Test;

import pageClasses.FormValidations;
import pageClasses.HomePage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC_003_EnterpriseFormValidation extends BaseClass{
	
	@Test(priority = 1)
	public void openEnterprisePage() {
	    logger.info("Opening Enterprise Page");
	    HomePage hp = new HomePage(driver);
	    hp.clickForCampus();
	}

	@Test(priority = 2, dataProvider = "EnterpriseFormValidation", dataProviderClass = DataProviders.class)
	public void courseList(String FirstName, String LastName, String Email, String phonenumber, String institutetype, String Institutename, String JobRole, String Department, String Description, String country, String state) {
	    logger.info("Starting TC_003_EnterpriseFormValidation");

	    FormValidations fv = new FormValidations(driver);
	    fv.findForm();
	    fv.setFirstName(FirstName);
	    fv.setLastName(LastName);
	    fv.setEmail(Email);
	    fv.setTelephone(phonenumber);
	    fv.setInstituteType(institutetype);
	    fv.setInstituteName(Institutename);
	    fv.setJobRole(JobRole);
	    fv.setDepartment(Department);
	    fv.setDiscription(Description);
	    fv.setCountry(country);
	    fv.setState(state);
	    fv.submit();

	    logger.info("TestCase:3 executed successfully");
	}

}
