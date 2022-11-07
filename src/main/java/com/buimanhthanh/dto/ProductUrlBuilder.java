package com.buimanhthanh.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductUrlBuilder {
	private String schema,servletName,serverPort,requestURI;
	
	private Integer page,limit,categoryId;
	private Double priceStart,priceEnd;
	private String orderBy,sortType;
	public String buildURL() {
		StringBuilder uri = new StringBuilder(schema);// "http" 
		uri.append("://" );					// "://"
		uri.append(servletName);// "myhost"
		uri.append(":");					// ":"
		uri.append(serverPort);// "8080"
		uri.append(requestURI);// "/category"
		uri.append("?page="+page);
		uri.append("&&limit="+limit);
		uri.append("&&categoryId="+categoryId);
		uri.append("&&orderBy="+orderBy);
		uri.append("&&sortType="+sortType);
		uri.append("&&priceStart="+priceStart);
		uri.append("&&priceEnd="+priceEnd);
		return uri.toString();
	}
}
