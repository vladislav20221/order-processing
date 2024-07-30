package com.example.domain.mapper;

import com.example.domain.dto.ErrorMessageDto;
import com.example.domain.exception.ResponseCodeError;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-30T14:22:56+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class ErrorMessageMapperImpl implements ErrorMessageMapper {

    @Override
    public ErrorMessageDto map(ResponseCodeError error) {
        if ( error == null ) {
            return null;
        }

        ErrorMessageDto.ErrorMessageDtoBuilder errorMessageDto = ErrorMessageDto.builder();

        if ( error.getStatus() != null ) {
            errorMessageDto.status( error.getStatus().name() );
        }
        if ( error.getCode() != null ) {
            errorMessageDto.code( error.getCode().name() );
        }
        errorMessageDto.message( error.getMessage() );

        return errorMessageDto.build();
    }
}
