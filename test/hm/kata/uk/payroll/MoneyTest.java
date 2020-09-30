package hm.kata.uk.payroll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class MoneyTest {
  @Test
  void equalsAnotherWithSameAmount() {
    assertEquals(Money.zero(), Money.zero());
    assertEquals(Money.valueOf(1), Money.valueOf(1));
  }

  @Test
  void doesNotEqualAnotherWithDifferentAmount() {
    assertNotEquals(Money.zero(), Money.valueOf(1));
  }

  @Test
  void doesNotEqualSimilarObjectsWithSameContent() {
    assertNotEquals(Money.valueOf(1), "1.00");
    assertNotEquals(Money.valueOf(1), BigDecimal.valueOf(1.0).setScale(2));
  }

  @Test
  void hashCodeIsSameWhenObjectsAreEqual() {
    assertEquals(Money.zero().hashCode(), Money.zero().hashCode());
    assertEquals(Money.valueOf(1).hashCode(), Money.valueOf(1).hashCode());
  }
}
