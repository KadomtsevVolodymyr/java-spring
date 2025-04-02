package com.volodymyrKadomtsev.auth.DTOs;

/**
 * AuthResponse
 */
public class AuthResponse {

  private String token;

  public AuthResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

}
