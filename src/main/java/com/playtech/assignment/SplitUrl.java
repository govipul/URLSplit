package com.playtech.assignment;

import com.playtech.assignment.regex.event.RegexSplit;
import com.playtech.assignment.statemachine.StateEventSplit;

public class SplitUrl {
  public static void main(String[] args) throws Exception {

    try {
      if (args == null || args.length == 0) {
        throw new NullPointerException("Please provide valid url in arguments");
      }


      SplitUrlEvent regExEvent = new RegexSplit(args[0]);
      String executeTime1 = execute(regExEvent);
      SplitUrlEvent stateEvent = new StateEventSplit(args[0]);
      String executeTime2 = execute(stateEvent);

      System.out.println(regExEvent.getSplittedUrl());
      System.out.println(executeTime1);
      System.out.println(executeTime2);


    } catch (Exception e) {
      e.printStackTrace();
    }


  }

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
