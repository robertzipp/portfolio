package document;

import org.w3c.dom.Text;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElement;

public class BasicStringVisitor implements DocumentVisitor<String> {
  @Override
  public String visitBasicText(BasicText current) {
    return current.getText() + " ";
  }

  @Override
  public String visitBoldText(BoldText current) {
    return current.getText()+ " ";
  }

  @Override
  public String visitHeading(Heading current) {
    return current.getText()+ " ";
  }

  @Override
  public String visitHyperText(HyperText current) {
    return current.getText()+ " ";
  }

  @Override
  public String visitItalicText(ItalicText current) {
    return current.getText()+ " ";
  }

  @Override
  public String visitParagraph(Paragraph current) {
    return current.getText()+ " ";
  }
}
