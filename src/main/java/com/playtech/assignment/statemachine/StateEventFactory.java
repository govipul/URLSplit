package com.playtech.assignment.statemachine;

import com.playtech.assignment.statemachine.events.StateEvent;
import com.playtech.assignment.statemachine.stateevent.StateEventListener;
import com.playtech.assignment.statemachine.stateevent.impl.DomainStateEvent;
import com.playtech.assignment.statemachine.stateevent.impl.PathStateEvent;
import com.playtech.assignment.statemachine.stateevent.impl.PortStateEvent;
import com.playtech.assignment.statemachine.stateevent.impl.QueryStateEvent;
import com.playtech.assignment.statemachine.stateevent.impl.SchemeStateEvent;

public class StateEventFactory {
  public static StateEventListener getEvent(StateEvent event) {
    StateEventListener eventListner = null;
    switch (event) {
      case SCHEME:
        eventListner = new SchemeStateEvent();
        break;
      case DOMAIN:
        eventListner = new DomainStateEvent();
        break;
      case PATH:
        eventListner = new PathStateEvent();
        break;
      case QUERY:
        eventListner = new QueryStateEvent();
        break;
      case PORT:
        eventListner = new PortStateEvent();
        break;
    }

    return eventListner;
  }
}
