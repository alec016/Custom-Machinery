package fr.frinn.custommachinery.common.util;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import java.util.stream.Stream;

public class TagUtil {

    public static Stream<Item> getItems(TagKey<Item> tag) {
        return BuiltInRegistries.ITEM.getTag(tag).map(named -> named.stream().map(Holder::value)).orElse(Stream.empty());
    }

    public static Stream<Block> getBlocks(TagKey<Block> tag) {
        return BuiltInRegistries.BLOCK.getTag(tag).map(named -> named.stream().map(Holder::value)).orElse(Stream.empty());
    }

    public static Stream<Fluid> getFluids(TagKey<Fluid> tag) {
        return BuiltInRegistries.FLUID.getTag(tag).map(named -> named.stream().map(Holder::value)).orElse(Stream.empty());
    }
}
