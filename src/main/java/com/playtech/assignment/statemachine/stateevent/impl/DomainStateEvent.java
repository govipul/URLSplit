package com.playtech.assignment.statemachine.stateevent.impl;

import java.net.URL;

import com.playtech.assignment.model.SplitURL;
import com.playtech.assignment.statemachine.stateevent.StateEventListener;

public class DomainStateEvent implements StateEventListener {

  @Override
  public void stateEventChange(URL url, SplitURL sUrl) {
    sUrl.setDomain(url.getHost());
  }

}
