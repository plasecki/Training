package seleniumPages;
 
 
public class Page_BankAccount {
	private int accountBalance;
	private long withdrawalValue;
	
	public Page_BankAccount(int accountBalance) {
	   this.accountBalance = accountBalance;
	   this.withdrawalValue = 0;
	}
	
	public int returnAccountBalance() {
		return this.accountBalance;
	}
	
	public long returnWithdrawalValue() {
		return this.withdrawalValue;
	}
	
	public String withdrawFromAccount(int withdrawValue) {
		if (withdrawValue > this.accountBalance) {
			this.withdrawalValue = 0;
			return "Error. Not enough money to withdraw";
		}
		else {
			this.accountBalance = this.accountBalance - withdrawValue;
			this.withdrawalValue = withdrawValue;
			return "All oK, money that is withdrawed:" + Integer.toString(withdrawValue);
		}
	}


}
