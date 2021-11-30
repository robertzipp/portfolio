import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;

import Model.HuffmanGenerator;

public class UserInterface {
  public static void main(String[] args) throws Exception {
    Scanner userInput = new Scanner(System.in);
    HuffmanGenerator model = new HuffmanGenerator();
    String huffmanInput = "";
    String radixInput = "";

    boolean finished = false;
    while (!finished) {
      System.out.println("Do you want to ENCODE or DECODE a string? DECODE only accepts " +
              " previously coded inputs");
      String option = userInput.nextLine();
      if (option.equals("DECODE")) {
        System.out.println("Ok, what do you want to decode?");
        String IO = userInput.nextLine();
        System.out.println("DECODED:" + model.decode(IO));
        finished = true;
      }
      if (option.equals("ENCODE")) {
        System.out.println("Read from FILE or COMMANDLINE?");
        String IO = userInput.nextLine();
        if (IO.equals("FILE")) {
          System.out.println("Please type the file path here:");
          String filePath = userInput.nextLine();
          File inputFile = new File(filePath);
          Scanner fileReader = new Scanner(inputFile);
          radixInput = fileReader.nextLine();
          huffmanInput = fileReader.nextLine();
        }

        if (IO.equals("COMMANDLINE")) {
          System.out.println("Okay, I can do that. What do you want to encode? Type it here:");
          huffmanInput = userInput.nextLine();
          System.out.println("Last step: Do you want it in HEX or BIN?");
          radixInput = (userInput.nextLine()); }

          model.setMode(radixInput);
          model.parseAndSetString(huffmanInput);
          model.loadQueue();
          model.processQueue();
          // need to build getter to protect var
          System.out.println(model.gOfA);

          System.out.println("Save result to file? YES or NO");
          String saveToFile = userInput.nextLine();
          if (saveToFile.equals("YES")) {
            File output = new File("huffmancode.txt");
            FileWriter fileWriter = new FileWriter("huffmancode.txt");
            fileWriter.write(huffmanInput + "code = " + model.buildCodedString(huffmanInput));
            fileWriter.close();
            System.out.println("File output successful");

          }
          else if (saveToFile.equals("NO")) {
            continue;
          }
          else {
            System.out.println("Command not recognized, try running the program again");
            finished = true;
          }

        }
      }

    }

}
