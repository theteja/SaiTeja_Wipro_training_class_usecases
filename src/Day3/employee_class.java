package Day3;

class Employee {
    private double salary;

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public double getSalary() {
        return salary;
    }
}

public class employee_class {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setSalary(50000);
        System.out.println("Salary: " + emp.getSalary());
    }
}