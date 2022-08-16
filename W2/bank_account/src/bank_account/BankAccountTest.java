package bank_account;

public class BankAccountTest {

	public static void main(String[] args) {
//		MAKING A NEW ACCOUNT
		BankAccount account1 = new BankAccount(1000,200);
//		TESTING TO SEE IF AMOUNTS ARE ACCURATE TO WHAT WAS ENTERED
		System.out.println(account1.getChecking());
		System.out.println(account1.getSavings());
//		TESTING THE DEPOSIT METHOD
		account1.deposit("checking", 250.00);
		System.out.println(account1.getChecking());
		System.out.println(account1.getSavings());
//		TESTING THE ACCOUNT TOTAL METHOD
		System.out.println(account1.getAccountTotal());
//		TESTING OUT THE ACCOUNT NUMBER STATIC
		BankAccount account2 = new BankAccount(500, 100);
		System.out.println(account2.getAccountNumber());
		System.out.println(account1.getAccountNumber());

		

		


	}

}
