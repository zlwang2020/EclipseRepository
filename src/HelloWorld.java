import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Welcome to JAVA World!");
		System.out.println("Welcome to Github");
	}

	
	//Junit注解, before/after只能点test run as junit不然报错
    @Test
    public void testJunit(){
    	System.out.println("hello junit");
    }
    @Before
    public void testBefore(){
    	System.out.println("before");
    }
    @After
    public void testAfter(){
    	System.out.println("after");
    }

}
