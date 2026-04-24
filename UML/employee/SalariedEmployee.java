
public class SalariedEmployee extends Employee {
    private double annualSalary;

    public double calculateMonthlyPay() {
        return annualSalary / 12;
    }
}
