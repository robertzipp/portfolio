package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

public class MarkdownStringVisitor implements DocumentVisitor<String> {
  @Override
  public String visitBasicText(BasicText current) {
    return current.getText() + "\n";
  }

  @Override
  public String visitBoldText(BoldText current) {
    return "**" + current.getText() + "**" + "\n";
  }

  @Override
  public String visitHeading(Heading current) {
    int level = current.getLevel();
    switch (level) {
      case 1: {
        return "# " + current.getText() + "\n";
      }
      case 2: {
        return "## " + current.getText() + "\n";
      }
      case 3: {
        return "### " + current.getText() + "\n";
      }
      default: {
        throw new IllegalArgumentException("The heading level of this item is invalid or" +
                " unsupported.");
      }
    }
  }

  @Override
  public String visitHyperText(HyperText current) {
    return "[" + current.getText() + "]" + "(" + current.getUrl() + ")" + "\n";
  }

  @Override
  public String visitItalicText(ItalicText current) {
    return "*" + current.getText() + "*"  + "\n";
  }

  @Override
  public String visitParagraph(Paragraph current) {
    return current.getText() + "<br/>";
  }
}
