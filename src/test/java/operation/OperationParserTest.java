package operation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mtumilowicz on 2018-02-02.
 */
public class OperationParserTest {
    
    @Test(expected = IllegalArgumentException.class)
    public void nullArgument() {
        OperationParser.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void argumentWithoutSeparator() {
        OperationParser.parse("test");
    }

    @Test(expected = IllegalStateException.class)
    public void argumentWithTwoSeparators() {
        OperationParser.parse("test test test");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void parseNotExistingOperation() {
        OperationParser.parse("notExistingOperation 1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseOperationWithNoNumber() {
        OperationParser.parse("notExistingOperation a");
    }
    
    @Test
    public void parseAddUppercase() {
        testOperationTypeAndValueFive(OperationType.ADD, OperationParser.parse("ADD 5"));
    }

    @Test
    public void parseSubtractUppercase() {
        testOperationTypeAndValueFive(OperationType.SUBTRACT, OperationParser.parse("SUBTRACT 5"));
    }

    @Test
    public void parseDivideWithNonZeroUppercase() {
        testOperationTypeAndValueFive(OperationType.DIVIDE, OperationParser.parse("DIVIDE 5"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDivideWithZeroUppercase() {
        testOperationTypeAndValueFive(OperationType.DIVIDE, OperationParser.parse("DIVIDE 0"));
    }

    @Test
    public void parseMultiplyUppercase() {
        testOperationTypeAndValueFive(OperationType.MULTIPLY, OperationParser.parse("MULTIPLY 5"));
    }

    @Test
    public void parseApplyUppercase() {
        testOperationTypeAndValueFive(OperationType.APPLY, OperationParser.parse("APPLY 5"));
    }

    @Test
    public void parseAddLowercase() {
        testOperationTypeAndValueFive(OperationType.ADD, OperationParser.parse("ADD 5"));
    }

    @Test
    public void parseSubtractLowercase() {
        testOperationTypeAndValueFive(OperationType.SUBTRACT, OperationParser.parse("subtract 5"));
    }

    @Test
    public void parseDivideWithNonZeroLowercase() {
        testOperationTypeAndValueFive(OperationType.DIVIDE, OperationParser.parse("divide 5"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseDivideWithZeroLowercase() {
        OperationParser.parse("divide 0");
    }

    @Test
    public void parseMultiplyLowercase() {
        testOperationTypeAndValueFive(OperationType.MULTIPLY, OperationParser.parse("multiply 5"));
    }

    @Test
    public void parseApplyLowercase() {
        testOperationTypeAndValueFive(OperationType.APPLY, OperationParser.parse("apply 5"));
    }

    private void testOperationTypeAndValueFive(OperationType type, Operation operation) {
        assertEquals(type, operation.getType());
        assertEquals(5, operation.getAmount());
    }
}
