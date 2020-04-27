package Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Data
public class RestResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;


    public enum CodeEnum {
        SUCCESS(0),
        ERROR(500);

        private int v1;


        CodeEnum(int v1) {
            this.v1 = v1;
        }
    }

    public static <T> RestResult<T> success() {
        return restResult(CodeEnum.SUCCESS.v1, null, null);
    }

    public static <T> RestResult<T> success(T data) {
        return restResult(CodeEnum.SUCCESS.v1, null, data);
    }

    public static <T> RestResult<T> success(String msg, T data) {
        return restResult(CodeEnum.SUCCESS.v1, msg, data);
    }

    public static <T> RestResult<T> error(String msg) {
        return restResult(CodeEnum.ERROR.v1, msg, null);
    }

    private static <T> RestResult<T> restResult(int code, String msg, T data) {
        return RestResult.<T>builder()
                .code(code)
                .msg(msg)
                .data(data).build();
    }
}
