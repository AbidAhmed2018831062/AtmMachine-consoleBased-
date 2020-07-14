package AtmMaking;
import java.util.*;
public class Bank {
private String name;
private ArrayList<User> users;
private ArrayList<Account> accounts;
public void addAccount(Account a)
{
	accounts.add(a);
}
public Bank(String name)
{
	this.name=name;
	users=new ArrayList<User>();
	accounts=new ArrayList<Account>();
}
public String getNewUserId()
{
	String id;
	Random ran=new Random();
	int len=6;
   boolean nonUnique;
	do
	{
		id="";
		for(int i=0;i<len;i++)
		{
			id+=((Integer)ran.nextInt(10)).toString();
			
		}
		nonUnique=false;
		for(User u:users)
		{
			if(id.compareTo(u.getId())==0) {
				nonUnique=true;
				break;
			}
		}
	}while(nonUnique);
	return id;
}
public String getNewAccountId()
{
	String id;
	Random ran=new Random();
	int len=6;
   boolean nonUnique;
	do
	{
		id="";
		for(int i=0;i<len;i++)
		{
			id+=((Integer)ran.nextInt(10)).toString();
			
		}
		nonUnique=false;
		for(Account u:accounts)
		{
			if(id.compareTo(u.getId())==0) {
				nonUnique=true;
				break;
			}
		}
	}while(nonUnique);
	return id;
}
public User addUser(String first_name,String last_name,String pin)
{
	User newUser=new User(first_name,last_name,pin,this);
	users.add(newUser);
	Account newAccount=new Account("Savings",newUser,this);
	newUser.addAccount(newAccount);
	this.addAccount(newAccount);
	return newUser;
	
	}
public User userLogIn(String id,String pin) {
for(User u:users)
{
	if(u.getId().compareTo(id)==0&&u.validatePin(pin))
	{
		return u;
	}
}
return null;
}
public String getName() {
	// TODO Auto-generated method stub
	return name;
}
}
