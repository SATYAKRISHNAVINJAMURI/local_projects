package learningjava;
public class Employee{
                                                     //this intance variable is visible for any child class.
public String name;

                                                     //salary variable is visible in Employee class only.
private double salary;

public String address;
public int ID;

                                                    //the name variable is assigned in the constructor.
public Employee (String empName){
name=empName;
}

                                                    //the Salary variable is assigned a value.
public void setSalary(double empSal){

salary=empSal;
}

                                                    //this prints the employee details.
public void printEmp(){
System.out.println("name  : "+name);
System.out.println("salary : "+salary);

}

public static void main(String[] args){
Employee empOne= new Employee("chetna thakur Vallabhapurapu");
empOne.setSalary(100000);
empOne.printEmp();

}

}
