package com.example.domain.mapper;

import com.example.domain.dto.ErrorMessageDto;
import com.example.domain.exception.ResponseCodeError;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface ErrorMessageMapper {
    ErrorMessageDto map(ResponseCodeError error);
}