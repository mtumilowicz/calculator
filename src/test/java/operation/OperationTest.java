package operation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mtumilowicz on 2018-02-02.
 */
public class OperationTest {

    @Test(expected = IllegalArgumentException.class)
    public void nullOperationType() {
        OperationFactory.get(null, 0);
    }

    @Test
    public void getAdd() {
        testOperationTypeAndValue(OperationType.ADD, 0);
    }

    @Test
    public void getSubtract() {
        testOperationTypeAndValue(OperationType.SUBTRACT, 0);
    }

    @Test
    public void getDivideByNotZero() {
        testOperationTypeAndValue(OperationType.DIVIDE, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getDivideByZero() {
        OperationFactory.getDivide(0);
    }

    @Test
    public void getMultiply() {
        testOperationTypeAndValue(OperationType.MULTIPLY, 0);
    }

    private void testOperationTypeAndValue(OperationType type, int value) {
        Operation operation = OperationFactory.get(type, value);
        assertEquals(type, operation.getType());
        assertEquals(value, operation.getAmount());
    }
}
