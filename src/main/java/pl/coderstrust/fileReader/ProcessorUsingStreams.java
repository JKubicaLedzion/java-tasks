package pl.coderstrust.fileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Collectors;

public class ProcessorUsingStreams {

  private NumberProcessorUsingStreams numbersProcessor;
  private FileProcessorUsingStreams fileProcessor;

  public ProcessorUsingStreams(
      NumberProcessorUsingStreams numbersProcessor, FileProcessorUsingStreams fileProcessor) {
    this.numbersProcessor = numbersProcessor;
    this.fileProcessor = fileProcessor;
  }

  public void process(String fileName, String resultFileName)
      throws IOException, URISyntaxException {
    fileProcessor.writeLinesToFile(
        fileProcessor
            .readLinesFromFile(fileName)
            .stream()
            .filter(line -> line.matches("[0-9\\s]+"))
            .map(numbersProcessor::processLine)
            .collect(Collectors.toList()),
        resultFileName);
  }
}
