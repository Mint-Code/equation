package equation;

/**
 * Number接口 - 实现基本运算的基础。
 * <p>该接口要求子类实现5种基本运算：加、减、乘、除、幂运算。您可以这样使用Number的子类去进行运算：</p>
 * <blockquote><pre>
Number num1 = new Fraction(1, 2); //这里表示分数 1/2
Number num2 = new Fraction(1, 3); //这里表示分数 1/3
System.out.println(num1.add(num2).toString()); // 1/2 + 1/3 = 5/6
 * </pre></blockquote>
 * <p>您也可以使用<code>toDouble()</code>函数来实现Number对象和主数据类型之间的转换：</p>
 * <blockquote><pre>
System.out.println(new Fraction(1, 2).toDouble()); // 0.5
 * </blockquote></pre>
 * <p>每个方法的具体作用将会在各个方法的注释内阐述。</p>
 * 
 * @see equation.AbstractRationalNumber
 */
public interface Number {
    /**
     * add方法 - 将两个Number对象相加。
     * <p>您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>add(Number num1, Number num2): Number</code>函数。</p>
     * <blockquote><pre>
Number num1 = new Fraction(1, 2); //这里表示分数 1/2
Number num2 = new Fraction(1, 3); //这里表示分数 1/3

Number num3 = num1.add(num2); // 1/2 + 1/3 = 5/6
Number num4 = Equation.add(num1, num2); //这里运算的结果与上面相等
     * </blockquote></pre>
     * @param num - Number - 需要相加的数
     * @return Number - 两个数相加的结果
     * @see equation.Equation#add(Number, Number)
     */
    public Number add(Number num);

    /**
     * sub方法 - 将两个Number对象相减。
     * <p>您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>sub(Number num1, Number num2): Number</code>函数。</p>
     * <blockquote><pre>
Number num1 = new Fraction(1, 2); //这里表示分数 1/2
Number num2 = new Fraction(1, 3); //这里表示分数 1/3

Number num3 = num1.sub(num2); // 1/2 - 1/3 = 1/6
Number num4 = Equation.sub(num1, num2); //这里运算的结果与上面相等
     * </blockquote></pre>
     * @param num - Number - 需要相减的数
     * @return Number - 两个数相减的结果
     * @see equation.Equation#sub(Number, Number)
     */
    public Number sub(Number num);

    /**
     * mult方法 - 将两个Number对象相乘。
     * <p>您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>mult(Number num1, Number num2): Number</code>函数。</p>
     * <blockquote><pre>
Number num1 = new Fraction(1, 2); //这里表示分数 1/2
Number num2 = new Fraction(1, 3); //这里表示分数 1/3

Number num3 = num1.mult(num2); // 1/2 * 1/3 = 1/6
Number num4 = Equation.mult(num1, num2); //这里运算的结果与上面相等
     * </blockquote></pre>
     * @param num - Number - 需要相乘的数
     * @return Number - 两个数相乘的结果
     * @see equation.Equation#mult(Number, Number)
     */
    public Number mult(Number num);

    /**
     * div方法 - 将两个Number对象相除。
     * <p>您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>div(Number num1, Number num2): Number</code>函数。</p>
     * <blockquote><pre>
Number num1 = new Fraction(1, 2); //这里表示分数 1/2
Number num2 = new Fraction(1, 3); //这里表示分数 1/3

Number num3 = num1.div(num2); // 1/2 / 1/3 = 3/2
Number num4 = Equation.div(num1, num2); //这里运算的结果与上面相等
     * </blockquote></pre>
     * @param num - Number - 需要相除的数
     * @return Number - 两个数相除的结果
     * @see equation.Equation#div(Number, Number)
     */
    public Number div(Number num);

    /**
     * power方法 - 对自身的幂运算。
     * <p>您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>power(Number num, int index): Number</code>函数。</p>
     * <blockquote><pre>
Number num = new Fraction(1, 2); //这里表示分数 1/2

Number num1 = num.power(2); // 1/2^2 = 1/4
Number num2 = Equation.power(num, 2); //这里运算的结果与上面相等
     * </blockquote></pre>
     * @param index - int - 指数的大小
     * @return Number - 进行乘方运算后的结果
     * @see equation.Equation#power(Number, int)
     */
    public Number power(int index);

    /**
     * toDouble方法 - 将Number对象转化成double类型。
     * <p>您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>toDouble(Number num): double</code>函数。</p>
     * <blockquote><pre>
Number num = new Fraction(1, 2); //这里表示分数 1/2

double num1 = num.toDouble(); // 0.5
double num2 = Equation.toDouble(num); //这里运算的结果与上面相等
     * </blockquote></pre>
     * @return double - 转化后的小数
     * @see equation.Equation#power(Number, int)
     */
    public double toDouble();

    /**
     * toString方法 - 返回Number对象的字符串形式。
     * @return String - 转化后的字符串
     */
    public String toString();

    /**
     * equals方法 - 判断两个对象是否相等。需要注意的是，如果传入的对象不是Number，将永远返回false。
     * @param object - Object - 需要比较的对象
     * @return boolean - 是否相等
     */
    public boolean equals(Object object);

    /**
     * isGreaterThan方法 - 判断当前对象是否大于传入的Number对象。如果大于，返回true。否则返回false。
     * @param num - Number - 需要比较的对象
     * @return boolean - 是否大于
     * @see equation.Equation#compare(Number, Number)
     */
    public boolean isGreaterThan(Number num);

    /**
     * isLessThan方法 - 判断当前对象是否小于传入的Number对象。如果小于，返回true。否则返回false。
     * @param num - Number - 需要比较的对象
     * @return boolean - 是否小于
     * @see equation.Equation#compare(Number, Number)
     */
    public boolean isLessThan(Number num);
}
