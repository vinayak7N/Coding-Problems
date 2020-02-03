
public class BuilderDesignPattern {
	public static void main(String[] args) {
		BankAccount newAccount = new BankAccount.BankAccountBuilder("Harry", "6543212345678")
				.setEmail("harry@gmail.com").setNewsLetter(false).build();
		System.out.println("Name: " + newAccount.getName());
		System.out.println("Account No. " + newAccount.getAccountNumber());
		System.out.println("Email Id: " + newAccount.getEmail());
	}
}

class BankAccount {
	private String name;
	private String accountNumber;
	private String email;
	private boolean newsLetter;

	//BankAccount Object will be created with the help of BankAccountBuilder class Object
	private BankAccount(BankAccountBuilder bankAccountBuilder) {
		this.name = bankAccountBuilder.name;
		this.email = bankAccountBuilder.email;
		this.accountNumber = bankAccountBuilder.accountNumber;
		this.newsLetter = bankAccountBuilder.newsLetter;
	}

	public String getName() {
		return name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getEmail() {
		return email;
	}

	public boolean isNewsLetter() {
		return newsLetter;
	}

	static class BankAccountBuilder {
		private String name;
		private String accountNumber;
		private String email;
		private boolean newsLetter;

		//Mandatory fields of BankAccount
		public BankAccountBuilder(String name, String accountNumber) {
			this.name = name;
			this.accountNumber = accountNumber;
		}

		//Optional fields which returns same builder object...
		public BankAccountBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public BankAccountBuilder setNewsLetter(boolean newsLetter) {
			this.newsLetter = newsLetter;
			return this;
		}
		//this method builds and return BankAccount Object...
		public BankAccount build() {
			return new BankAccount(this);
		}

	}

}
