package com.buimanhthanh.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.buimanhthanh.entity.Color;

public class ColorFormatter implements Formatter<Color>{

	@Override
	public String print(Color object, Locale locale) {
		return String.valueOf(object.getId());
	}

	@Override
	public Color parse(String text, Locale locale) throws ParseException {
		Color c = new Color();
		c.setId(Integer.parseInt(text));
		return c;
	}

}
