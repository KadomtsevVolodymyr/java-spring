package com.yievsieievAndrii.apiCarsharing.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.yievsieievAndrii.apiCarsharing.models.engine.EngineCollectionResponse;
import com.yievsieievAndrii.apiCarsharing.models.make.MakeCollectionResponse;
import com.yievsieievAndrii.apiCarsharing.models.model.ModelCollectionResponse;


/**
 * CarsharingApiController
 */
@RestController
@RequestMapping("/api/cars")
public class CarsharingApiController {

  private String base = "https://carapi.app/api/";

  @GetMapping("/models")
  public ModelCollectionResponse getModels(
      @RequestParam(required = false) Integer page,
      @RequestParam(required = false) String sort,
      @RequestParam(required = false) String direction) {

    RestClient restClient = RestClient.create();
    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(base + "/models");

    if (page != null) {
      uriComponentsBuilder.queryParam("page", page);
    }

    if (sort != null && !sort.isEmpty()) {
      uriComponentsBuilder.queryParam("sort", sort);
    }

    if (direction != null && !direction.isEmpty()) {
      uriComponentsBuilder.queryParam("direction", direction);
    }

    System.out.println(uriComponentsBuilder);

    ModelCollectionResponse result = restClient.get()
        .uri(uriComponentsBuilder.toUriString())
        .retrieve()
        .body(ModelCollectionResponse.class);

    return result;
  }


  @GetMapping("/engines")
  public EngineCollectionResponse getEngines(
      @RequestParam(required = false) Integer page,
      @RequestParam(required = false) Integer limit) {

    RestClient restClient = RestClient.create();
    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(base + "/engines");

    if (page != null) {
      uriComponentsBuilder.queryParam("page", page);
    }

    if (limit != null) {
      uriComponentsBuilder.queryParam("limit", limit);
    }

    System.out.println(uriComponentsBuilder);

    EngineCollectionResponse result = restClient.get()
        .uri(uriComponentsBuilder.toUriString())
        .retrieve()
        .body(EngineCollectionResponse.class);

    return result;
  }

  @GetMapping("/makes")
  public MakeCollectionResponse  getMakes(
      @RequestParam(required = false) Integer page,
      @RequestParam(required = false) Integer limit) {

    RestClient restClient = RestClient.create();
    UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(base + "/makes");

    if (page != null) {
      uriComponentsBuilder.queryParam("page", page);
    }

    if (limit != null) {
      uriComponentsBuilder.queryParam("limit", limit);
    }

    System.out.println(uriComponentsBuilder);

    MakeCollectionResponse result = restClient.get()
        .uri(uriComponentsBuilder.toUriString())
        .retrieve()
        .body(MakeCollectionResponse.class);

    return result;
  }

}
