
public class HourlyEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public double calculateWeeklyPay() {
        return hoursWorked * hourlyRate;
    }
}
