package Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * HuffmanGenerator Model class. Contains algorithms for processing Huffman encodings.
 *
 * @author <Robert Zipp>
 * @since <pre>October 2020</pre>
 * @version 1.0
 */

public class HuffmanGenerator {

  /** Custom Pair class to handle sets of values in huffman queue processing */
  class Pair implements Comparable<Pair> {
    protected int pairInt;
    protected String pairString;

    Pair(int object1, String secondObject) {
      this.pairInt = object1;
      this.pairString = secondObject;
    }

    @Override
    public int compareTo(Pair o) {
      return Integer.compare(this.pairInt, o.pairInt);
    }
  }

/**  QueueForProcessing */

  private PriorityQueue<Pair> huffmanQueue;

/** Table data structures */
  public HashMap<Character, String> gOfA;
  private ArrayList<Character> a;
  private HashMap<Character, Integer> fOfA;

/** Data storage vars */
  private HashMap<String, String> storedCodes;
  private int sizeMode;

  public HuffmanGenerator() {
    this.fOfA = new HashMap<Character, Integer>();
    this.gOfA = new HashMap<Character, String>();
    this.a = new ArrayList<Character>();
    this.huffmanQueue = new PriorityQueue<Pair>();
    this.storedCodes = new HashMap<>();

  }

  public void setMode(String mode) {
    if (mode == "BIN")
      this.sizeMode = 2;
    if (mode == "HEX")
      this.sizeMode = 16;
  }

  /** Processes a string into a char array and loads it into corresponding data structures
   * for encoding algorithms.
   * gOfA = the huffman code strings themselves
   * a = list of chars
   * fOfA = chars and their frequencies in the input string */

  public void parseAndSetString(String input) {
    char[] preProcessed = input.toCharArray();
    for (char c : preProcessed) {
      if (!fOfA.containsKey(c)) {
        fOfA.put(c, 1);
        gOfA.put(c, "");
        a.add(c);
      } else if (fOfA.containsKey(c)) {
        int temp = fOfA.remove(c);
        temp++;
        fOfA.put(c, temp);
      }
    }

  }

  /** Helper function to set up priority queue for Huffman encoding*/
  public void loadQueue() {
    HashMap<Character, Integer> placeHolder;
    int counter = 0;
    for (Character c : a) {
      this.huffmanQueue.add(new Pair(this.fOfA.get(c), Character.toString(c)));
    }
  }

  /** Processes queue from loadQueue() until all chunks have been processed
   * into complete encoding.
   * All encodings are originally processed in binary - converted to hex if needed */

  public void processQueue() {
    while (this.huffmanQueue.size() > 1) {
      Pair x = this.huffmanQueue.poll();
      for (char c : x.pairString.toCharArray()) {
        String tempStr = this.gOfA.remove(c);
        tempStr = tempStr + "0";
        this.gOfA.put(c, tempStr);
      }
      Pair y = this.huffmanQueue.poll();
      for (char c : y.pairString.toCharArray()) {
        String tempStr = this.gOfA.remove(c);
        tempStr = tempStr + "1";
        this.gOfA.put(c, tempStr);
      }
      Pair combination = new Pair((x.pairInt + y.pairInt), (x.pairString + y.pairString));
      this.huffmanQueue.add(combination);
    }
    if (this.sizeMode == 16) {
      for (Character c : a) {
        String tempStr = this.gOfA.get(c);
        Integer bin = Integer.parseInt(tempStr, 2);
        String hex = Integer.toString(bin, 16);
        this.gOfA.put(c, hex);
      }
    }

  }

  /** Returns completed string of the huffman encoding */
  public String buildCodedString(String input) {
    String result = "";
    char[] inputArray = input.toCharArray();
    for (char c : inputArray) {
      result = result + this.gOfA.get(c);
    }
    this.storedCodes.put(result, input);
    return result;
  }

/** based on the constraints of Huffman encodings, this function can only return previously
 * encoded strings. It is not possible to guarantee the correct String is returned without
 * stored values. */
  public String decode(String codedInput) throws Exception {
    String result = "";
    if (this.storedCodes.containsKey(codedInput)) {
      return this.storedCodes.get(codedInput);
    }
    else return "not found";
  }

}
