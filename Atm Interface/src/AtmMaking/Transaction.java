package AtmMaking;
import java.util.*;
public class Transaction {
private double amount;
private Date time;
private String memo;
private Account accounts;
public Transaction(double Amount,Account a) {
	this.amount=Amount;
	this.accounts=a;
	time=new Date();
	memo="";
	
}
public Transaction(double amount,String memo,Account a)
{
	this(amount,a);
	this.memo=memo;
}
public double getAmount() {
	// TODO Auto-generated method stub
	return amount;
}
public String  getSummarryLine() {
	if(amount>=0)
	{
		return String.format("%s: $%.02f: %s",time.toString(),amount,memo); 
	}
	
	else {
		return String.format("%s: $(%.02f): %s",time.toString(),-amount,memo); 
	}
}
}
