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
	private String requestURI;

	private Integer page, limit, categoryId;
	private Double priceStart, priceEnd;
	private String orderBy, sortType;

	public String buildRootURL() {
		StringBuilder uri = new StringBuilder(requestURI);
		return uri.toString();
	}

	public String buildURL() {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		if (categoryId != null) {
			uri.append("/category/" + categoryId);
		}
		if (orderBy != null && sortType != null) {
			uri.append("/sort/" + orderBy);
			uri.append("/" + sortType);
		}
		if (limit != null) {
			uri.append("/limit/" + limit);
		}
		if (priceStart != -1 && priceEnd != -1) {
			uri.append("?priceStart=" + priceStart);
			uri.append("&&priceEnd=" + priceEnd);
		}
		return uri.toString();
	}

	public String buildURLWithoutPriceRange() {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		if (categoryId != null) {
			uri.append("/category/" + categoryId);
		}
		if (orderBy != null && sortType != null) {
			uri.append("/sort/" + orderBy);
			uri.append("/" + sortType);
		}
		if (limit != null) {
			uri.append("/limit/" + limit);
		}
		return uri.toString();
	}

	public String buildURLWithLimit(Integer limit, Integer page) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + categoryId);
		if (orderBy != null && sortType != null) {
			uri.append("/sort/" + orderBy);
			uri.append("/" + sortType);
		}
		uri.append("/limit/" + limit);
		if (priceStart != -1 && priceEnd != -1) {
			uri.append("?priceStart=" + priceStart);
			uri.append("&&priceEnd=" + priceEnd);
		}
		return uri.toString();
	}

	public String buildURL(Integer page, Integer categoryId) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + categoryId);
		if (orderBy != null && sortType != null) {
			uri.append("/sort/" + orderBy);
			uri.append("/" + sortType);
		}
		uri.append("/limit/" + limit);
		if (priceStart != -1 && priceEnd != -1) {
			uri.append("?priceStart=" + priceStart);
			uri.append("&&priceEnd=" + priceEnd);
		}
		return uri.toString();
	}

	public String buildURL(String sortField, String sortType) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + categoryId);
		if (orderBy != null && sortType != null) {
			uri.append("/sort/" + orderBy);
			uri.append("/" + sortType);
		}
		return uri.toString();
	}

	public String buildURL(String sortField, String sortType, Integer limit, Integer page) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + categoryId);
		uri.append("/sort/" + sortField);
		uri.append("/" + sortType);
		uri.append("/limit/" + limit);
		if (priceStart != -1 && priceEnd != -1) {
			uri.append("?priceStart=" + priceStart);
			uri.append("&&priceEnd=" + priceEnd);
		}
		return uri.toString();
	}

	public String buildURL(String page, Integer categoryId, Double priceStart, Double priceEnd) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + categoryId);
		uri.append("?priceStart=" + priceStart);
		uri.append("&&priceEnd=" + priceEnd);
		return uri.toString();
	}

	public String buildURL(Integer page, Integer categoryId, String sortField, String sortType) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + categoryId);
		uri.append("/sort/" + sortField);
		uri.append("/" + sortType);
		return uri.toString();
	}

	public String buildURL(Integer page, Integer categoryId, String sortField, String sortType, Double priceStart,
			Double priceEnd) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + categoryId);
		uri.append("/sort/" + sortField);
		uri.append("/" + sortType);
		uri.append("?priceStart=" + priceStart);
		uri.append("&&priceEnd=" + priceEnd);
		return uri.toString();
	}

	public String buildURL(Integer page, Integer categoryId, String sortField, String sortType, String limit) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + categoryId);
		uri.append("/sort/" + sortField);
		uri.append("/" + sortType);
		uri.append("/limit/" + limit);
		return uri.toString();
	}

	public String buildURL(Integer page, Integer categoryId, String sortField, String sortType, String limit,
			Double priceStart, Double priceEnd) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + categoryId);
		uri.append("/sort/" + orderBy);
		uri.append("/" + sortType);
		uri.append("/limit/" + limit);
		if (priceStart != -1 && priceEnd != -1) {
			uri.append("?priceStart=" + priceStart);
			uri.append("&&priceEnd=" + priceEnd);
		}
		return uri.toString();
	}

	public String buildURL(Integer page) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + categoryId);
		if (orderBy != null && sortType != null) {
			uri.append("/sort/" + orderBy);
			uri.append("/" + sortType);
		}
		uri.append("/limit/" + limit);
		if (priceStart != -1 && priceEnd != -1) {
			uri.append("?priceStart=" + priceStart);
			uri.append("&&priceEnd=" + priceEnd);
		}
		return uri.toString();
	}

	public String buildCategoryURL(Integer category) {
		StringBuilder uri = new StringBuilder(buildRootURL());
		uri.append("/page/" + page);
		uri.append("/category/" + category);
		if (orderBy != null && sortType != null) {
			uri.append("/sort/" + orderBy);
			uri.append("/" + sortType);
		}
		uri.append("/limit/" + limit);
		if (priceStart != -1 && priceEnd != -1) {
			uri.append("?priceStart=" + priceStart);
			uri.append("&&priceEnd=" + priceEnd);
		}
		return uri.toString();
	}
}
