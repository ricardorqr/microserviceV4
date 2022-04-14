package com.microservice.fraud.swagger.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * FraudCheckDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-13T20:31:48.739864900-04:00[America/New_York]")
public class FraudCheckDTO   {

  @JsonProperty("isFraudster")
  private Boolean isFraudster;

  public FraudCheckDTO isFraudster(Boolean isFraudster) {
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
    FraudCheckDTO fraudCheckDTO = (FraudCheckDTO) o;
    return Objects.equals(this.isFraudster, fraudCheckDTO.isFraudster);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isFraudster);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FraudCheckDTO {\n");
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

