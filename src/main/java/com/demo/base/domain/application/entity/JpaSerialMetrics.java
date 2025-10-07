package com.demo.base.domain.application.entity;

import com.demo.base.persistence.entity.Auditable;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;
import org.hibernate.annotations.Type;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

import static com.demo.base.constants.Database.AioiDashboard.Schema;
import static com.demo.base.constants.Database.AioiDashboard.Schema.DashboardSchema.Table.SerialMetrics;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Table(schema = Schema.DashboardSchema.NAME, name = SerialMetrics.NAME)
public class JpaSerialMetrics extends Auditable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = Schema.DashboardSchema.Table.Chart.Column.ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = SerialMetrics.Column.NAME)
    private String name;

    @Type(JsonType.class)
    @Column(name = SerialMetrics.Column.METRIC_RESOLUTION)
    private Map<String, MetricsResolution> resolution;
}
