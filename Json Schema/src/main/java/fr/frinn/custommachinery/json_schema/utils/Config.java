package fr.frinn.custommachinery.json_schema.utils;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Config {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean input;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean output;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean enabled;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private SideMode top;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private SideMode bottom;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private SideMode front;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private SideMode right;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private SideMode back;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private SideMode left;
}
