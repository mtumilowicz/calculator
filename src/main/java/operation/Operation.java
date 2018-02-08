package operation;

import com.google.common.math.IntMath;

import java.util.Objects;

/**
 * Created by mtumilowicz on 2018-02-02.
 */
public final class Operation {

    private final OperationType type;
    private final int amount;

    Operation(OperationType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public final OperationType getType() {
        return type;
    }

    public final int getAmount() {
        return amount;
    }

    public final int eval(int eval) {
        Integer result;
        switch (type) {
            case ADD:
                result = IntMath.checkedAdd(eval, amount);
                break;
            case SUBTRACT:
                result = IntMath.checkedSubtract(eval, amount);
                break;
            case MULTIPLY:
                result = IntMath.checkedMultiply(eval, amount);
                break;
            case DIVIDE:
                result = eval / amount;
                break;
            case APPLY:
                result = amount;
                break;
            default:
                throw new IllegalStateException("Type not supported: " + type);
        }

        return result;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return amount == operation.amount &&
                type == operation.type;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(type, amount);
    }

    @Override
    public final String toString() {
        return "operation.Operation{" +
                "type=" + type +
                ", amount=" + amount +
                '}';
    }
}
