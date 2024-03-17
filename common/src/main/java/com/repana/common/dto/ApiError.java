package com.repana.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Getter
@Setter
@Slf4j
public class ApiError {

    protected int status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    protected LocalDateTime timestamp;
    protected String message;
    protected String debugMessage;
    protected String errorCode;
    protected Map<String,Object> moreInfo;


    public ApiError() {
        timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status) {
        this();
        this.status = status.value();
    }

    public ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status.value();
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status.value();
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
        try {
            this.errorCode = message;
        } catch (Exception e) {
            log.error("Error code not found");
        }
    }

    public ApiError(HttpStatus status, String message, Boolean retrySameNach, String retryUrl,  Throwable ex) {
        this();
        this.status = status.value();
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
        try {
            this.errorCode = message;
        } catch (Exception e) {
            log.error("Error code not found");
        }
        this.moreInfo = Map.of("can_retry",retrySameNach, "retry_url", retryUrl);
    }

}
