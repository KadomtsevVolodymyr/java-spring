package com.volodymyrKadomtsev.apiCarsharing.models.make;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.volodymyrKadomtsev.apiCarsharing.models.MetadataResponse;

public class MakeCollectionResponse {

  @JsonProperty("collection")
  private MetadataResponse metadataResponse;

  @JsonProperty("data")
  private List<MakeData> modelData;

  public MetadataResponse getMetadataResponse() {
    return metadataResponse;
  }

  public void setMetadataResponse(MetadataResponse metadataResponse) {
    this.metadataResponse = metadataResponse;
  }
}
