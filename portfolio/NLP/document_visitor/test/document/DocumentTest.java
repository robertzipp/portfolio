package document; 

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.w3c.dom.Text;

import java.nio.file.attribute.BasicFileAttributes;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.TextElement;

/** 
* Document Tester. 
* 
* @author <Authors name> 
* @since <pre>Feb 13, 2021</pre> 
* @version 1.0 
*/ 
public class DocumentTest { 


/** 
* 
* Method: add(TextElement e) 
* 
*/ 
@Test
public void testAdd() throws Exception {

} 

/** 
* 
* Method: countWords() 
* 
*/ 
@Test
public void testCountWords() throws Exception {
  Document testDoc = new Document();
  testDoc.add(new BoldText("Entertainment"));
  testDoc.add(new HyperText("Watch your favorite show on Netflix", "www.netflix.com"));
  testDoc.add(new Heading("Wandavision", 2));
  testDoc.add(new ItalicText("Exit"));
  int result = testDoc.countWords();
  Assert.assertEquals(4, result);
} 

/**
*
* Method: toText w/ BasicStringVisitor
*
*/
@Test
public void TestToBasicText() throws Exception {

  Document testDoc = new Document();
  DocumentVisitor<String> visitor = new BasicStringVisitor();
  testDoc.add(new BasicText("Hello"));
  testDoc.add(new BasicText("Good bye"));
  System.out.println(testDoc.toText(visitor));
  System.out.println();

  }

  /**
   *
   * Method: toText w/ HTMLStringVisitor
   *
   */
  @Test
  public void testToHTML() throws Exception {

    Document testDoc = new Document();
    DocumentVisitor<String> visitor = new HtmlStringVisitor();
    testDoc.add(new BoldText("Entertainment"));
    testDoc.add(new HyperText("Watch your favorite show on Netflix", "www.netflix.com"));
    testDoc.add(new Heading("Wandavision", 2));
    testDoc.add(new ItalicText("Exit"));
    System.out.println(testDoc.toText(visitor));

  }

  /**
   *
   * Method: toText w/ MarkdownStringVisitor
   *
   */
  @Test
  public void testMarkdownStringVisitor() throws Exception {

    Document testDoc = new Document();
    DocumentVisitor<String> visitor = new MarkdownStringVisitor();
    testDoc.add(new BoldText("Entertainment"));
    testDoc.add(new HyperText("Watch your favorite show on Netflix", "www.netflix.com"));
    testDoc.add(new Heading("Wandavision", 2));
    testDoc.add(new ItalicText("Exit"));
    System.out.println(testDoc.toText(visitor));

  }

} 
