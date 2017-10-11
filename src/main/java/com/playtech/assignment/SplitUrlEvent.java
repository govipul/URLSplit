package com.playtech.assignment;

import com.playtech.assignment.model.SplitURL;

public interface SplitUrlEvent {
  public void execute() throws Exception;

  public SplitURL getSplittedUrl();
}
