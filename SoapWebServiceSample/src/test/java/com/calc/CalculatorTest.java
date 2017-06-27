package com.calc;

import org.junit.*;
import org.junit.Assert.*;

import static org.junit.Assert.*;

/**
 * Created by denys on 6/27/2017.
 */
public class CalculatorTest {
    //private int i;

    /*{}

    static{}

    public CalculatorTest() {
    }*/

    @BeforeClass
    public static void beforeClass(){
        System.out.println("BeforeClass!!!");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("AfterClass!!!");
    }


    @Before
    public void beforeEachTest(){
        System.out.println("@Before");
    }


    @After
    public void afterEachTest(){
        System.out.println("@After");
    }

    @Test
    public void addTest(){
      //  i++;
        System.out.println("addTest.hashCode="+hashCode());
        Calculator calculator = new CalculatorImpl();
        int res=calculator.add(1,2);
        //assert 1<2 : "Message";
        assertTrue("Incorrect sum", res==3);
        assertSame(res, 3);
    }

    @Test(expected = NullPointerException.class)
    public void errorTest(){
       // if(i>1){

       // }
        System.out.println("errorTest.hashCode="+hashCode());
        Calculator calculator = null;
        int res=calculator.add(1,2);
    }

    @Test
    public void errorTest1(){
        System.out.println("errorTest1.hashCode="+hashCode());
        //Calculator calculator = new CalculatorImpl();
        Calculator calculator = null;
        try {
            int res = calculator.add(1, 2);
            fail("Exception must be here");
        }catch(NullPointerException ex){

        }
    }

    @Ignore
    @Test(timeout = 5000)
    public void performanceTest(){
        System.out.println("performanceTest.hashCode="+hashCode());
        Calculator calculator = new CalculatorImpl();
        int res=calculator.add(1,2);
    }

    @Test
    public void bulkTest(){
        System.out.println("bulkTest.hashCode="+hashCode());
        addTest();
       // errorTest();
       // errorTest1();
        performanceTest();
    }

    /*@Test
    public static void just(){
        //  i++;
        Calculator calculator = new CalculatorImpl();
        int res=calculator.add(1,2);
        //assert 1<2 : "Message";
        assertTrue("Incorrect sum", res==3);
        assertSame(res, 3);
        //assertEquals();
    }*/


}
