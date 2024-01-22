package study.cursach.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "document_pack")
public class DocumentPack {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "passport_id")
    private Integer passportId;

    @Column(name = "entry_permission_id")
    private Integer entryPermissionId;

    @Column(name = "work_permission_id")
    private Integer workPermissionId;

    @Column(name = "declaration_id")
    private Integer declarationId;

}