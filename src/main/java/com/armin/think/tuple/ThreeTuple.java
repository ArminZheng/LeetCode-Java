package com.armin.think.tuple;

/**
 * ThreeTuple
 *
 * @author zy
 * @version 2022/4/9
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {

    public final C c;
    public final A a;

    public ThreeTuple(A a, B b, C c) {
        super(a, b);
        this.a = a;
        this.c = c;
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ')';
    }

    /**
     * 私有方法，隐含final关键字；只属于当前类。和表面上的继承的没有任何关系
     *
     * @return String
     */
    private String privateFinalMethod() {
        System.out.println(this.a);
        System.out.println(super.a);
        return "private final method can't override.";
    }
}
