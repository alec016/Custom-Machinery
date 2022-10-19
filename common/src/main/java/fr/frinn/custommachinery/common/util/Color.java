package fr.frinn.custommachinery.common.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.frinn.custommachinery.impl.codec.CodecLogger;
import net.minecraft.util.FastColor;

import java.util.stream.DoubleStream;

public class Color {

    public static final MapCodec<Color> MAP_CODEC = RecordCodecBuilder.mapCodec(colorInstance ->
            colorInstance.group(
                    CodecLogger.loggedOptional(Codec.FLOAT, "alpha", 1.0F).forGetter(color -> color.getAlpha() / 255.0F),
                    CodecLogger.loggedOptional(Codec.FLOAT, "red", 1.0F).forGetter(color -> color.getRed() / 255.0F),
                    CodecLogger.loggedOptional(Codec.FLOAT, "green", 1.0F).forGetter(color -> color.getGreen() / 255.0F),
                    CodecLogger.loggedOptional(Codec.FLOAT, "blue", 1.0F).forGetter(color -> color.getBlue() / 255.0F)
            ).apply(colorInstance, Color::fromColors)
    );

    public static final Codec<Color> ARRAY_CODEC = Codecs.DOUBLE_STREAM.comapFlatMap(
            stream -> Codecs.validateDoubleStreamSize(stream, 4)
                    .map(array -> fromColors(array[0], array[1], array[2], array[3])),
            color -> DoubleStream.of(color.getAlpha() / 255.0F, color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F)
    );

    public static final Codec<Color> CODEC = EitherManyCodec.of(MAP_CODEC.codec(), ARRAY_CODEC, Codec.intRange(0, Integer.MAX_VALUE).xmap(Color::fromARGB, Color::getARGB));

    public static final Color WHITE = fromColors(255, 255, 255, 255);
    public static final Color TRANSPARENT_WHITE = fromColors(127, 255, 255, 255);

    private final int alpha;
    private final int red;
    private final int green;
    private final int blue;

    public static Color fromARGB(int colorARGB) {
        return new Color(FastColor.ARGB32.alpha(colorARGB), FastColor.ARGB32.red(colorARGB), FastColor.ARGB32.green(colorARGB), FastColor.ARGB32.blue(colorARGB));
    }

    public static Color fromColors(int alpha, int red, int green, int blue) {
        return new Color(alpha, red, green, blue);
    }

    public static Color fromColors(float alpha, float red, float green, float blue) {
        return fromColors((int) (alpha * 255), (int) (red * 255), (int) (green * 255), (int) (blue * 255));
    }

    public static Color fromColors(double alpha, double red, double green, double blue) {
        return fromColors((int) (alpha * 255), (int) (red * 255), (int) (green * 255), (int) (blue * 255));
    }

    private Color(int alpha, int red, int green, int blue) {
        this.alpha = alpha;
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getAlpha() {
        return this.alpha;
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

    public int getARGB() {
        return FastColor.ARGB32.color(this.alpha, this.red, this.green, this.blue);
    }
}
