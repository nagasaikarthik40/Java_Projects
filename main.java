import java.util.*;
abstract class Employee{
    private String name;
    private int id;
    
    public Employee(String name,int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    abstract double calculateSalary();
    public String toString(){
        return "Employee [name="+name+", id="+ id+", salary="+calculateSalary()+"]";
    }
    
}
class FullTimeEmployee extends Employee{
    private double monthlySalary;
    public FullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    public double calculateSalary(){
        return monthlySalary;
    }
    
}
class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(String name,int id,int hoursWorked,double hourlyRate ){
        super(name,id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}
class PayRollSystem{
    public ArrayList<Employee> employeeList;
    public PayRollSystem(){
        employeeList=new ArrayList<Employee>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
            }
        }
        if(employeeToRemove!= null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
        for(Employee employee:employeeList){
            System.out.println(employee);
        }
    }
    
}
public class main {
    public static void main(String[] args) {
        PayRollSystem payrollsystem= new PayRollSystem();
        FullTimeEmployee emp1=new FullTimeEmployee("karthik",101,70000.0);
        PartTimeEmployee emp2 = new PartTimeEmployee("Yash",102,40,100);
        payrollsystem.addEmployee(emp1);
        payrollsystem.addEmployee(emp2);
        System.out.println("Initial Employee Details :");
        payrollsystem.displayEmployees();
        System.out.println("Removing Employees :");
        payrollsystem.removeEmployee(102);
        System.out.println("Remaining Employees Details :");
        payrollsystem.displayEmployees();
        
        
    }
}