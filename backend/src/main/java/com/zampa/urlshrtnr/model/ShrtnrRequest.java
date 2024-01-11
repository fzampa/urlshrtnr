package com.zampa.urlshrtnr.model;


import jakarta.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

public class ShrtnrRequest {

    @NotBlank(message = "URL can't be null")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(@NonNull String url) {
        this.url = url;
    }
}
