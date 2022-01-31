package com.main.model.response;

import org.apache.http.HttpStatus;

public class ResponseBase {

    private String responseDescription;

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    private HttpStatus Response;

    public HttpStatus getResponse() {
        return Response;
    }

    public void setResponse(HttpStatus response) {
        Response = response;
    }
}
