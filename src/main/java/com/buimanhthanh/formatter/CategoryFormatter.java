package com.buimanhthanh.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.buimanhthanh.entity.Category;

public class CategoryFormatter implements Formatter<Category>{

	@Override
	public String print(Category object, Locale locale) {
		return String.valueOf(object.getId());
	}

	@Override
	public Category parse(String text, Locale locale) throws ParseException {
		Category c = new Category();
		c.setId(Integer.parseInt(text));
		return c;
	}

}
