package com.main.model.response;

import org.springframework.http.HttpStatus;


    public class BaseResponse<T> {

        private T response;

        public T getResponse() {
            return this.response;
        }

        public void setResponse(T response) {
            this.response = response;
        }

        private String responseDescription;

        public String getResponseDescription() {
            return responseDescription;
        }

        public void setResponseDescription(String responseDescription) {
            this.responseDescription = responseDescription;
        }

        private HttpStatus responseCode;

        public HttpStatus getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(HttpStatus responseCode) {
            this.responseCode = responseCode;
        }
    }


