package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;
import document.elements.TextElement;

public class HtmlStringVisitor implements DocumentVisitor<String> {
  @Override
  public String visitBasicText(BasicText current) {
    return current.getText() + "\n";
  }

  @Override
  public String visitBoldText(BoldText current) {
    return "<b>" + current.getText() + "</b>" + "\n";
  }

  @Override
  public String visitHeading(Heading current) {
    return "<h" + Integer.toString(current.getLevel()) + ">" + current.getText() +
            "</h" + Integer.toString(current.getLevel()) + ">" + "\n";
  }

  @Override
  public String visitHyperText(HyperText current) {
    return "<a href=" + current.getUrl() + ">" + current.getText() + "</a>" +
            "\n";
  }

  @Override
  public String visitItalicText(ItalicText current) {
    return "<i>" + current.getText() + "</i>" + "\n";
  }

  @Override
  public String visitParagraph(Paragraph current) {
    return current.getText();
  }
}
