package com.volodymyrKadomtsev.apiCarsharing.models.engine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volodymyrKadomtsev.apiCarsharing.models.MetadataResponse;

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
