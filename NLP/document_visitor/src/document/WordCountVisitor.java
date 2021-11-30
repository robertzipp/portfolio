package document;

import document.elements.BasicText;
import document.elements.BoldText;
import document.elements.Heading;
import document.elements.HyperText;
import document.elements.ItalicText;
import document.elements.Paragraph;

public class WordCountVisitor implements DocumentVisitor<Integer> {

  @Override
  public Integer visitBasicText(BasicText current) {
    return 1;
  }

  @Override
  public Integer visitBoldText(BoldText current) {
    return 1;
  }

  @Override
  public Integer visitHeading(Heading current) {
    return 1;
  }

  @Override
  public Integer visitHyperText(HyperText current) {
    return 1;
  }

  @Override
  public Integer visitItalicText(ItalicText current) {
    return 1;
  }

  @Override
  public Integer visitParagraph(Paragraph current) {
    int result = 0;
    for (BasicText e : current.getContent()) {
      result++;
    }
    return result;
  }
}
