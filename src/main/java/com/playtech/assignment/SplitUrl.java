package com.playtech.assignment;

import com.playtech.assignment.regex.event.RegexSplit;
import com.playtech.assignment.statemachine.StateEventSplit;

/**
 * The main method for starting the URL split process
 * 
 * @author Vipul Goswami
 *
 */

public class SplitUrl {
  /**
   * Main method an entry point
   * 
   * @param args
   * @throws Exception
   */
  public static void main(String[] args) throws Exception {

    try {
      // Checking the input length
      if (args == null || args.length == 0) {
        throw new NullPointerException("Please provide valid url in arguments");
      }
      final String url = args[0];


      // Creating the instance of the Regex Split
      SplitUrlEvent regExEvent = new RegexSplit(url);
      String executeTime1 = execute(regExEvent);
      SplitUrlEvent stateEvent = new StateEventSplit(url);
      String executeTime2 = execute(stateEvent);

      // Print the output
      System.out.println(regExEvent.getSplittedUrl());
      // Print the Regex total execution time
      System.out.println(executeTime1);

      // Print the State total execution time
      System.out.println(executeTime2);


    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * A method to process the split url event for 10,000 times
   * 
   * @param event
   * @return Total duration of the execution
   * @throws Exception
   */
  private static String execute(SplitUrlEvent event) throws Exception {
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      event.execute();
    }
    long endTime = System.currentTimeMillis();
    return String.format("%s: %s",
        event.getClass().getName().equals(
            com.playtech.assignment.regex.event.RegexSplit.class.getName()) ? "Regex" : "State",
        (endTime - startTime) * 0.001 + " s");

  }
}
