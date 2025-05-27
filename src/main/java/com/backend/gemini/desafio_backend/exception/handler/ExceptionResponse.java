package com.backend.gemini.desafio_backend.exception.handler;

import java.util.Date;

public record ExceptionResponse(String message, String details, Date timestamp) {
}
