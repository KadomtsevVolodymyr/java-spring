package com.yievsieievAndrii.apiCarsharing.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import com.yievsieievAndrii.apiCarsharing.models.CollectionResponse;

/**
 * CarsharingApiController
 */
@RestController
@RequestMapping("/api/cars")
public class CarsharingApiController {

  private String base = "https://carapi.app/api/";

  @GetMapping("/models")
  public CollectionResponse getModels(
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

    CollectionResponse result = restClient.get()
        .uri(uriComponentsBuilder.toUriString())
        .retrieve()
        .body(CollectionResponse.class);

    return result;
  }

}
