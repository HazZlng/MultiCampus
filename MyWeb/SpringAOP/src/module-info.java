module SpringAOP {
	exports com.test02;
	exports com.test01;
	exports com.test03;

	requires org.aspectj.weaver;
	requires spring.aop;
	requires spring.beans;
	requires spring.context;
	requires spring.core;
}