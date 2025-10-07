package com.demo.base.domain.application.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static com.demo.base.constants.Database.AioiDashboard.Schema;
import static com.demo.base.constants.Database.AioiDashboard.Schema.DashboardSchema.Table.Role;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Table(schema = Schema.DashboardSchema.NAME, name = Role.NAME)
public class JpaRole implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = Role.Column.ID, nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = Role.Column.NAME, nullable = false)
    private String name;
    @Column(name = Role.Column.DESCRIPTION)
    private String description;
    @Column(name = Role.Column.STATUS)
    private Boolean status;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<JpaDashboard> dashboards;

}
