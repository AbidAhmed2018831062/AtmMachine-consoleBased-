package AtmMaking;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class User {
	private String first_name;
	private String last_name;
	private String id;
	private String pin;
	private ArrayList<Account> accounts;
	public User(String first_name,String last_name,String pin,Bank theBank)
	{
		this.first_name=first_name;
		this.last_name=last_name;
		//this.password=pin;
		this.pin=pin;
		this.id=theBank.getNewUserId(); 
		this.accounts=new ArrayList<Account>();
		System.out.println("New User "+this.getName()+" with id "+this.id+" created.");
//		try {
//			MessageDigest md=MessageDigest.getInstance("MD5");
//			this.pinHash=md.digest(pin.getBytes());
//		}
//		catch(NoSuchAlgorithmException e)
//		{
//			e.printStackTrace();
//			System.exit(1);
//		}
	}
	public void addAccount(Account a)
	{
		accounts.add(a);
	}
	public String getId()
	{
		return id;
	}
	public boolean validatePin(String pin) {
//		try {
//			MessageDigest md=MessageDigest.getInstance("MD5");
//			return MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash);
//		}
//		catch(NoSuchAlgorithmException e)
//		{
//			e.printStackTrace();
//			System.exit(1);
//		}
		return this.pin.equals(pin);
		//return false;
	}
	public void printAccountSummary() {
		System.out.println(this.first_name+"'s accounts summary");
		for(int i=0;i<accounts.size();i++)
		{
			System.out.printf("(%d) %s\n",i+1,accounts.get(i).getSummaryLine());
		}
		
	}
	public String getName() {
		// TODO Auto-generated method stub
		return first_name;
	}
	public int  numAccount() {
		return accounts.size();
	}
	public void printAccountTransaction(int a) {
		accounts.get(a).printAccountTransaction();
		
		
	}
	public double getAccountBalance(int a) {
		
		return accounts.get(a).getBalance();
	}
	public String getId(int b) {
		
		return id;
	}
	public void addAccountTransaction(int a, double d, String memo) {
	
		accounts.get(a).addTransaction(d,memo);
	}
}
