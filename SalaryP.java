public class SalaryP extends Employee{
	private double salary;
	public SalaryP(String name,String address,int number,double salary){
	super(name,address,number);
	this.salary=salary;
	}
	public void mailCheck(){
	System.out.println("Within main check of salary class");
	System.out.println("Mailing check to "+getName()+)
	}
}