package com.java.test;

interface F0 {
    void f0();
}
interface F1 {
    void f1(MetRef i1);
}
interface F2 {
    void f2(MetRef i1, MetRef i2);
}

class MetRef {
    public static void stat0() {;}
    public static void stat1(MetRef a) {;}
    public static void stat2(MetRef a, MetRef b) {;}

    public void inst0() {;}
    public void inst1(MetRef a) {;}
    public void inst2(MetRef a, MetRef b) {;}
}

public class Test {
    public static void main(String[] args) {
        final MetRef mr = new MetRef();

        final F0 mr01 = MetRef::stat0; // 1: f0() ~ MetRef.stat0() 
        final F0 mr02 = mr::inst0;     // 2: f0() ~ mr.inst0()
        final F0 mr04 = MetRef::new;   // 4: f0() ~ new MetRef()

        final F1 mr11 = MetRef::stat1; // 1: f1(i1) ~ MetRef.stat1(i1)
        final F1 mr12 = mr::inst1;     // 2: f1(i1) ~ mr.inst1(i1)
        final F1 mr13 = MetRef::inst0; // 3: f1(i1) ~ i1.inst0()       <== NOTICE!

        final F2 mr21 = MetRef::stat2; // 1: f2(i1, i2) ~ MetRef.stat2(i1, i2)
        final F2 mr22 = mr::inst2;     // 2: f2(i1, i2) ~ mr.inst2(i1, i2)
        final F2 mr23 = MetRef::inst1; // 3: f2(i1, i2) ~ i1.inst1(i2) <== NOTICE!
    }
}