package equation;

/**
 * AbstractRationalNumber - 所有与分数相关类的父类。
 * <p>
 * 这个类实现了所有Number接口的方法并且加上了更多分数相关的运算方法。例如：
 * <code>simplification(): void</code>（化简）、<code>makeDenominatorChangeTo(int index): void</code>（通分）等。
 * </p>
 * <blockquote><pre>
AbstractRationalNumber frac1 = new Fraction(1, 2); //这里表示分数 1/2
frac1.makeDenominatorChangeTo(4); // 2/4
frac1.simplification(); // 1/2
AbstractRationalNumber frac2 = new Fraction(0.5, 1.5); //自动化简后变成 1/3
frac2.add(frac1); // 5/6
 * </pre></blockquote>
 * @see equation.Equation
 * @see equation.Fraction
 */
public abstract class AbstractRationalNumber implements Number {
    /**
     * numerator属性 - 分数的分子。
     * <p>您可以使用与其对应的getter和setter方法来存取它的值。</p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(1, 2); // 1/2
int index = frac.getNumerator(); // 1
frac.setNumerator(3); // 3/2
     * </pre></blockquote>
     * @see equation.AbstractRationalNumber#getNumerator()
     * @see equation.AbstractRationalNumber#setNumerator()
     */
    protected int numerator;

    /**
     * denominator属性 - 分数的分母。
     * <p>您可以使用与其对应的getter和setter方法来存取它的值。</p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(1, 2); // 1/2
int index = frac.getDenominator(); // 2
frac.setDenominator(3); // 1/3
     * </pre></blockquote>
     * @see equation.AbstractRationalNumber#getDenominator()
     * @see equation.AbstractRationalNumber#setDenominator()
     */
    protected int denominator;

