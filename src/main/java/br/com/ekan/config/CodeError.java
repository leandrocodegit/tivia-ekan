package br.com.ekan.config;

public enum CodeError {

    NOT_FOUND("001"),
    FORMAT_INVALID("002"),
    DATA_BASE("003"),
    AUTH_ERROR("004");
    private String value;

    CodeError(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
