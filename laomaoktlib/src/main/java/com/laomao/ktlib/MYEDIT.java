package com.laomao.ktlib;

public enum MYEDIT {
    //    HOUR1("小时十进制","1"),
//    HOUR2("小时十进制","2"),
//    MIN1("小时十进制","3"),
//    MIN2("小时十进制","4");
    HOUR1(0, "HOUR1"),
    HOUR2(1, "HOUR1"),
    MIN1(2, "HOUR1"),
    MIN2(3, "HOUR1");

    private int index;
    private String text;
    public int getIndex()

    {
        return this.index;
    }

    MYEDIT(int i, String s) {
        this.index = i;
        this.text = s;
    }
}
