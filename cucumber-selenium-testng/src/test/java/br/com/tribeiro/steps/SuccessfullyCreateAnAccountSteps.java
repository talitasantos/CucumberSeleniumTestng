package br.com.tribeiro.steps;

import br.com.tribeiro.pages.CreateAnAccountPage;
import br.com.tribeiro.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SuccessfullyCreateAnAccountSteps {

	private LoginPage loginPage;
	private CreateAnAccountPage createAnAccountPage;

	public SuccessfullyCreateAnAccountSteps(LoginPage loginPage, CreateAnAccountPage createAnAccountPage) {
		this.loginPage = loginPage;
		this.createAnAccountPage = createAnAccountPage;
	}

	@Given("I entered a valid email address {string}")
	public void enterValidEmail(String validEmail) {
		loginPage.enterEmailAddressLeft(validEmail);

	}

	@When("I click create an account")
	public void clickCreateAccount() {
		loginPage.accessCreateAnAccountPage();

	}

	@When("select title")
	public void selectTitle() {
		createAnAccountPage.selectTitle();
	}

	@When("fill first name {string}")
	public void fillFirstName(String firstName) {
		createAnAccountPage.fillFirstName(firstName);

	}

	@When("fill last name {string}")
	public void fillLastName(String lastName) {
		createAnAccountPage.fillLastName(lastName);

	}

	@When("fill password {string}")
	public void fillPassword(String password) {
		createAnAccountPage.fillPassword(password);

	}

	@When("select date of birth {string} {string} {string}")
	public void selectDateOfBirth(String day, String month, String year) {
		createAnAccountPage.selectDateOfBirth(day, month, year);
	}

	@When("select to receive newsletter")
	public void selectToReceiveNewsletter() {
		createAnAccountPage.selectToReceiveNewsletter();

	}

	@When("fill company {string}")
	public void fillCompany(String company) {
		createAnAccountPage.fillCompany(company);

	}

	@When("fill address {string}")
	public void fillAddress(String address) {
		createAnAccountPage.fillAddress(address);

	}

	@When("fill city {string}")
	public void fillCity(String city) {
		createAnAccountPage.fillCity(city);

	}

	@When("select {string} state")
	public void selectState(String state) {
		createAnAccountPage.fillState(state);

	}

	@When("fill zip code {string}")
	public void fillZipCode(String zipCode) {
		createAnAccountPage.fillPostalCode(zipCode);

	}

	@When("fill home phone {string}")
	public void filHomePhone(String homePhone) {
		createAnAccountPage.fillHomePhone(homePhone);

	}

	@When("fill mobile phone {string}")
	public void fillMobilePhone(String mobilePhone) {
		createAnAccountPage.fillMobilePhone(mobilePhone);

	}

	@When("fill alternative address {string}")
	public void fillAlternativeAddress(String alternativeAddress) {
		createAnAccountPage.fillAddress(alternativeAddress);

	}

	@When("I click register")
	public void clickRegisterButton() {
		createAnAccountPage.submitAccount();

	}

	@Then("system returns {string} page")
	public void systemMyAccountPage(String myAccountPage) {
		createAnAccountPage.verifyMyAccountPage(myAccountPage);

	}

}
