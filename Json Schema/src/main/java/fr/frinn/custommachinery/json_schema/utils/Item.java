package fr.frinn.custommachinery.json_schema.utils;


import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes({
  @JsonSubTypes.Type(ItemItem.class),
  @JsonSubTypes.Type(ItemTag.class),
  @JsonSubTypes.Type(String.class)
})
public class Item { }
