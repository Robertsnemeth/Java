package bank_account;


public class BankAccount {
	private double checkingBalance;
	private double savingBalance;
	private int accounts = 0;
	private static double accountsTotal = 0.00;
	private long accountNumber = 0000000000;
	
	public BankAccount(double checkingParam, double savingParam) {
		checkingBalance = checkingParam;
		savingBalance = savingParam;
		accounts++;
		accountsTotal += (checkingParam + savingParam);
		accountNumber = randomAccountNumber();
		
	}
	
	private long randomAccountNumber() {
		long randNum = (long) (Math.random()*Math.pow(10,10));
		return randNum;
	}
	
	public double getChecking() {
		return checkingBalance;
	}
	
	public double getSavings() {
		return savingBalance;
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void deposit(String account, double money) {
		if(account == "checking") {
		checkingBalance += money;
		} else if(account == "savings") {
			savingBalance += money;
		} else {
			System.out.println("Please select a valid account.");
		}
	}
	
	public double getAccountTotal() {
		return checkingBalance += savingBalance;
	}
	
}
