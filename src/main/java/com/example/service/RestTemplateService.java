package com.example.service;

import com.example.dto.ApiResponse;
import com.example.restClient.RestTemplateClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
@AllArgsConstructor
public class RestTemplateService {

    RestTemplateClient RestTemplateClient;

    public ApiResponse deleteProduct(Long id) {

        try {
            RestTemplateClient.deleteProduct(id);
        } catch (HttpClientErrorException ex) {
            if(ex.getStatusCode() == HttpStatus.NOT_FOUND) {
                return buildNotFoundResponse();
            } else {
                throw ex;
            }
        } catch (Exception ex) {
            return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return buildSuccessResponse();

    }

    private ApiResponse buildNotFoundResponse() {
        return new ApiResponse( "Product not found", HttpStatus.NOT_FOUND.value());
    }

    private ApiResponse buildErrorResponse(HttpStatus status) {
        return new ApiResponse( "Error occurred", status.value());
    }

    private ApiResponse buildSuccessResponse() {
        return new ApiResponse( "Product deleted successfully", HttpStatus.OK.value());
    }
}
