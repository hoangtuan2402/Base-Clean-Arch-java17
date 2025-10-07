package com.demo.base.domain.application.entity;

import com.demo.base.persistence.entity.Auditable;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.demo.base.constants.Database.AioiDashboard.Schema;
import static com.demo.base.constants.Database.AioiDashboard.Schema.DashboardSchema.Table.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Table(schema = Schema.DashboardSchema.NAME, name = Dashboard.NAME)
public class JpaDashboard extends Auditable implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = Dashboard.Column.ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = Dashboard.Column.NAME, nullable = false)
    private String name;

    @Column(name = Dashboard.Column.DESCRIPTION)
    private String description;

    @Column(name = Dashboard.Column.STATUS)
    private Boolean status;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = DashboardRoles.NAME,
            schema = Schema.DashboardSchema.NAME,
            joinColumns = @JoinColumn(name = DashboardRoles.Column.DASHBOARD_ID),
            inverseJoinColumns = @JoinColumn(name = DashboardRoles.Column.ROLE_ID))
    private List<JpaRole> roles = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = DashboardChart.NAME,
            schema = Schema.DashboardSchema.NAME,
            joinColumns = @JoinColumn(name = DashboardChart.Column.DASHBOARD_ID),
            inverseJoinColumns = @JoinColumn(name = DashboardChart.Column.CHART_ID))
    @OrderBy("name ASC ")
    private List<JpaChart> charts = new ArrayList<>();

    public void addChart(JpaChart chart) {
        if (this.charts == null) {
            this.charts = new ArrayList<>();
        }
        this.charts.add(chart);
    }

    public void addRole(JpaRole jpaRole) {
        if (this.roles == null) {
            this.roles = new ArrayList<>();
        }
        this.roles.add(jpaRole);
    }

}
