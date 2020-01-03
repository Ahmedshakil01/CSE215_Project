package User;

public class SavingsAccount extends Account
{

	public SavingsAccount(UserInformation u)
	{
		super(u);
		setMinBalance(500);
		setWithdrawalLimit(500,20000);
		setBalance(500);
	}
	public SavingsAccount(String an, String pin, double balance, UserInformation u)
	{
		this(u);
		super.setAccountNo(an);
		super.setPIN(pin);
		super.setBalance(balance);
	}

	public void setMinBalance(double a)
	{
		minBalance=a;
	}
	
	public void setWithdrawalLimit(double l, double h)
	{
		minWithdrawal=l;
		maxWithdrawal=h;
	}
	public int getAccountType()
	{
		return Account.SAVINGS_ACCOUNT;
	}


}


