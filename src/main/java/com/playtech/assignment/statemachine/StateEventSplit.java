package com.playtech.assignment.statemachine;

import java.net.URL;

import com.playtech.assignment.SplitUrlEvent;
import com.playtech.assignment.model.SplitURL;
import com.playtech.assignment.statemachine.events.StateEvent;
import com.playtech.assignment.statemachine.stateevent.StateEventListener;

public class StateEventSplit implements SplitUrlEvent {
  private String url;
  private SplitURL splitUrl;

  public StateEventSplit(String url) {
    this.url = url;
    splitUrl = new SplitURL();
  }

  public SplitURL getSplittedUrl() {
    return this.splitUrl;
  }

  @Override
  public void execute() throws Exception {

    // System.out.println("Processsing following url:" + this.url);
    if (url == null || url.isEmpty()) {
      throw new Exception("Please enter the valid URL");
    }
    URL urlData = new URL(url);

    for (StateEvent event : StateEvent.values()) {
      StateEventListener listener = StateEventFactory.getEvent(event);
      listener.stateEventChange(urlData, splitUrl);
    }

  }
}
