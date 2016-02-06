package com.java.test;

@FunctionalInterface
interface I0{
	public void meth0();
}

@FunctionalInterface
interface I1{
	public void meth1(Implementor app);
}

@FunctionalInterface
interface I2{
	public void meth2(Implementor app1,Implementor app2);
}

class Implementor{
	int var=10;
	public int getVar() {
		return var;
	}
	public void setVar(int var) {
		this.var = var;
	}
	public Implementor() {
		System.out.println("Inside Constructor");
	}
	public void inst0(){System.out.println("inst0");}
	public void inst1(Implementor app){System.out.println(app.var);}
	public void inst2(Implementor app1,Implementor app2){System.out.println(app1.var+" "+app2.var);}
	
	public static void stat0() {System.out.println("stat0");}
    public static void stat1(Implementor app) {System.out.println(app.var);}
    public static void stat2(Implementor app1, Implementor app2) {System.out.println(app1.var+" "+app2.var);}
	
}
public class Application{
	public static void main(String[] args){
		Implementor obj=new Implementor();
		Implementor objj=new Implementor();
		obj.setVar(100);
		
		I0 iobj0=Implementor::stat0;
		iobj0.meth0();
		iobj0=obj::inst0;
		iobj0.meth0();
		iobj0=Implementor::new;
		iobj0.meth0();
		
		I1 iobj1=Implementor::stat1;
		iobj1.meth1(obj);
		iobj1=Implementor::inst0;
		iobj1.meth1(obj);
		iobj1=obj::inst1;
		iobj1.meth1(obj);
		
		I2 iobj2=Implementor::stat2;
		iobj2.meth2(obj,objj);
		iobj2=Implementor::inst1;
		iobj2.meth2(obj,objj);
		iobj2=obj::inst2;
		iobj2.meth2(obj,objj);
	}
}