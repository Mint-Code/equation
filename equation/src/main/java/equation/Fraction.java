package equation;

/**
 * Fraction - 分数。
 * <p>该类继承自{@link equation.AbstractRationalNumber}类，拥有它的全部功能，同时增加了更多分数相关的特性，例如<code>reciprocalOf(): Fraction</code>（倒数）。</p>
 * <blockquote><pre>
Fraction frac = new Fraction(1, 2); //这里表示分数 1/2
frac.makeDenominatorChangeTo(4); // 2/4
frac.simplification(); // 1/2
Fraction reciprocal = frac.reciprocalOf(); // 2/1
 * </pre></blockquote>
 * @see equation.AbstractRationalNumber
 */
public class Fraction extends AbstractRationalNumber {
    /**
     * Fraction - 通过分子和分母创建Fraction对象。
     * @param numerator - int - 分数的分子
     * @param denominator - int - 分数的分母
     * @see equation.Fraction#Fraction(int)
     * @see equation.Fraction#Fraction(double, double)
     * @see equation.Fraction#Fraction(double)
     */
    public Fraction(int numerator, int denominator) {
        super(numerator, denominator);
    }

    /**
     * Fraction - 通过分子创建Fraction对象。
     * <p>注意：当不提供分母时，分母默认为1。</p>
     * @param numerator - int - 分数的分子
     * @see equation.Fraction#Fraction(int, int)
     * @see equation.Fraction#Fraction(double, double)
     * @see equation.Fraction#Fraction(double)
     */
    public Fraction(int numerator) {
        super(numerator);
    }

    /**
     * Fraction - 通过分子和分母创建Fraction对象。
     * <p>该构造函数会将传入的小数自动化为整数并化简。</p>
     * @param numerator - double - 分数的分子
     * @param denominator - double - 分数的分母
     * @see equation.Fraction#Fraction(int, int)
     * @see equation.Fraction#Fraction(int)
     * @see equation.Fraction#Fraction(double)
     */
    public Fraction(double numerator, double denominator) {
        super(numerator, denominator);
    }

    /**
     * Fraction - 通过分子创建Fraction对象。
     * <p>首先，该构造函数会将分母初始化为1（当前该分数为 n/1）；接着，该构造函数会将传入的小数自动化为整数并化简。</p>
     * @param numerator - double - 分数的分子
     * @see equation.Fraction#Fraction(int, int)
     * @see equation.Fraction#Fraction(int)
     * @see equation.Fraction#Fraction(double, double)
     */
    public Fraction(double numerator) {
        super(numerator);
    }

    /**
     * reciprocalOf方法 - 返回当前分数的倒数。
     * <p>您可以直接使用Fraction对象内置的方法，或者也可以使用Equation对象的静态<code>reciprocalOf(Fraction num): Fraction</code>函数。<p>
     * <blockquote><pre>
Fraction frac = new Fraction(1, 2); //这里表示分数 1/2
Fraction result1 = frac.reciprocalOf(); //分数 2/1
Fraction result2 = Equation.reciprocolOf(frac); //这里运算的结果和上面相等
     * </pre></blockquote>
     * @return Fraction - 当前分数的倒数。
     * @see equation.Equation#reciprocolOf(Fraction)
     */
    public Fraction reciprocalOf() {
        return new Fraction(denominator, numerator);
    }

    /**
     * toString方法 - 返回分数的字符串形式（a/b）。
     * @return String - 转化后的字符串
     */
    public String toString() {
        return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }
}
