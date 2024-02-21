package fr.frinn.custommachinery.json_schema;

import com.fasterxml.jackson.annotation.JsonProperty;

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
  private String font;
  @JsonProperty(access = JsonProperty.Access.READ_WRITE)
  private String color;

  public void setBold(boolean bold) {
    this.bold = bold;
  }

  public boolean isBold() {
    return this.bold;
  }

  public void setItalic(boolean italic) {
    this.italic = italic;
  }

  public boolean isItalic() {
    return italic;
  }

  public void setUnderlined(boolean underlined) {
    this.underlined = underlined;
  }

  public boolean isUnderlined() {
    return this.underlined;
  }

  public void setStrikethrough(boolean strikethrough) {
    this.strikethrough = strikethrough;
  }

  public boolean isStrikethrough() {
    return strikethrough;
  }

  public void setObfuscated(boolean obfuscated) {
    this.obfuscated = obfuscated;
  }

  public boolean isObfuscated() {
    return obfuscated;
  }

  public void setFont(String font) {
    this.font = font;
  }

  public String getFont() {
    return font;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String getColor() {
    return color;
  }
}
