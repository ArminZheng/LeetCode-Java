package com.armin.think.tuple;

/**
 * TwoTuple
 *
 * @author zy
 * @version 2022/4/9
 */
public class TwoTuple<A, B> {

    public final A a;
    public final B b;

    public TwoTuple(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ')';
    }

    /**
     * 私有方法，隐含final关键字；只属于当前类。和表面上的继承的没有任何关系
     *
     * @return String
     */
    private String privateFinalMethod() {
        return "private final method can't override.";
    }
}
