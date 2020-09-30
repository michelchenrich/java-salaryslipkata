package hm.kata.uk.payroll;

class Employee {
  private final Money annualGrossSalary;

  Employee(Money annualGrossSalary) {
    this.annualGrossSalary = annualGrossSalary;
  }

  Money getAnnualGrossSalary() {
    return annualGrossSalary;
  }
}
