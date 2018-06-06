package pl.coderstrust.fileReader;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

  public static void main(String[] args) {

    ProcessorUsingStreams processor =
        new ProcessorUsingStreams(
            new NumberProcessorUsingStreams(), new FileProcessorUsingStreams());
    try {
      processor.process(
          "src/main/resources/pl/coderstrust/fileReader/1000.txt",
          "src/main/resources/pl/coderstrust/fileReader/result.txt");
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }
  }
}
