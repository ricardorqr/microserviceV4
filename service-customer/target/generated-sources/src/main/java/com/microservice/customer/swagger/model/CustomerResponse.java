package com.microservice.customer.swagger.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microservice.customer.swagger.model.CustomerDTO;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * A customer response
 */

@Schema(name = "CustomerResponse", description = "A customer response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CustomerResponse   {

  @JsonProperty("message")
  private String message;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("email")
  private String email;

  public CustomerResponse message(String message) {
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

  public CustomerResponse firstName(String firstName) {
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

  public CustomerResponse lastName(String lastName) {
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

  public CustomerResponse email(String email) {
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
    CustomerResponse customerResponse = (CustomerResponse) o;
    return Objects.equals(this.message, customerResponse.message) &&
        Objects.equals(this.firstName, customerResponse.firstName) &&
        Objects.equals(this.lastName, customerResponse.lastName) &&
        Objects.equals(this.email, customerResponse.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, firstName, lastName, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerResponse {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
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

