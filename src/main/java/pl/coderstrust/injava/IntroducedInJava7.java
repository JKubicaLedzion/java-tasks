package pl.coderstrust.injava;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static java.util.Objects.isNull;

public class IntroducedInJava7 {

  // diamond Operator
  private List<String> list = new ArrayList<>();

  // try-with-resources
  // catch multiple exception
  public String readLines(String path) {
    String line = "";
    try (BufferedReader br = new BufferedReader(new FileReader(getFile(path)))) {
      checkIfFileReadable(path);
      if ((line = br.readLine()) != null) {
        list.add(line);
      }
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
    return line;
  }

  // allow String in switch statement
  public int selectAction(String choice) {
    System.out.println("Select action to be done on contact:");
    displayPossibleActions();
    switch (choice.toLowerCase()) {
      case "modify":
        System.out.println("Modifying ... ");
        return 1;
      case "delete":
        System.out.println("Deleting ... ");
        return 2;
      case "share":
        System.out.println("Sharing ... ");
        return 3;
      default:
        System.out.println("Action not choosen.");
        return 0;
    }
  }

  private void displayPossibleActions() {
    System.out.println("Modify - 1\n" + "Delete - 2\n" + "Share - 3");
  }

  // NIO 2
  private void checkIfFileReadable(String path) throws URISyntaxException {
    URL url = getClass().getClassLoader().getResource(path);
    Path file = Paths.get(url.toURI());
    if (!Files.isReadable(file)) {
      throw new NoSuchElementException("File is noreadable.");
    } else {
      System.out.println("File is readable.");
    }
  }

  private File getFile(String fileName) throws FileNotFoundException {
    URL url = getClass().getClassLoader().getResource(fileName);
    if (isNull(url)) {
      throw new FileNotFoundException("File: " + fileName + " not found.");
    }
    return new File(url.getFile());
  }
}
