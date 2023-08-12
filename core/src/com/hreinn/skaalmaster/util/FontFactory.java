package com.hreinn.skaalmaster.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class FontFactory {

    public static BitmapFont getRobotRegular(Color color) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("RobotoCondensed-Regular.ttf"));
        return getFont(generator, color, 100);
    }

    public static BitmapFont getRobotRegular(Color color, int fontSize) {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("RobotoCondensed-Regular.ttf"));
        return getFont(generator, color, fontSize);
    }

    private static BitmapFont getFont(FreeTypeFontGenerator generator, Color color, int fontSize) {
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = fontSize;
        parameter.borderWidth = 1;
        parameter.color = color;
        BitmapFont bitmapFont = generator.generateFont(parameter);
        bitmapFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        bitmapFont.setUseIntegerPositions(false);
        generator.dispose();
        return bitmapFont;
    }
}
