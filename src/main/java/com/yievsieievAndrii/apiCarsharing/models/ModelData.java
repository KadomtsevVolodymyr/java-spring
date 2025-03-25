
package com.yievsieievAndrii.apiCarsharing.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model
 */
public class ModelData {

  @JsonProperty("id")
  private int id;

  @JsonProperty("make_id")
  private int makeId;

  @JsonProperty("name")
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getMakeId() {
    return makeId;
  }

  public void setMakeId(int makeId) {
    this.makeId = makeId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
