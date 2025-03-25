package com.yievsieievAndrii.apiCarsharing.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CollectionsResponse
 */
public class CollectionResponse {

  @JsonProperty("collection")
  private MetadataResponse metadataResponse;

  @JsonProperty("data")
  private List<ModelData> modelData;

  public MetadataResponse getMetadataResponse() {
    return metadataResponse;
  }

  public void setMetadataResponse(MetadataResponse metadataResponse) {
    this.metadataResponse = metadataResponse;
  }
}
