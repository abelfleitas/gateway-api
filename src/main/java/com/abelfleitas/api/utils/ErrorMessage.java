package com.abelfleitas.api.utils;

import javax.persistence.Enumerated;
import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    
    private String message;
	@Enumerated
	private HttpStatus status;

    public ErrorMessage(String message,HttpStatus status){
        this.message = message;
        this.status = status;
    }

    @Override
	public String toString() {
		return "ErrorMessage [message=" + message + ", status=" + status + "]";
	}
}
