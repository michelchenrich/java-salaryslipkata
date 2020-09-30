package hm.kata.uk.payroll;

public class CompositePayrollCalculation implements PayrollCalculation {
  private final PayrollCalculation[] calculations;

  public CompositePayrollCalculation(PayrollCalculation... calculations) {
    this.calculations = calculations;
  }

  @Override
  public Result applyTo(Result result) {
    for (var calculation : calculations) result = calculation.applyTo(result);
    return result;
  }
}
