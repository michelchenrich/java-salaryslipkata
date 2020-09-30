package hm.kata.uk.payroll;

import java.util.function.Consumer;

class CalculatePayrollCommand {
  private final Employee employee;
  private final Consumer<Result> resultReceiver;
  private final PayrollCalculation payrollCalculation;

  CalculatePayrollCommand(Employee employee, Consumer<Result> resultReceiver) {
    this.employee = employee;
    this.resultReceiver = resultReceiver;
    payrollCalculation = new MonthlyPayrollCalculation();
  }

  void execute() {
    var result = new Result(employee.getAnnualGrossSalary());
    result = payrollCalculation.applyTo(result);
    resultReceiver.accept(result);
  }
}
