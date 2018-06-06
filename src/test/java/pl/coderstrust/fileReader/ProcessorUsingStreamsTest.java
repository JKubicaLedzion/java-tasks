package pl.coderstrust.fileReader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProcessorUsingStreamsTest {

  private static final String INPUT = "1 2 3";
  private static final String OUTPUT = "1 + 2 + 3 = 6";
  private static final String INPUT_FILE = "output.txt";
  private static final String OUTPUT_FILE = "input.txt";

  @Mock NumberProcessorUsingStreams numbersProcessor;

  @Mock FileProcessorUsingStreams fileProcessor;

  @InjectMocks ProcessorUsingStreams processor;

  @Test
  public void process() throws IOException, URISyntaxException {
    //  given
    when(fileProcessor.readLinesFromFile(INPUT_FILE)).thenReturn(Arrays.asList(INPUT));
    when(numbersProcessor.processLine(INPUT)).thenReturn(OUTPUT);
    doNothing().when(fileProcessor).writeLinesToFile(Arrays.asList(OUTPUT), OUTPUT_FILE);

    // when
    processor.process(INPUT_FILE, OUTPUT_FILE);

    // then
    verify(fileProcessor, times(1)).readLinesFromFile(INPUT_FILE);
    verify(numbersProcessor, times(1)).processLine(INPUT);
    verify(fileProcessor).writeLinesToFile(Arrays.asList(OUTPUT), OUTPUT_FILE);
  }

  @Test
  public void processArgumentValuesVerificationWithArgumentCapture()
      throws IOException, URISyntaxException {
    ArgumentCaptor<String> argumentString = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<ArrayList> argumentList = ArgumentCaptor.forClass(ArrayList.class);

    //  given
    when(fileProcessor.readLinesFromFile(INPUT_FILE)).thenReturn(Arrays.asList(INPUT));
    when(numbersProcessor.processLine(INPUT)).thenReturn(OUTPUT);
    doNothing().when(fileProcessor).writeLinesToFile(Arrays.asList(OUTPUT), OUTPUT_FILE);

    // when
    processor.process(INPUT_FILE, OUTPUT_FILE);

    // then
    verify(fileProcessor, times(1)).readLinesFromFile(argumentString.capture());
    assertThat(INPUT_FILE, is(argumentString.getValue()));

    verify(numbersProcessor, times(1)).processLine(argumentString.capture());
    assertThat(INPUT, is(argumentString.getValue()));

    verify(fileProcessor).writeLinesToFile(argumentList.capture(), argumentString.capture());
    assertThat(OUTPUT_FILE, is(argumentString.getValue()));
    assertThat(Arrays.asList(OUTPUT), is(argumentList.getValue()));
  }
}
