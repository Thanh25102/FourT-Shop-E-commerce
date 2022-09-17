package com.buimanhthanh.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.buimanhthanh.entity.Size;

public class SizeFormatter implements Formatter<Size>{

	@Override
	public String print(Size object, Locale locale) {
		return String.valueOf(object.getId());
	}

	@Override
	public Size parse(String text, Locale locale) throws ParseException {
		Size c = new Size();
		c.setId(Integer.parseInt(text));
		return c;
	}

}
