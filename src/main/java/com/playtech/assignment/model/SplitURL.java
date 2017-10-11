package com.playtech.assignment.model;

public class SplitURL {
  private String scheme;
  private String domain;
  private String port;
  private String path;
  private String query;

  public SplitURL() {}

  public String getScheme() {
    return scheme;
  }

  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public String getPort() {
    return port;
  }

  public void setPort(String port) {
    this.port = port;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String queryString) {
    this.query = queryString;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("SCHEME:").append(scheme).append("\n");
    builder.append("DOMAIN:").append(domain).append("\n");
    builder.append("PORT:").append(port).append("\n");
    builder.append("PATH:").append(path).append("\n");
    builder.append("QUERY_STRING:").append(query).append("\n");
    return builder.toString();
  }
}
