package com.playtech.assignment.regex.event;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.playtech.assignment.SplitUrlEvent;
import com.playtech.assignment.model.SplitURL;

public class RegexSplit implements SplitUrlEvent {

  private String url;
  private SplitURL splitUrl;
  /**
   * A regular expression for matching the URL Ref: https://tools.ietf.org/html/rfc3986#appendix-B
   */
  private final static String urlPattern =
      "^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\\?([^#]*)?)?(#(.*))?";

  // Ref: https://tools.ietf.org/html/rfc3986#appendix-B
  // ^(([^:/?#]+):)?(//([^/?#]*))?([^?#]*)(\?([^#]*))?(#(.*))?
  // 12 3 4 5 6 7 8 9

  // $1 = http:
  // $2 = http
  // $3 = //www.ics.uci.edu
  // $4 = www.ics.uci.edu
  // $5 = /pub/ietf/uri/
  // $6 = <undefined>
  // $7 = <undefined>
  // $8 = #Related
  // $9 = Related
  public RegexSplit(String url) {
    this.url = url;
    splitUrl = new SplitURL();
  }

  public SplitURL getSplittedUrl() {
    return this.splitUrl;
  }

  @Override
  public void execute() throws Exception {
    if (url == null || url.isEmpty()) {
      throw new Exception("Please enter the valid URL");
    }
    Pattern pattern = Pattern.compile(urlPattern);
    Matcher matcher = pattern.matcher(url);

    matcher.find();

    splitUrl.setScheme(matcher.group(2));
    String domain = matcher.group(4);
    splitUrl.setDomain(domain.contains(":") ? domain.split(":")[0] : domain);
    splitUrl.setPort(domain.contains(":") ? domain.split(":")[1] : null);
    splitUrl.setPath(matcher.group(5));
    splitUrl.setQuery(matcher.group(7));
  }

}
