package pl.coderstrust.fileReader;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileProcessorTest {

  private static final String READ_LINES_PATH = "pl/coderstrust/fileReader/source_test.txt";
  private static final String WRITE_LINES_PATH =
      "src/test/resources/pl/coderstrust/fileReader/result_test.txt";
  @Rule public ExpectedException exception = ExpectedException.none();
  private FileProcessor fileProcessor = new FileProcessor();

  @Test
  public void readLinesFromFileWhenNoFileExceptionThrown() throws FileNotFoundException {
    exception.expect(FileNotFoundException.class);
    exception.expectMessage("File: test.txt not found.");
    fileProcessor.readLinesFromFile("test.txt");
  }

  @Test
  public void readLinesFromFileShouldReturnStringList()
      throws FileNotFoundException {
    List<String> result = fileProcessor.readLinesFromFile(READ_LINES_PATH);
    List<String> expectedResult = getSampleList();
    assertThat(result, is(expectedResult));
  }

  @Test
  public void writeLinesToFileUsingFileShouldReturnFile() throws IOException {
    List<String> source = getSampleList();
    fileProcessor.writeLinesToFileUsingFile(source, WRITE_LINES_PATH);

    Path path = Paths.get(WRITE_LINES_PATH);
    assertThat(Files.exists(path), is(true));

    List<String> result = getResult();
    assertThat(result, IsIterableContainingInOrder.contains("a b c d", "e f g h"));
  }

  private List<String> getSampleList() {
    List<String> expectedResult = new ArrayList<>();
    expectedResult.add("a b c d");
    expectedResult.add("e f g h");
    return expectedResult;
  }

  private List<String> getResult() throws FileNotFoundException {
    List<String> result = new ArrayList<>();
    try (Scanner sc = new Scanner(new File(WRITE_LINES_PATH))) {
      while (sc.hasNext()) {
        result.add(sc.nextLine());
      }
    }
    return result;
  }
}
