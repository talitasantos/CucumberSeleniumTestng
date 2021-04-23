package br.com.tribeiro.steps;

import br.com.tribeiro.pages.IndexPage;
import cucumber.api.java.en.Given;

public class IndexSteps  {
	
	private IndexPage indexPage;
	
	public IndexSteps(IndexPage indexPage) {
		this.indexPage = indexPage;
	}
	
	@Given("I clicked sign in")
	public void clickSignInButton() {
		indexPage.clickSignInBtn();
		
	}


}
