package AtmMaking;
import java.util.*;
public class Atm {
	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
Bank theBank=new Bank("Dhaka Bank");
System.out.print("Enter The Number Of New Users To be Added: ");
int e=sc.nextInt();
sc.nextLine();
User newUser[]=new User[e];
for(int i=0;i<e;i++)
{
	System.out.print("Enter Your First Name: ");
	//System.out.println();
	String first_name=sc.nextLine();
	System.out.print("Enter Your Last Name: ");
	String last_name=sc.nextLine();
//	System.out.println();
	System.out.print("Enter Your Pin:");
	String pin=sc.nextLine();
	System.out.println();
	newUser[i]=theBank.addUser(first_name,last_name,pin);
	Account newAccount=new Account("Checking",newUser[i],theBank);
	 newUser[i].addAccount(newAccount);
/*	 User curUser;
	  theBank.addAccount(newAccount);
		curUser=Atm.mainMenuPrompt(theBank,sc)  ;
		Atm.printUserMenu(curUser,sc);*/
}
User curUser;
while(true)
{
	curUser=Atm.mainMenuPrompt(theBank,sc)  ;
	Atm.printUserMenu(curUser,sc);
}

//User newUser=theBank.addUser("Abid","Ahmed","1234");
//Account newAccount=new Account("Checking",newUser,theBank);
//
//  newUser.addAccount(newAccount);
//  theBank.addAccount(newAccount);
 
 
  
	}

	private static void printUserMenu(User aUser, Scanner sc) {
		aUser.printAccountSummary();
		int c;
		do {
			System.out.println("Welcome "+aUser.getName()+" what you like to do?");
		  System.out.println("1)Show Account History");
		  System.out.println("2)Withdraw");
		  System.out.println("3)Deposit");
		  System.out.println("4)Transfer");
		  System.out.println("5)Quit");
		  System.out.print("Enter A Choice: ");
		  c=sc.nextInt();
		  if(c<1||c>5)
		  {
			  System.out.println("PLease enter valid choice");
		  }
		  
		}while(c<1||c>5);
		switch(c){
		case 1:
			Atm.showTransferHistory(aUser,sc);
		break;
		case 2:
			Atm.withdraw(aUser,sc);
			break;
		case 3:
			Atm.deposit(aUser,sc);
			break;
		case 4:
			Atm.transfer(aUser,sc);
			break;
		case 5:
			sc.nextLine();
			break;
			}
		if(c!=5)
		{
			Atm.printUserMenu(aUser,sc);
		}
		
	}

	private static void showTransferHistory(User aUser, Scanner sc) {
	int a;
	do {
		System.out.printf("Enter The Number (1-%d) of the account whose transaction history you want to see",aUser.numAccount());
	a=sc.nextInt()-1;
	if(a<0||a>=aUser.numAccount())
	{
		System.out.println("Enter Valid Account Number");
	}
	
	}while(a<0||a>=aUser.numAccount());
	aUser.printAccountTransaction(a);
		
	}

	private static void withdraw(User aUser, Scanner sc) {
	int a,b;
		double amount,abalance;
		String memo;
		 
			do{
				System.out.printf("Enter The Number (1-%d) of the accounts to withdraw from:" ,aUser.numAccount());
			   b=sc.nextInt()-1;
				if(b<0||b>=aUser.numAccount())
				{
					System.out.println("Enter Valid Account Number");
				}
				
				}while(b<0||b>=aUser.numAccount());
			 abalance=aUser.getAccountBalance(b);
			do {
				System.out.println("Enter The Amount to transfer (max"+abalance+")");
				amount=sc.nextInt();
				if(amount<0)
				{
					System.out.println("Enter Valid Amount");
				}
				else if(abalance<amount)
					System.out.println("Enter Valid Amount");
					
			}while(amount<0||amount>abalance);
			
		//amount=amount+abalance;
	      sc.nextLine();
	      System.out.print("Enter a Memo: ");
	      memo=sc.nextLine();
	      aUser.addAccountTransaction(b, -1*amount, memo);
	      
	}

	private static void deposit(User aUser, Scanner sc) {
		int a ,b;
		double amount,abalance;
		String memo;
//		do{
//			System.out.printf("Enter The Number (1-%d) of the accounts to transfer from:"],aUser.numAccount());
//		   a=sc.nextInt()-1;
//			if(a<0||a>=aUser.numAccount())
//			{
//				System.out.println("Enter Valid Account Number");
//			}
//			
//			}while(a<0||a>=aUser.numAccount());
		 // abalance=aUser.getAccountBalance(a);
			do{
				System.out.printf("Enter The Number (1-%d) of the accounts to deposit in: ",aUser.numAccount());
			   b=sc.nextInt()-1;
				if(b<0||b>=aUser.numAccount())
				{
					System.out.println("Enter Valid Account Number");
				}
				
				}while(b<0||b>=aUser.numAccount());
			do {
				System.out.print("Enter The Amount to deposit ");
				amount=sc.nextInt();
				if(amount<0)
				{
					System.out.println("Enter Valid Amount");
				}
					
			}while(amount<0);
			
		sc.nextLine();
		  System.out.print("Enter a Memo: ");
		memo=sc.nextLine();
		  aUser.addAccountTransaction(b, amount, memo);
	}

	private static void transfer(User aUser, Scanner sc) {
		int a ,b;
		double amount,abalance;
	do{			System.out.printf("Enter The Number (1-%d) of the accounts to transfer from:",aUser.numAccount());
		   a=sc.nextInt()-1;
			if(a<0||a>=aUser.numAccount())
			{
				System.out.println("Enter Valid Account Number");
			}
			
	}while(a<0||a>=aUser.numAccount());
		  abalance=aUser.getAccountBalance(a);
			do{
				System.out.printf("Enter The Number (1-%d) of the accounts to transfer to:",aUser.numAccount());
			   b=sc.nextInt()-1;
				if(b<0||b>=aUser.numAccount())
				{
					System.out.println("Enter Valid Accolunt Number");
				}
				
				}while(b<0||b>=aUser.numAccount());
			do {
				System.out.println("Enter The Amount to transfer (max"+abalance+")");
				amount=sc.nextInt();
				if(amount<0)
				{
					System.out.println("Enter Valid Amount");
				}
				else if(abalance<a)
					System.out.println("Enter Valid Amount");
					
			}while(amount<0||amount>abalance);
			
		//amount=amount+abalance;
		aUser.addAccountTransaction(a,-1*amount,String.format("Transfer To account %s",aUser.getId(b)));
		aUser.addAccountTransaction(b,amount,String.format("Transfer To account %s",aUser.getId(a)));
		//int a ,b;
	}

	private static User mainMenuPrompt(Bank theBank, Scanner sc) {
	String id;
	String pin;
	User aUser;
	do {
		System.out.println("Welcome to "+theBank.getName());
		System.out.print("Enter User Id: ");
		id=sc.nextLine();
		System.out.print("Enter Your Pin: ");
		pin=sc.nextLine();
		aUser=theBank.userLogIn(id,pin);
		if(aUser==null)
		{
			System.out.println("Incorrect Pin/User Id.\nPlease Try Again");
		}
		
	}while(aUser==null);
	return aUser;
  	}



}
