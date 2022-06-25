package equation;

/**
 * Equation - 一个提供一些补充方法的辅助类。
 * <p>该类不能被实例化。它所拥有的全部都是静态方法。例如：</p>
 * <blockquote><pre>
Equation.toFraction(2); // 2/1
Equation.add(new Fraction(1, 2), new Fraction(1, 3)); // 1/2 + 1/3 = 5/6
 * </pre></blockquote>
 * 大部分Number对象的方法在Equation对象中都有提供。
 */
public class Equation {
    /**
     * Equation - 私有的构造函数。
     * <p>因为该类不应该被初始化，所以它的构造函数是私有的。
     */
    private Equation() {
        super();
    }

    /**
     * toFraction方法 - 将一个Number对象转换为Fraction。
     * <p>
     * 无论传入的参数是Number的哪个子类，该方法都能识别并转化为分数。如果想要将整数转化成分数，请使用重载的{@link equation.Equation#toFraction(int)}方法。
     * 当传入的类型无法识别时，将会返回null。
     * </p>
     * <blockquote><pre>
Equation.toFraction(new Fraction(1, 2)); // 1/2
     * </pre></blockquote>
     * @param num - Number - 需要转化的数
     * @return Fraction - 转化后的分数
     */
    public static Fraction toFraction(Number num) {
        if(num instanceof Fraction) {
            return (Fraction) num;
        } else if (num instanceof AbstractRationalNumber) {
            AbstractRationalNumber rational = (AbstractRationalNumber) num;
            return new Fraction(rational.getNumerator(), rational.getDenominator());
        }
        return null;
    }

    /**
     * toFraction方法 - 将一个整数转换为Fraction。
     * <p>如果想要将一个Number对象转化成分数，请使用重载的{@link equation.Equation#toFraction(Number)}方法。</p>
     * <blockquote><pre>
Equation.toFraction(3); // 3/1
     * </pre></blockquote>
     * @param num - int - 需要转化的整数
     * @return Fraction - 转化后的分数
     */
    public static Fraction toFraction(int num) {
        return new Fraction(num, 1);
    }

    /**
     * simplification方法 - 化简传入的分数。
     * <p>
     * 该方法不会改变原有的对象，而是创建并返回一个新的AbstractRationalNumber。
     * 如果想要直接改变当前对象，请使用AbstractRationalNumber的<code>simplification(): void</code>方法。
     * </p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(512, 1024); //这里表示分数 512/1024
frac = Equation.simplification(frac); //现在frac所表示的分数化简成为 1/2
     * </pre></blockquote>
     * @param num - AbstractRationalNumber - 需要化简的数
     * @see equation.AbstractRationalNumber#simplification()
     */
    public static AbstractRationalNumber simplification(AbstractRationalNumber num) {
        num.simplification();
        return num;
    }

    /**
     * add方法 - 将两个Number对象相加。
     * <p>您可以直接使用该方法，或者也可以使用Number对象内置的add方法。</p>
     * <blockquote><pre>
Fraction num1 = new Fraction(1, 2); //这里表示分数 1/2
Fraction num2 = new Fraction(1, 3); //这里表示分数 1/3
Fraction result = (Fraction) (Equation.add(num1, num2)); // 1/2 + 1/3 = 5/6
     * </blockquote></pre>
     * @param num1 - Number - 需要相加的数
     * @param num2 - Number - 需要相加的数
     * @return Number - 两个数相加的结果
     * @see equation.AbstractRationalNumber#add(Number)
     */
    public static Number add(Number num1, Number num2) {
        return num1.add(num2);
    }

    /**
     * sub方法 - 将两个Number对象相减。
     * <p>您可以直接使用该方法，或者也可以使用Number对象内置的sub方法。</p>
     * <blockquote><pre>
Fraction num1 = new Fraction(1, 2); //这里表示分数 1/2
Fraction num2 = new Fraction(1, 3); //这里表示分数 1/3
Fraction result = (Fraction) (Equation.sub(num1, num2)); // 1/2 - 1/3 = 1/6
     * </blockquote></pre>
     * @param num1 - Number - 被减数
     * @param num2 - Number - 减数
     * @return Number - 两个数相减的结果
     * @see equation.AbstractRationalNumber#sub(Number)
     */
    public static Number sub(Number num1, Number num2) {
        return num1.sub(num2);
    }

    /**
     * mult方法 - 将两个Number对象相乘。
     * <p>您可以直接使用该方法，或者也可以使用Number对象内置的mult方法。</p>
     * <blockquote><pre>
Fraction num1 = new Fraction(1, 2); //这里表示分数 1/2
Fraction num2 = new Fraction(1, 3); //这里表示分数 1/3
Fraction result = (Fraction) (Equation.mult(num1, num2)); // 1/2 * 1/3 = 1/6
     * </blockquote></pre>
     * @param num1 - Number - 需要相乘的数
     * @param num2 - Number - 需要相乘的数
     * @return Number - 两个数相乘的结果
     * @see equation.AbstractRationalNumber#mult(Number)
     */
    public static Number mult(Number num1, Number num2) {
        return num1.mult(num2);
    }

    /**
     * div方法 - 将两个Number对象相除。
     * <p>您可以直接使用该方法，或者也可以使用Number对象内置的div方法。</p>
     * <blockquote><pre>
Fraction num1 = new Fraction(1, 2); //这里表示分数 1/2
Fraction num2 = new Fraction(1, 3); //这里表示分数 1/3
Fraction result = (Fraction) (Equation.div(num1, num2)); // 1/2 / 1/3 = 3/2
     * </blockquote></pre>
     * @param num1 - Number - 被除数
     * @param num2 - Number - 除数
     * @return Number - 两个数相除的结果
     * @see equation.AbstractRationalNumber#div(Number)
     */
    public static Number div(Number num1, Number num2) {
        return num1.div(num2);
    }

    /**
     * power方法 - 幂运算。
     * <p>您可以直接使用该方法，或者也可以使用Number对象内置的power方法。</p>
     * <blockquote><pre>
AbstractRationalNumber num = new Fraction(1, 2); //这里表示分数 1/2
Fraction result = (Fraction) (Equation.power(num, 2));
     * </blockquote></pre>
     * @param num - Number - 底数的大小
     * @param index - int - 指数的大小
     * @return Number - 进行乘方运算后的结果
     * @see equation.AbstractRationalNumber#power(int)
     */
    public static Number power(Number num, int index) {
        return num.power(index);
    }
}
