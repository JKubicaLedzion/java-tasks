package pl.coderstrust.fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class FileProcessor {

  public FileProcessor() {}

  public List<String> readLinesFromFile(String fileName) throws FileNotFoundException {
    List<String> linesFromFile = new ArrayList<>();
    try (Scanner sc = new Scanner(getFile(fileName))) {
      while (sc.hasNext()) {
        linesFromFile.add(sc.nextLine());
      }
    }
    return linesFromFile;
  }

  private File getFile(String fileName) throws FileNotFoundException {
    URL url = getClass().getClassLoader().getResource(fileName);
    if (isNull(url)) {
      throw new FileNotFoundException("File: " + fileName + " not found.");
    }
    return new File(url.getFile());
  }

  public void writeLinesToFileUsingFile(List<String> resultLines, String resultFileName) throws IOException {
    List<String> result = resultLines.stream()
        .filter(Objects::nonNull)
        .collect(Collectors.toList());
    Path file = Paths.get(resultFileName);
    Files.write(file, result);
  }

  //  Alternative option using FileWriter.
  public void writeLinesToFileUsingFileWriter(List<String> resultLines, String resultFileName)
      throws IOException {
    try (FileWriter fw = new FileWriter(new File(resultFileName))) {
      List<String> result = resultLines.stream()
          .filter(Objects::nonNull)
          .collect(Collectors.toList());
      for (int i = 0; i < result.size(); i++) {
        fw.write(result.get(i));
        fw.write(System.getProperty("line.separator"));
      }
    }
  }
}
