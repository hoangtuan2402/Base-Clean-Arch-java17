package com.demo.base.domain.application.entity;

import com.demo.base.constants.enums.DomainType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MetricsResolution implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String dataId;
    private DomainType domainType;
    private String formula;
}
