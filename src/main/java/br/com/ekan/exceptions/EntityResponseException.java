package br.com.ekan.exceptions;


import br.com.ekan.config.CodeError;

public class EntityResponseException extends RuntimeException{
    private CodeError codeError;
    public EntityResponseException(String mensagem, CodeError codeError){
        super(mensagem);
        this.codeError = codeError;
    }

    public CodeError getCodeError() {
        return codeError;
    }

    public void setCodeError(CodeError codeError) {
        this.codeError = codeError;
    }
}
