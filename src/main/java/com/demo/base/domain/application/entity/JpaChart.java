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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.demo.base.constants.Database.AioiDashboard.Schema;
import static com.demo.base.constants.Database.AioiDashboard.Schema.DashboardSchema.Table.Chart;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Table(schema = Schema.DashboardSchema.NAME, name = Chart.NAME)
public class JpaChart extends Auditable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = Chart.Column.ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = Chart.Column.NAME, nullable = false)
    private String name;
    @Column(name = Chart.Column.DESCRIPTION)
    private String description;

    @Type(JsonType.class)
    @Column(name = Chart.Column.CHART_PROPERTIES)
    private Object chartProperties;

    @ManyToMany(mappedBy = "charts", fetch = FetchType.LAZY)
    private List<JpaDashboard> dashboards;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = Schema.DashboardSchema.Table.SerialChart.NAME,
            schema = Schema.DashboardSchema.NAME,
            joinColumns = @JoinColumn(name = Schema.DashboardSchema.Table.SerialChart.Column.CHART_ID),
            inverseJoinColumns = @JoinColumn(name = Schema.DashboardSchema.Table.SerialChart.Column.SERIAL_ID))
    private List<JpaSerialMetrics> serialData = new ArrayList<>();
}
