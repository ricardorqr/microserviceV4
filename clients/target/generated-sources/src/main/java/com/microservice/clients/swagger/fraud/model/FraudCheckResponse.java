package com.microservice.clients.swagger.fraud.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microservice.clients.swagger.fraud.model.FraudCheckDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Fraud-check response
 */

@Schema(name = "FraudCheckResponse", description = "Fraud-check response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class FraudCheckResponse   {

  @JsonProperty("message")
  private String message;

  @JsonProperty("isFraudster")
  private Boolean isFraudster;

  public FraudCheckResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Details about the response
   * @return message
  */
  @NotNull 
  @Schema(name = "message", example = "Example of message", description = "Details about the response", required = true)
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public FraudCheckResponse isFraudster(Boolean isFraudster) {
    this.isFraudster = isFraudster;
    return this;
  }

  /**
   * Check if the user is a fraudster
   * @return isFraudster
  */
  @NotNull 
  @Schema(name = "isFraudster", example = "true", description = "Check if the user is a fraudster", required = true)
  public Boolean getIsFraudster() {
    return isFraudster;
  }

  public void setIsFraudster(Boolean isFraudster) {
    this.isFraudster = isFraudster;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FraudCheckResponse fraudCheckResponse = (FraudCheckResponse) o;
    return Objects.equals(this.message, fraudCheckResponse.message) &&
        Objects.equals(this.isFraudster, fraudCheckResponse.isFraudster);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, isFraudster);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudCheckResponse {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    isFraudster: ").append(toIndentedString(isFraudster)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

