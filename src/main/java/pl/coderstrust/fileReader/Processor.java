package pl.coderstrust.fileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Processor {

  private NumberProcessor numbersProcessor;
  private FileProcessor fileProcessor;

  public Processor(NumberProcessor numbersProcessor, FileProcessor fileProcessor) {
    this.numbersProcessor = numbersProcessor;
    this.fileProcessor = fileProcessor;
  }

  public void process(String fileName, String resultFileName) throws IOException {
    List<String> linesFromFile = fileProcessor.readLinesFromFile(fileName);

    List<String> resultLines = new ArrayList<>();
    for (String line : linesFromFile) {
      resultLines.add(numbersProcessor.processLine(line));
    }
    fileProcessor.writeLinesToFileUsingFile(resultLines, resultFileName);
  }
}
