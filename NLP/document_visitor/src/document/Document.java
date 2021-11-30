package document;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


import document.elements.TextElement;

public class Document {

  private List<TextElement> content;

  // constructor
  public Document() {
    content = new ArrayList<>();
  }

  public void add(TextElement e) {
    content.add(e);
  }

  public int countWords(){
    int result = 0;
    WordCountVisitor wordCounter = new WordCountVisitor();
    for (TextElement e : this.getContent()) {
     result = result + e.accept(wordCounter);
    }
    return result;
  }

  public String toText(DocumentVisitor<String> visitor) {
    StringBuilder result = new StringBuilder();
    for (TextElement element : content)  {
      result.append(element.accept(visitor));
    }
    return result.toString();
  }


  public List<TextElement> getContent() {
    return content;
  }

  public void setContent(List<TextElement> content) {
    this.content = content;
  }
}