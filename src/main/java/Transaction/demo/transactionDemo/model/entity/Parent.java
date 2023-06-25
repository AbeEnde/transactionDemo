package Transaction.demo.transactionDemo.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parent")
public class Parent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "parentId", nullable = false)
    private Long id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "total_amount")
    private Double totalAmount;

    @OneToMany(mappedBy = "parentId", cascade = CascadeType.ALL)
    private List<Child> children;

    public Long getId() {
        return id;
    }

    public void setId(Long parentId) {
        this.id = parentId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }
    @JsonManagedReference
    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
