package com.buimanhthanh.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.buimanhthanh.entity.Product;

public class ProductFormatter implements Formatter<Product> {

	@Override
	public String print(Product object, Locale locale) {
		return String.valueOf(object.getId());
	}

	@Override
	public Product parse(String text, Locale locale) throws ParseException {
		Product p = new Product();
		p.setId(Integer.parseInt(text));
		return p;
	}

}
