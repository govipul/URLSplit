package com.playtech.assignment.statemachine.stateevent.impl;

import java.net.URL;

import com.playtech.assignment.model.SplitURL;
import com.playtech.assignment.statemachine.stateevent.StateEventListener;

public class SchemeStateEvent implements StateEventListener {

  @Override
  public void stateEventChange(URL url, SplitURL sUrl) {
    sUrl.setScheme(url.getProtocol());
  }

}
