package payrollsystem;

import payroll.Employee;

public class Payroll {
    private Employee employee;

    public Payroll(Employee employee) {
        this.employee = employee;
    }

    public double generatePayroll() {
        double salary = employee.getSalary();
        double tax = calculateTax(salary);
        return salary - tax;
    }

    private double calculateTax(double salary) {
        double taxRate = 0.1;  // 10% tax rate
        return salary * taxRate;
    }
}
