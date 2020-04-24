package com.springapi.api.exceptionhandler;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@ControllerAdvice //é compnente do spring que trata exceptions dos controladores
public class ApiExceptionHandler extends ResponseEntityExceptionHandler { //tem varios tratamentos ja implementados

    @ExceptionHandler(ExceptionNegocio.class) //quando uma excessao é lançada cai aqui dentro
    public ResponseEntity<Object> handleNegocio(ExceptionNegocio exceptionNegocio, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        var problema = new ExeptionResposta();
        problema.setStatus(status.value());
        problema.setTitulo(exceptionNegocio.getMessage());
        problema.setDataHora(LocalDateTime.now());

        return handleExceptionInternal(exceptionNegocio, problema, new HttpHeaders(), status, request);
    }

    @Override //quando uma excessao é lançada ela cai no metodo override, onde podemos trata-la da forma que quisermos
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        var campos = new ArrayList<ExeptionResposta.Campo>();

        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
            String mensagem = error.getDefaultMessage();
            String nome = ((FieldError)error).getField();

            campos.add(new ExeptionResposta.Campo(nome, mensagem));
        }

        var problema = new ExeptionResposta();
        problema.setStatus(status.value());
        problema.setTitulo("Um ou mais campos estão inválidos. "
                            + "Tente novamente");
        problema.setDataHora(LocalDateTime.now());
        problema.setCampos(campos);

        return super.handleExceptionInternal(ex, problema, headers, status, request);
    }
}
