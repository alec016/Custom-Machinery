package fr.frinn.custommachinery.json_schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Pattern;

public class Tooltip {
  public static final Tooltip DEFAULT = new Tooltip();
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
  private String color;
}
