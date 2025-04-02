package com.volodymyrKadomtsev.apiCarsharing.models.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volodymyrKadomtsev.apiCarsharing.models.MetadataResponse;

/**
 * CollectionsResponse
 */
public class ModelCollectionResponse {

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
