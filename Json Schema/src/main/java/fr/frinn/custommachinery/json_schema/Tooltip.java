package fr.frinn.custommachinery.json_schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import jakarta.validation.constraints.Pattern;

public class Tooltip {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private String text;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean bold;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean italic;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean underlined;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean strikethrough;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean obfuscated;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Pattern(regexp = Init.RL)
  private String font;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonSubTypes({
    @JsonSubTypes.Type(String.class),
    @JsonSubTypes.Type(int.class)
  })
  private String color;
}
