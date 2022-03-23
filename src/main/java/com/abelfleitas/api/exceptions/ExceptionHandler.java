package com.abelfleitas.api.exceptions;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;


@Component
public class ExceptionHandler implements  ResponseErrorHandler  {
    
    private static final Series SERVER_ERROR = null;
    private static final Series CLIENT_ERROR = null;

    @Override
    public boolean hasError(ClientHttpResponse httpResponse) throws IOException {

        return (
          httpResponse.getStatusCode().series() == CLIENT_ERROR 
          || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }


    @Override
    public void handleError(ClientHttpResponse httpResponse) throws IOException {

        if (httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR) {
            // handle SERVER_ERROR
        } 
        else if (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            // handle CLIENT_ERROR
            
            if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
               
            }

            if (httpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
               
            }
        }
    }
}