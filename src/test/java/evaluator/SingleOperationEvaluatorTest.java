package evaluator;

import operation.OperationFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mtumilowicz on 2018-02-02.
 */
public class SingleOperationEvaluatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void nullArgument() {
        SingleOperationEvaluator.eval(0, null);
    }

    @Test
    public void evalAdd() {
        Assert.assertEquals(10,
                SingleOperationEvaluator.eval(5, OperationFactory.getAdd(5)));
    }

    @Test
    public void evalSubtract() {
        Assert.assertEquals(2,
                SingleOperationEvaluator.eval(7, OperationFactory.getSubtract(5)));
    }

    @Test
    public void evalMultiply() {
        Assert.assertEquals(25,
                SingleOperationEvaluator.eval(5, OperationFactory.getMultiply(5)));
    }

    @Test
    public void evalDivide() {
        Assert.assertEquals(2,
                SingleOperationEvaluator.eval(11, OperationFactory.getDivide(5)));
    }

    @Test
    public void evalApply() {
        Assert.assertEquals(5,
                SingleOperationEvaluator.eval(5, OperationFactory.getApply(5)));
    }
}
