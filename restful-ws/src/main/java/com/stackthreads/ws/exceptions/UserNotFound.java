package com.stackthreads.ws.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * This class will throw no user found exception with response code 404, which
 * had been setup below by responseStatus annotation
 * 
 * @author nverma4
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends Exception {

	/**
	 * Whenever we through exception, a default json err messages gets rendered: {
	 * "timestamp": "2018-05-09T18:09:39.701+0000", "status": 404, "error": "Not
	 * Found", "message": "No such user found with user id: 20", "path": "/users/20"
	 * }
	 */
	/**
	 * We can modify above format by defining our own exception response 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 8194470171347007496L;

	public UserNotFound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
