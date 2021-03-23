package com.ayantsoft.springbootdeploy.springbootdeploy.exception;

import java.io.Serializable;

public class InvalidInputException  extends RuntimeException implements Serializable{

	/**
	 * final long serialVersionUID = 1418686378776401963L;

	 */
	private String msg;
	private static final long serialVersionUID = 1418686378776401963L;
	
	public InvalidInputException(String msg){
		this.msg=msg;
	}

}
