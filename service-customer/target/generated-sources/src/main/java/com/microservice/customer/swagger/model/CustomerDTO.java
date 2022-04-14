package com.microservice.customer.swagger.model;

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
 * CustomerDTO
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-13T20:32:55.070120900-04:00[America/New_York]")
public class CustomerDTO   {

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("email")
  private String email;

  public CustomerDTO firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name of the customer
   * @return firstName
  */
  @Size(min = 5, max = 256) 
  @Schema(name = "firstName", example = "Ricardo", description = "First name of the customer", required = false)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CustomerDTO lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name of the customer
   * @return lastName
  */
  @Size(min = 5, max = 256) 
  @Schema(name = "lastName", example = "Ribeiro", description = "Last name of the customer", required = false)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public CustomerDTO email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email of the customer
   * @return email
  */
  @Size(min = 5, max = 256) 
  @Schema(name = "email", example = "ricardo@gmail.com", description = "Email of the customer", required = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDTO customerDTO = (CustomerDTO) o;
    return Objects.equals(this.firstName, customerDTO.firstName) &&
        Objects.equals(this.lastName, customerDTO.lastName) &&
        Objects.equals(this.email, customerDTO.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerDTO {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

