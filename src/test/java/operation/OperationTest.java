package operation;

import org.junit.Assert;
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

    @Test
    public void evalAdd() {
        Assert.assertEquals(10,
                OperationFactory.getAdd(5).eval(5));
    }

    @Test
    public void evalSubtract() {
        Assert.assertEquals(2,
                OperationFactory.getSubtract(5).eval(7));
    }

    @Test
    public void evalMultiply() {
        Assert.assertEquals(25,
                OperationFactory.getMultiply(5).eval(5));
    }

    @Test
    public void evalDivide() {
        Assert.assertEquals(2,
                OperationFactory.getDivide(5).eval(11));
    }

    @Test
    public void evalApply() {
        Assert.assertEquals(5,
                OperationFactory.getApply(5).eval(5));
    }

    @Test(expected = ArithmeticException.class)
    public void evalAddOverflow() {
        OperationFactory.getAdd(5).eval(Integer.MAX_VALUE);
    }

    private void testOperationTypeAndValue(OperationType type, int value) {
        Operation operation = OperationFactory.get(type, value);
        assertEquals(type, operation.getType());
        assertEquals(value, operation.getAmount());
    }
}
