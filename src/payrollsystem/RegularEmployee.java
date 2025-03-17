package payroll;

public class RegularEmployee extends Employee {

    public RegularEmployee(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    public double calculateSalary() {
        return getSalary();  // For regular employees, salary is fixed.
    }
}
