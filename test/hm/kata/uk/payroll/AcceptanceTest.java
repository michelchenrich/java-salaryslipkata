package hm.kata.uk.payroll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AcceptanceTest {
  @Test
  void exemptSalary() {
    givenEmployeeWith(5000);
    whenPayrollIsExecuted();
    thenResultIs(416.67, 0.0, 416.67, 0.0, 0.0);
  }

  @Test
  void salaryAboveNiMinimumLimit() {
    givenEmployeeWith(9060);
    whenPayrollIsExecuted();
    thenResultIs(755, 10.0, 755, 0.0, 0.0);
  }

  @Test
  void salaryAboveTaxFreeAllowance() {
    givenEmployeeWith(12000);
    whenPayrollIsExecuted();
    thenResultIs(1000, 39.40, 916.67, 83.33, 16.67);
  }

  @Test
  void salaryAboveSecondTaxBand() {
    givenEmployeeWith(45000);
    whenPayrollIsExecuted();
    thenResultIs(3750, 352.73, 916.67, 2833.33, 600);
  }

  @Test
  void salaryOnTaxFreeAllowanceReductionStart() {
    givenEmployeeWith(101000);
    whenPayrollIsExecuted();
    thenResultIs(8416.67, 446.07, 875, 7541.67, 2483.33);
  }

  @Test
  void salaryOnTaxFreeAllowanceReductionReachesZero() {
    givenEmployeeWith(122000);
    whenPayrollIsExecuted();
    thenResultIs(10166.67, 481.07, 0, 10166.67, 3533.33);
  }

  @Test
  void salaryOnTaxFreeAllowanceReductionReachesZeroJustBeforeHighestRate() {
    givenEmployeeWith(150000);
    whenPayrollIsExecuted();
    thenResultIs(12500, 527.73, 0, 12500, 4466.67);
  }

  @Test
  void salaryOnAdditionalRateBand() {
    givenEmployeeWith(160000);
    whenPayrollIsExecuted();
    thenResultIs(13333.33, 544.4, 0, 13333.33, 4841.67);
  }

  private Employee employee;
  private Result result;

  private void givenEmployeeWith(double annualGrossSalary) {
    employee = new Employee(Money.valueOf(annualGrossSalary));
  }

  private void whenPayrollIsExecuted() {
    new CalculatePayrollCommand(employee, result -> this.result = result).execute();
  }

  private void thenResultIs(
      double gross,
      double niDeduction,
      double taxFreeAllowance,
      double taxableGross,
      double taxDeduction) {
    assertEquals(gross, result.getGross());
    assertEquals(niDeduction, result.getNiDeduction());
    assertEquals(taxFreeAllowance, result.getTaxFreeAllowance());
    assertEquals(taxableGross, result.getTaxableGross());
    assertEquals(taxDeduction, result.getTaxDeduction());
  }

  private void assertEquals(double doubleValue, Money money) {
    Assertions.assertEquals(Money.valueOf(doubleValue), money);
  }
}
