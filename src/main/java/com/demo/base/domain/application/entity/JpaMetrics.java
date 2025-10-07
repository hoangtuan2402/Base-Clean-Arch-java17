package com.demo.base.domain.application.entity;

import com.demo.base.persistence.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import static com.demo.base.constants.Database.AioiDashboard.Schema;
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
@Table(schema = Schema.MetricsSchema.NAME, name = MetricsData.NAME)
public class JpaMetrics extends Auditable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = MetricsData.Column.ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = MetricsData.Column.API_ID, nullable = false)
    private UUID apiId;

    @Column(name = MetricsData.Column.TIME, nullable = false)
    private LocalDateTime time;

    @Column(name = MetricsData.Column.STR_TIME)
    private String strTime;

    @Column(name = MetricsData.Column.VALUE, nullable = false)
    private BigDecimal value;

    @Column(name = MetricsData.Column.SCORE)
    private BigDecimal score;

    @Enumerated(EnumType.STRING)
    @Column(name = MetricsData.Column.TYPE, nullable = false)
    private JpaConfigApi.IntervalType type;


}
