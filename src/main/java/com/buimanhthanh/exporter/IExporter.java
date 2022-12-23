package com.buimanhthanh.exporter;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public interface IExporter<T> {
	void export(HttpServletResponse response) throws IOException;
}
