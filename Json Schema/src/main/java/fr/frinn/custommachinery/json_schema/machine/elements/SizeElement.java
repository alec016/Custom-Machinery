package fr.frinn.custommachinery.json_schema.machine.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class SizeElement {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  @Max(3840)
  private int width;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @Min(1)
  @Max(2160)
  private int height;
}
