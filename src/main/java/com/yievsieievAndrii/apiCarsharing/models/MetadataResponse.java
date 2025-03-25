package com.yievsieievAndrii.apiCarsharing.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CollectionResponse
 */
public class MetadataResponse {

  @JsonProperty("url")
  private String url;

  @JsonProperty("count")
  private int count;

  @JsonProperty("pages")
  private int pages;

  @JsonProperty("total")
  private int total;

  @JsonProperty("next")
  private String next;

  @JsonProperty("prev")
  private String prev;

  @JsonProperty("first")
  private String first;

  @JsonProperty("last")
  private String last;


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getPages() {
    return pages;
  }

  public void setPages(int pages) {
    this.pages = pages;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public String getNext() {
    return next;
  }

  public void setNext(String next) {
    this.next = next;
  }

  public String getPrev() {
    return prev;
  }

  public void setPrev(String prev) {
    this.prev = prev;
  }

  public String getFirst() {
    return first;
  }

  public void setFirst(String first) {
    this.first = first;
  }

  public String getLast() {
    return last;
  }

  public void setLast(String last) {
    this.last = last;
  }


}
