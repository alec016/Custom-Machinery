package fr.frinn.custommachinery.json_schema.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import java.util.List;

public class GhostItem {
  @JsonProperty(access = JsonProperty.Access.READ_WRITE, required = true)
  private List<ItemStack> items;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  @JsonSubTypes({
    @JsonSubTypes.Type(Color.class),
    @JsonSubTypes.Type(float[].class)
  })
  private float[] color;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private boolean always_render;

  private static class Color {
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private float alpha;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private float red;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private float green;
    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private float blue;
  }
}
