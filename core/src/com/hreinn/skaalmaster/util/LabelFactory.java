package com.hreinn.skaalmaster.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class LabelFactory {

    public static Label createLabel(String text, float xPos, float yPos, Color color) {
        Label label = new Label(text, new Label.LabelStyle(LabelFactory.getRobotRegular(color), null));
        label.setPosition(xPos, yPos);
        label.setFontScale(1f);
        return label;
    }

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
