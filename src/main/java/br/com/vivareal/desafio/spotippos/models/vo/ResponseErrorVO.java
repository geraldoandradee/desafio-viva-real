package br.com.vivareal.desafio.spotippos.models.vo;

public class ResponseErrorVO {
    private String errorMessage;
    private Integer errorCode;

    public ResponseErrorVO(Integer errorCode, String errorMessage) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
