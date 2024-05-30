package ru.gamehub.web.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

/**
 * Стандартизированный ответ API
 * @see ResponseEntity
 * @author Потапов Никита
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

    /**
     * Дата+время ответа
     */
    private final OffsetDateTime responseTimestamp;

    /**
     * Данные для успешного ответа
     */
    private Object data;

    /**
     * Данные ответа с ошибкой
     */
    private Object errorData;

    private ApiResponse() {
        this.responseTimestamp = OffsetDateTime.now();
    }

    /**
     *
     * Создание стандартизированного ответа API с {@link HttpStatusCode} 200
     * @param data данные, помещающиеся в тело ответа
     * @return {@link ResponseEntity<ApiResponse>} для использования в контроллере
     */
    public static ResponseEntity<ApiResponse> success(Object data) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(data);
        return ResponseEntity.ok().body(apiResponse);
    }

    public static ResponseEntity<ApiResponse> error(Object errorData, HttpStatusCode httpStatusCode) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setErrorData(errorData);
        return ResponseEntity.status(httpStatusCode).body(apiResponse);
    }

    private void setData(Object data) {
        this.data = data;
    }

    private void setErrorData(Object errorData) {
        this.errorData = errorData;
    }

    public OffsetDateTime getResponseTimestamp() {
        return responseTimestamp;
    }

    public Object getData() {
        return data;
    }

    @JsonProperty("error")
    public Object getErrorData() {
        return errorData;
    }
}
