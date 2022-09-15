package com.buimanhthanh.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.buimanhthanh.entity.Discount;

public class DiscountFormatter implements Formatter<Discount>{

	@Override
	public String print(Discount object, Locale locale) {
		return String.valueOf(object.getId());
	}

	@Override
	public Discount parse(String text, Locale locale) throws ParseException {
		Discount d  = new Discount();
		d.setId(Integer.parseInt(text));
		return d;
	}

}
