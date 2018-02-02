package evaluator;

import operation.Operation;
import operation.OperationFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mtumilowicz on 2018-02-02.
 */
public class EvaluatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void nullArgument() {
        Evaluator.eval(null);
    }

    @Test(expected = IllegalStateException.class)
    public void lastArgumentNotApply() {
        Evaluator.eval(Collections.singletonList(
                OperationFactory.getAdd(10)));
    }

    @Test
    public void addSubtractMultiplyDivideApply() {
        List<Operation> operations = Arrays.asList(
                OperationFactory.getAdd(10),
                OperationFactory.getSubtract(4),
                OperationFactory.getMultiply(4),
                OperationFactory.getDivide(3),
                OperationFactory.getApply(9));

        Assert.assertEquals(20, Evaluator.eval(operations));
    }
}
