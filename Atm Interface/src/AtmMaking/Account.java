package AtmMaking;
import java.util.*;

public class Account {
	private String name;
	private String id;
	private String password;
	private ArrayList<User> users;
	private User holder;
	private ArrayList<Transaction> t1;
	public  Account(String name,User holder ,Bank theBank)
	{
		this.name=name;
		this.holder=holder;
		t1=new ArrayList<Transaction>();
		id=theBank.getNewAccountId();
		
		
		
		
	}
	public String getId()
	{
		return id;
	}
	public String getSummaryLine()
	{
		double balance=getBalance();
		if(balance>=0)
		{
			return String.format("%s : $%.02f: %s ",id,balance,name);
		}
		else {
			return String.format("%s : $(%.02f): %s ",id,balance,name);
		}
		
	}
	public double getBalance() {
		double balance =0;
		for(Transaction t:t1)
		{
			balance+=t.getAmount();
		}
		return balance;
	}
	public void printAccountTransaction() {
		System.out.println("Transaction for Account :");
		for(int i=t1.size()-1;i>=0;i--)
		{
			System.out.println(t1.get(i).getSummarryLine());
		}
		System.out.println();
		
	}
	public void addTransaction(double d, String memo) {
		Transaction e=new Transaction(d,memo,this);
		t1.add(e);
		
	}
	
	



}
