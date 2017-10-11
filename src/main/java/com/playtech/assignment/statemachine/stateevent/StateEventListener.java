package com.playtech.assignment.statemachine.stateevent;

import java.net.URL;

import com.playtech.assignment.model.SplitURL;


public interface StateEventListener {
  public void stateEventChange(URL url, SplitURL sUrl);
}
