package pl.coderstrust.fileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessorUsingStreams {

  public FileProcessorUsingStreams() {}

  public List<String> readLinesFromFile(String fileName) throws IOException, URISyntaxException {
    try (Stream<String> stream = Files.lines(getFile(fileName))) {
      return stream.collect(Collectors.toList());
    }
  }

  private Path getFile(String fileName) throws URISyntaxException, FileNotFoundException {
    return Paths.get(
        Optional.ofNullable(getClass().getClassLoader().getResource(fileName))
            .orElseThrow(() -> new FileNotFoundException("File: " + fileName + " not found."))
            .toURI());
  }

  public void writeLinesToFile(List<String> resultLines, String resultFileName) throws IOException {
    Files.write(
        Paths.get(resultFileName),
        resultLines.stream().filter(Objects::nonNull).collect(Collectors.toList()));
  }
}
