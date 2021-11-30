import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.Assert;

import Model.HuffmanGenerator;

/** 
* HuffmanGenerator Tester. 
* 
* @author <Authors name> 
* @since <pre>Nov 12, 2020</pre> 
* @version 1.0 
*/ 
public class HuffmanGeneratorTest { 


/** 
* 
* Method: setMode(String mode) 
* 
*/ 
@Test
public void testSetMode() throws Exception {
    HuffmanGenerator test = new HuffmanGenerator();
    test.parseAndSetString("ariana grande released a new album");
    test.loadQueue();
    test.setMode("HEX");
    test.processQueue();
    // TODO:
    //Assert.assertEquals();
} 

/** 
* 
* Method: parseAndSetString(String input) 
* 
*/ 
@Test
public void testParseAndSetString() throws Exception {
    HuffmanGenerator test = new HuffmanGenerator();
    test.parseAndSetString("ariana grande released a new album");
    // if it doesn't crash, the test passed
} 

/** 
* 
* Method: loadQueue() 
* 
*/ 
@Test
public void testLoadQueue() throws Exception {
    HuffmanGenerator test = new HuffmanGenerator();
    test.parseAndSetString("ariana grande released a new album");
    test.loadQueue();
    // if it doesn't crash, the test passed
;
} 

/** 
* 
* Method: processQueue() 
* 
*/ 
@Test
public void testProcessQueue() throws Exception {
    HuffmanGenerator test = new HuffmanGenerator();
    String input = "ariana grande released a new album";
    test.parseAndSetString(input);
    test.loadQueue();
    test.processQueue();
    Assert.assertEquals("10000000011001111001101111100010011110011010110001" +
            "01010010110100011011001011100110111101111000" +
            "111001001111110110001111", test.buildCodedString(input));

}
    /**
     *
     * Method: testBuildCodedString()
     *
     */
@Test
public void testBuildCodedString() throws Exception {
    String input = "ariana grande released a new album";
    HuffmanGenerator test = new HuffmanGenerator();
    test.parseAndSetString(input);
    test.loadQueue();
    test.processQueue();
    System.out.println(test.buildCodedString(input));
    test.setMode("HEX");
    test.processQueue();
    System.out.println(test.buildCodedString(input));
    Assert.assertEquals("20127231f027953054521159323751c3243fcf",
            test.buildCodedString(input));
}
/** 
* 
* Method: decode() 
* 
*/ 
@Test
public void testDecode() throws Exception {
    String input = "ariana grande released a new album";
    HuffmanGenerator test = new HuffmanGenerator();
    test.parseAndSetString(input);
    test.loadQueue();
    test.processQueue();
    String coded = test.buildCodedString(input);
    Assert.assertEquals(input, test.decode(coded));
}




} 
