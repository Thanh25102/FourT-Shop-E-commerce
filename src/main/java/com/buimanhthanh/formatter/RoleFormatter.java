package com.buimanhthanh.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.buimanhthanh.entity.Role;

public class RoleFormatter implements Formatter<Role>{

	@Override
	public String print(Role object, Locale locale) {
		return String.valueOf(object.getId());
	}

	@Override
	public Role parse(String text, Locale locale) throws ParseException {
		Role r = new Role();
		r.setId(Integer.parseInt(text));
		return r;
	}

}
