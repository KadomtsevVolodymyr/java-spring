package com.yievsieievAndrii.apiCarsharing.models.engine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yievsieievAndrii.apiCarsharing.models.MetadataResponse;

public class EngineCollectionResponse {

  @JsonProperty("collection")
  private MetadataResponse metadataResponse;


  @JsonProperty("data")
  private List<EngineData> modelData;

  public MetadataResponse getMetadataResponse() {
    return metadataResponse;
  }

  public void setMetadataResponse(MetadataResponse metadataResponse) {
    this.metadataResponse = metadataResponse;
  }
}
