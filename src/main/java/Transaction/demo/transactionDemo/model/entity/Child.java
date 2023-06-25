package Transaction.demo.transactionDemo.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "child")
public class Child {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "childId", nullable = false)
    private Long id;

    @Column(name = "paid_amount")
    private Double paidAmount;

    @ManyToOne()
    @JoinColumn(name = "parent_id", nullable = false, referencedColumnName = "parentId")
    private Parent parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long childId) {
        this.id = childId;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }
    @JsonBackReference
    public Parent getParentId() {
        return parentId;
    }

    public void setParentId(Parent parent) {
        this.parentId = parent;
    }
}
