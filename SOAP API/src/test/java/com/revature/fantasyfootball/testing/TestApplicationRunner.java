package com.revature.fantasyfootball.testing;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
 
public class TestApplicationRunner {
 
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);
 
        
        
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
 
         
        System.out.println("\nTest successful? " + result.wasSuccessful());
        System.out.println("\n\nSuccessfully completed " +  (result.getRunCount()-result.getFailureCount()) + " out of " + result.getRunCount() + " total test");
     
    }
}