package Transaction.demo.transactionDemo.model;

import Transaction.demo.transactionDemo.model.entity.Child;
import Transaction.demo.transactionDemo.model.entity.Parent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataMapper {
    List<Parent> data;
}