    /**
     * AbstractRationalNumber - 通过分子和分母创建AbstractRationalNumber对象。
     * @param numerator - int - 分数的分子
     * @param denominator - int - 分数的分母
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(int)
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(double)
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(double, double)
     */
    public AbstractRationalNumber(int numerator, int denominator) throws UnexpectValueException {
        super();
        if(denominator == 0) {
            throw new UnexpectValueException("不能将分母设置为0。");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * AbstractRationalNumber - 通过分子创建AbstractRationalNumber对象。
     * <p>注意：当不提供分母时，分母默认为1。</p>
     * @param numerator - int - 分数的分子
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(int, int)
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(double)
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(double, double)
     */
    public AbstractRationalNumber(int numerator) {
        this(numerator, 1);
    }

    /**
     * AbstractRationalNumber - 通过分子和分母创建AbstractRationalNumber对象。
     * <p>该构造函数会将传入的小数自动化为整数并化简。</p>
     * @param numerator - double - 分数的分子
     * @param denominator - double - 分数的分母
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(int, int)
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(int)
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(double)
     */
    public AbstractRationalNumber(double numerator, double denominator) throws UnexpectValueException {
        super();
        if(denominator == 0) {
            throw new UnexpectValueException("不能将分母设置为0。");
        }
        int index = findIndex(numerator, denominator);
        this.numerator = (int) (numerator * index);
        this.denominator  = (int) (denominator * index);
        simplification();
    }

    /**
     * AbstractRationalNumber - 通过分子创建AbstractRationalNumber对象。
     * <p>首先，该构造函数会将分母初始化为1（当前该分数为 n/1）；接着，该构造函数会将传入的小数自动化为整数并化简。</p>
     * @param numerator - double - 分数的分子
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(int, int)
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(int)
     * @see equation.AbstractRationalNumber#AbstractRationalNumber(double, double)
     */
    public AbstractRationalNumber(double numerator) {
        this(numerator, 1);
    }

    /**
     * getNumerator方法 - 获取分数的分子。
     * <p>您可以使用与其对应的setter方法来设置它的值。</p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(1, 2); // 1/2
int index = frac.getNumerator(); // 1
frac.setNumerator(3); // 3/2
     * </pre></blockquote>
     * @return int - 分数的分子
     * @see equation.AbstractRationalNumber#numerator
     * @see equation.AbstractRationalNumber#setNumerator(int)
     * @see equation.AbstractRationalNumber#setNumerator(double)
     */
    public int getNumerator() {
        return numerator;
    }

    /**
     * setNumerator方法 - 设置分数的分子。
     * <p>您可以使用与其对应的getter方法来获取它的值。</p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(1, 2); // 1/2
int index = frac.getNumerator(); // 1
frac.setNumerator(3); // 3/2
     * </pre></blockquote>
     * @param index - int - 分数的分子
     * @see equation.AbstractRationalNumber#numerator
     * @see equation.AbstractRationalNumber#setNumerator(double)
     * @see equation.AbstractRationalNumber#getNumerator()
     */
    public void setNumerator(int index) {
        numerator = index;
    }

    /**
     * setNumerator方法 - 设置分数的分子。
     * <p>注意，当传入的参数是小数时，会自动将小数化为整数并化简整个分数。</p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(1, 2); // 1/2
int index = frac.getNumerator(); // 1
frac.setNumerator(0.5); // 1/4
     * </pre></blockquote>
     * @param index - double - 分数的分子
     * @see equation.AbstractRationalNumber#numerator
     * @see equation.AbstractRationalNumber#setNumerator(int)
     * @see equation.AbstractRationalNumber#getNumerator()
     */
    public void setNumerator(double index) {
        int i = findIndex(index, denominator);
        numerator = (int) (index * i);
        denominator = denominator * i;
        simplification();
    }

    /**
     * getDenominator方法 - 获取分数的分母。
     * <p>您可以使用与其对应的setter方法来设置它的值。</p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(1, 2); // 1/2
int index = frac.getDenominator(); // 2
frac.setDenominator(3); // 1/3
     * </pre></blockquote>
     * @return int - 分数的分母
     * @see equation.AbstractRationalNumber#numerator
     * @see equation.AbstractRationalNumber#setDenominator(int)
     * @see equation.AbstractRationalNumber#setDenominator(double)
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * setDenominator方法 - 设置分数的分母。
     * <p>您可以使用与其对应的getter方法来获取它的值。</p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(1, 2); // 1/2
int index = frac.getDenominator(); // 2
frac.setDenominator(3); // 1/3
     * </pre></blockquote>
     * @param index - int - 分数的分母
     * @see equation.AbstractRationalNumber#numerator
     * @see equation.AbstractRationalNumber#setDenominator(double)
     * @see equation.AbstractRationalNumber#getDenominator()
     */
    public void setDenominator(int index) {
        denominator = index;
    }
        
    /**
     * setDenominator方法 - 设置分数的分母。
     * <p>注意，当传入的参数是小数时，会自动将小数化为整数并化简整个分数。</p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(1, 2); // 1/2
int index = frac.getDenominator(); // 2
frac.setDenominator(0.3); // 10/3
     * </pre></blockquote>
     * @param index - double - 分数的分母
     * @see equation.AbstractRationalNumber#numerator
     * @see equation.AbstractRationalNumber#setDenominator(int)
     * @see equation.AbstractRationalNumber#getDenominator()
     */
    public void setDenominator(double index) {
        int i = findIndex(numerator, index);
        numerator = numerator * i;
        denominator = (int) (index * i);
        simplification();
    }

    /**
     * makeDenominatorChangeTo方法 - 将分数通分至指定大小。
     * <p>请注意，传入的index参数是通分后分母的大小，而不是分子的大小。并且，当传入的参数不能使分子化成整数时，会强制通分。</p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(1, 2); //这里表示分数 1/2
frac.makeDenominatorChangeTo(4); // 2/4
     * </pre></blockquote>
     * <p>如果想要统一分子，请使用<code>makeNumeratorChangeTo(int index): void</code>或<code>makeNumeratorChangeTo(double index): void</code>方法。
     * @param index - int - 通分后分母的大小
     * @see equation.AbstractRationalNumber#makeNumeratorChangeTo(int)
     */
    public void makeDenominatorChangeTo(int index) {
        double times = index / denominator;
        double value = numerator * times;
        int i = findIndex(index, value);
        numerator = (int) (value * i);
        denominator = index * i;
    }

    /**
     * makeNumeratorChangeTo方法 - 将分数通分至指定大小。
     * <p>请注意，传入的index参数是通分后分子的大小，而不是分母的大小。并且，当传入的参数不能使分母化成整数时，会强制通分。</p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(1, 2); //这里表示分数 1/2
frac.makeNumeratorChangeTo(4); // 4/8
     * </pre></blockquote>
     * <p>如果想要统一分母，请使用<code>makeDenominatorChangeTo(int index): void</code>方法。
     * @param index - int - 通分后分母的大小
     * @see equation.AbstractRationalNumber#makeDenominatorChangeTo(int)
     */
    public void makeNumeratorChangeTo(int index) {
        double times = index / numerator;
        double value = denominator * times;
        int i = findIndex(index, value);
        denominator = (int) (value * i);
        numerator = index * i;
    }

    /**
     * simplification方法 - 化简当前分数。
     * <p>
     * 与四则运算类方法不同，该方法不会返回一个新的Number对象，而是直接在当前对象上做更改。
     * 如果不想改变当前对象，请使用Equation的<code>simplification(AbstractRationalNumber num): AbstractRationalNumber</code>方法。
     * </p>
     * <blockquote><pre>
AbstractRationalNumber frac = new Fraction(512, 1024); //这里表示分数 512/1024
frac.simplification(); //现在frac所表示的分数化简成为 1/2
     * </pre></blockquote>
     * @see equation.Equation#simplification(AbstractRationalNumber)
     */
    public void simplification() {
        int num = 0;
        int numerator = this.numerator;
        int denominator = this.denominator;
        while(numerator % denominator != 0) {
            num = numerator % denominator;
            numerator = denominator;
            denominator = num;
        }
        this.numerator = this.numerator / num;
        this.denominator = this.denominator / num;
    }

    /**
     * add方法 - 将两个Number对象相加。
     * <p>
     * 您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>add(Number num1, Number num2): Number</code>函数。
     * 请注意，该方法最后返回的结果实际上是一个Fraction对象。您可以使用造型转化它。
     * </p>
     * <blockquote><pre>
AbstractRationalNumber num1 = new Fraction(1, 2); //这里表示分数 1/2
AbstractRationalNumber num2 = new Fraction(1, 3); //这里表示分数 1/3
Fraction frac = (Fraction) (num1.add(num2)); // 1/2 + 1/3 = 5/6
     * </blockquote></pre>
     * @param num - Number - 需要相加的数
     * @return Number - 两个数相加的结果
     * @see equation.Equation#add(Number, Number)
     */
    public Number add(Number num) {
        Fraction frac = Equation.toFraction(num);
        int numerator = this.numerator * frac.getDenominator() + frac.getNumerator() * this.denominator;
        int denominator = this.denominator + frac.getDenominator();
        Fraction result = new Fraction(numerator, denominator);
        result.simplification();
        return result;
    }

    /**
     * sub方法 - 将两个Number对象相减。
     * <p>
     * 您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>sub(Number num1, Number num2): Number</code>函数。
     * 请注意，该方法最后返回的结果实际上是一个Fraction对象。您可以使用造型转化它。
     * </p>
     * <blockquote><pre>
AbstractRationalNumber num1 = new Fraction(1, 2); //这里表示分数 1/2
AbstractRationalNumber num2 = new Fraction(1, 3); //这里表示分数 1/3
Fraction frac = (Fraction) (num1.sub(num2)); // 1/2 - 1/3 = 1/6
     * </blockquote></pre>
     * @param num - Number - 需要相减的数
     * @return Number - 两个数相减的结果
     * @see equation.Equation#sub(Number, Number)
     */
    public Number sub(Number num) {
        Fraction frac = Equation.toFraction(num);
        int numerator = this.numerator * frac.getDenominator() - frac.getNumerator() * this.denominator;
        int denominator = this.denominator + frac.getDenominator();
        Fraction result = new Fraction(numerator, denominator);
        result.simplification();
        return result;
    }

    /**
     * mult方法 - 将两个Number对象相乘。
     * <p>
     * 您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>mult(Number num1, Number num2): Number</code>函数。
     * 请注意，该方法最后返回的结果实际上是一个Fraction对象。您可以使用造型转化它。
     * </p>
     * <blockquote><pre>
AbstractRationalNumber num1 = new Fraction(1, 2); //这里表示分数 1/2
AbstractRationalNumber num2 = new Fraction(1, 3); //这里表示分数 1/3
Fraction frac = (Fraction) (num1.mult(num2)); // 1/2 * 1/3 = 1/6
     * </blockquote></pre>
     * @param num - Number - 需要相乘的数
     * @return Number - 两个数相乘的结果
     * @see equation.Equation#mult(Number, Number)
     */
    public Number mult(Number num) {
        Fraction frac = Equation.toFraction(num);
        Fraction result = new Fraction(numerator * frac.getNumerator(), denominator * frac.getDenominator());
        result.simplification();
        return result;
    }

    /**
     * div方法 - 将两个Number对象相除。
     * <p>
     * 您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>div(Number num1, Number num2): Number</code>函数。
     * 请注意，该方法最后返回的结果实际上是一个Fraction对象。您可以使用造型转化它。
     * </p>
     * <blockquote><pre>
AbstractRationalNumber num1 = new Fraction(1, 2); //这里表示分数 1/2
AbstractRationalNumber num2 = new Fraction(1, 3); //这里表示分数 1/3
Fraction frac = (Fraction) (num1.div(num2)); // 1/2 / 1/3 = 3/2
     * </blockquote></pre>
     * @param num - Number - 需要相除的数
     * @return Number - 两个数相除的结果
     * @see equation.Equation#mult(Number, Number)
     */
    public Number div(Number num) {
        Fraction frac = Equation.toFraction(num);
        return mult(frac.reciprocalOf());
    }

    /**
     * power方法 - 对自身的幂运算。
     * <p>
     * 您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>power(Number num, int index): Number</code>函数。
     * 请注意，该方法最后返回的结果实际上是一个Fraction对象。您可以使用造型转化它。
     * </p>
     * <blockquote><pre>
AbstractRationalNumber num = new Fraction(1, 2); //这里表示分数 1/2

Fraction num1 = (Fraction) (num.power(2)); // 1/2^2 = 1/4
Fraction num2 = (Fraction) (Equation.power(num, 2)); //这里运算的结果与上面相等
     * </blockquote></pre>
     * @param index - int - 指数的大小
     * @return Number - 进行乘方运算后的结果
     * @see equation.Equation#power(Number, int)
     */
    public Number power(int index) {
        Fraction result = new Fraction(numerator, denominator);
        for(int i = 1; i < index; i++) {
            result = (Fraction) (result.mult(result));
        }
        return result;
    }

    /**
     * toDouble方法 - 将Number对象转化成double类型。
     * <p>您可以直接使用Number对象内置的方法，或者也可以使用Equation对象的静态<code>toDouble(Number num): double</code>函数。</p>
     * <blockquote><pre>
AbstractRationalNumber num = new Fraction(1, 2); //这里表示分数 1/2

double num1 = num.toDouble(); // 0.5
double num2 = Equation.toDouble(num); //这里运算的结果与上面相等
     * </blockquote></pre>
     * @return double - 转化后的小数
     * @see equation.Equation#power(Number, int)
     */
    public double toDouble() {
        return numerator / denominator;
    }

    /**
     * equals方法 - 判断两个对象是否相等。需要注意的是，如果传入的对象不是Number，将永远返回false。
     * @param object - Object - 需要比较的对象
     * @return boolean - 是否相等
     */
    public boolean equals(Object object) {
        if(!(object instanceof Number)) {
            return false;
        } else {
            Fraction num1 = new Fraction(numerator, denominator);
            Fraction num2 = Equation.toFraction((Number) object);
            try {
                num1.makeDenominatorChangeTo(num1.getDenominator() * num2.getDenominator());
                num2.makeDenominatorChangeTo(num1.getDenominator() * num2.getDenominator());
            } catch (UnexpectValueException err) {
                return false;
            }
            if(num1.getNumerator() == num2.getNumerator()) {
                return true;
            }
            return false;
        }
    }

    /**
     * isGreaterThan方法 - 判断当前对象是否大于传入的Number对象。如果大于，返回true。否则返回false。
     * @param num - Number - 需要比较的对象
     * @return boolean - 是否大于
     */
    public boolean isGreaterThan(Number num) {
        Fraction num1 = new Fraction(numerator, denominator);
        Fraction num2 = Equation.toFraction(num);
        try {
            num1.makeDenominatorChangeTo(num1.getDenominator() * num2.getDenominator());
            num2.makeDenominatorChangeTo(num1.getDenominator() * num2.getDenominator());
        } catch (UnexpectValueException err) {
            return false;
        }
        if(num1.getNumerator() > num2.getNumerator()) {
            return true;
        }
        return false;
    }

    /**
     * isLessThan方法 - 判断当前对象是否小于传入的Number对象。如果小于，返回true。否则返回false。
     * @param num - Number - 需要比较的对象
     * @return boolean - 是否小于
     */
    public boolean isLessThan(Number num) {
        Fraction num1 = new Fraction(numerator, denominator);
        Fraction num2 = Equation.toFraction(num);
        try {
            num1.makeDenominatorChangeTo(num1.getDenominator() * num2.getDenominator());
            num2.makeDenominatorChangeTo(num1.getDenominator() * num2.getDenominator());
        } catch (UnexpectValueException err) {
            return false;
        }
        if(num1.getNumerator() < num2.getNumerator()) {
            return true;
        }
        return false;
    }

    /**
     * findIndex方法 - 找到能让两个小数都变成整数的因数（index）。
     * <p>该方法永远返回一个大小为10^n的数。例如，传入的两个数为0.5和0.05，则会返回100。</p>
     * @param num1 - double - 第一个小数
     * @param num2 - double - 第二个小数
     * @return int - 能够使两个小数都变为整数的最小的能写成10^n形式的数
     */
    protected int findIndex(double num1, double num2) {
        if(isInteger(num1) && isInteger(num2)) {
            return 1;
        }
        int index1 = Double.toString(num1).length() - (Double.toString(num1).indexOf(".") + 1);
        int index2 = Double.toString(num2).length() - (Double.toString(num2).indexOf(".") + 1);
        int comp = index1 >= index2 ? index1 : index2;
        int index = 1;
        for(int i = 0; i < comp; i++) {
            index *= 10;
        }
        return index;
    }

    /**
	 * is Integer：判断传入的小数是否可以化为整数。
	 * @param num - double - 需要判断的小数。
	 * @return boolean - 是否可以化为整数
     */
    protected static boolean isInteger(double num) {
        if((int) num == num) {
            return true;
        }
        return false;
	}
}
