package com.demo.base.domain.application.entity;

import com.demo.base.constants.enums.DomainType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.demo.base.constants.Database.AioiDashboard.Schema;
import static com.demo.base.constants.Database.AioiDashboard.Schema.MetricsSchema.Table.ConfigApi;
import static com.demo.base.constants.Database.AioiDashboard.Schema.MetricsSchema.Table.MetricsData;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Table(schema = Schema.MetricsSchema.NAME, name = ConfigApi.NAME)
public class JpaConfigApi {
    @Id
    @Column(name = ConfigApi.Column.ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = ConfigApi.Column.NAME, nullable = false)
    private String name;
    @Column(name = ConfigApi.Column.DESCRIPTION)
    private String description;
    @Column(name = ConfigApi.Column.PATH, nullable = false)
    private String path;
    @Column(name = ConfigApi.Column.STATUS)
    private Boolean status;
    @Enumerated(EnumType.STRING)
    @Column(name = ConfigApi.Column.TYPE, nullable = false)
    private DomainType type;

    @Type(JsonType.class)
    @Column(name = ConfigApi.Column.PARAMS, nullable = false)
    private QueryParams params;

    @Enumerated(EnumType.STRING)
    @Column(name = ConfigApi.Column.INTERVAL, nullable = false)
    private IntervalType interval;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = MetricsData.Column.API_ID)
    private List<JpaMetrics> metricsData = new ArrayList<>();



    public enum IntervalType {
        HOURS, DAYS, MINUTE, WEEK, MONTH
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class QueryParams {
        private String id;
        private String assets;
        private String since;
        private String until;
        private String interval;
        private String currency;
    }
}
