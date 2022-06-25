# equation
一个功能精简的Java分数运算类库
## 一个十分简短的例子，带你轻松上手equation：
```java
Number num1 = new Fraction(1, 2); //这里表示分数 1/2
Number num2 = new Fraction(1, 3); //这里表示分数 1/3

Number num3 = num1.add(num2); // 1/2 + 1/3 = 5/6
Number num4 = num1.sub(num2); // 1/2 - 1/3 = 1/6
Number num5 = num1.mult(num2); // 1/2 * 1/3 = 1/6
Number num6 = num1.div(num2); // 1/2 / 1/3 = 3/2
Number num7 = num.power(2); // 1/2 ^ 2 = 1/4
```
## 复杂的四则混合运算？当然不在话下！
```java
Fraction frac = new Fraction(1, 2)
   .add(new Fraction(1, 3))
   .sub(new Fraction(1, 4))
   .power(3)
   .makeDenominatorChangeTo(24); // 14/24
```
## 甚至是比较大小？也可以！
```java
if(new Fraction(1, 2).isGreaterThan(newFraction(1, 3))) {
  System.out.println("1/2 > 1/3");
} //输出：1/2 > 1/3
```
## 为面向对象和函数式编程两种思想提供不同API，绝对用得顺手！
```java
AbstractRationalNumber num = new Fraction(1, 2); //这里表示分数 1/2
double num1 = num.toDouble(); //面向对象：得数为0.5
double num2 = Equation.toDouble(num); //函数式：这里运算的结果与上面相等
```
## 还等什么呢？
只需要在您的Java代码中添加一行`import equation.*;`，您就能拥有这一切！Have a try！
