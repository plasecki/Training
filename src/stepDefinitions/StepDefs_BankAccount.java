package stepDefinitions;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import seleniumPages.Page_BankAccount;


public class StepDefs_BankAccount {
	Page_BankAccount bankAccount; 
	String withdrawalStatus;
	
	@Given("^I have (\\d+) PLN on my bank account$")
	public void i_setup_bank_account_balance(int balance) throws Exception {
		bankAccount = new Page_BankAccount(balance);
	}
	
	@When("^I want to withdraw (\\d+) PLN$")
	public void i_withdraw_from_bank_account(int withdrawalValue) throws Exception {
		withdrawalStatus = bankAccount.withdrawFromAccount(withdrawalValue);
		
	}
	
	@Then("^I verify that error message (.*?) is displayed$") 
	public void i_verify_that_error_message_after_withdraw_is_displayed(String errorMessage) throws Exception {
		assertEquals(withdrawalStatus, errorMessage);
	}
	
	@Then("^I received withdrawal value (\\d+) PLN$")
	public void i_verify_withdrawal_value(int withdrawalValue) throws Exception {
		assertEquals(bankAccount.returnWithdrawalValue(), withdrawalValue);
	}
	
	@And("^balance on bank account is still (\\d+) PLN$")
	public void i_verify_account_balance(int balance) throws Exception {
		assertEquals(bankAccount.returnAccountBalance(), balance);
	}

}
