package Transaction.demo.transactionDemo.repository;

import Transaction.demo.transactionDemo.model.entity.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface ParentRepo extends JpaRepository<Parent, Long> {
    @Query(value = "Select * from parent p", nativeQuery = true)
    public List<Parent> findPageableParentList(Pageable pageable);
}
