package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

public interface DocumentVisitor<R> {
  
  public R visitBasicText(BasicText current);
  
  public R visitBoldText(BoldText current);

  public R visitHeading(Heading current);

  public R visitHyperText(HyperText current);

  public R visitItalicText(ItalicText current);

  public R visitParagraph(Paragraph current);
}
