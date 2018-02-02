package evaluator;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import operation.Operation;
import operation.OperationType;

/**
 * Created by mtumilowicz on 2018-02-02.
 */
public final class SingleOperationEvaluator {

    private SingleOperationEvaluator() {
    }

    public static final int eval(int eval, Operation operation) {
        Preconditions.checkArgument(operation != null, "Operation to eval cannot be null.");

        OperationType type = operation.getType();
        Integer result;
        switch (type) {
            case ADD:
                result = IntMath.checkedAdd(eval, operation.getAmount());
                break;
            case SUBTRACT:
                result = IntMath.checkedSubtract(eval, operation.getAmount());
                break;
            case MULTIPLY:
                result = IntMath.checkedMultiply(eval, operation.getAmount());
                break;
            case DIVIDE:
                result = eval / operation.getAmount();
                break;
            case APPLY:
                result = operation.getAmount();
                break;
            default:
                throw new IllegalStateException("Type not supported: " + type);
        }

        return result;
    }
}
