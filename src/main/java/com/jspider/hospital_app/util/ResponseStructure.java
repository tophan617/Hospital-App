package com.jspider.hospital_app.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private T data;
	private String message;
	private int statusCode;
}
