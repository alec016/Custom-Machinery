package fr.frinn.custommachinery.json_schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Processor {
  public static final Processor DEFAULT = new Processor();
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private ProcessorType type = ProcessorType.MACHINE;

  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  private int amount = 1;

  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private int cooldown = 20;

  private enum ProcessorType {
    MACHINE("machine"),
    CRAFT("craft");

    private final String type;

    ProcessorType(String type) {
      this.type = type;
    }

    public boolean isValid(String type) {
      return this.type.equalsIgnoreCase(type);
    }
  }
}
