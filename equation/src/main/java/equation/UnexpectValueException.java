package equation;

/**
 * UnexpectValueException - 错误值异常。
 * <p>当传入的值不符合Number对象运算的规则时，就会抛出该错误。</p>
 */
public class UnexpectValueException extends RuntimeException {
    /**
     * UnexpectValueException - 平常的构造函数。
     * @param message - 需要传递的错误信息
     */
    public UnexpectValueException(String message) {
        super(message);
    }
}
