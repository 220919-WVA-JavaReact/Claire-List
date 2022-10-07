package com.revature;
import org.junit.*;
import com.revature.CodingChallenge;
public class ChallengeTest {




    public String str1 = "1";
    public String str2 = "I am string 2";

    static CodingChallenge chal;

    //set up what should happen before each test...
//    @BeforeClass
//    public static void setUpBeforeClass(){
//        System.out.println("This runs before the entire class but only once");
//        chal = new CodingChallenge();
//    }

    @Test
    public void returnsString(){
        System.out.println("Returns a value of type string");
        Assert.assertTrue(str1 != null); //
    }

    @Test
    public void returnsExpectedValue(){
        System.out.println("Returns the expected value.");

    }

}
