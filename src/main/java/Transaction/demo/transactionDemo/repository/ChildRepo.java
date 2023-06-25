package Transaction.demo.transactionDemo.repository;

import Transaction.demo.transactionDemo.model.entity.Child;
import Transaction.demo.transactionDemo.model.entity.Parent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChildRepo extends JpaRepository<Child, Long> {
    @Query(value = "Select * from child c", nativeQuery = true)
    public List<Child> findPageableChildList(Pageable pageable);
}
