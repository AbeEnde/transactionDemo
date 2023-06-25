package Transaction.demo.transactionDemo;

import Transaction.demo.transactionDemo.controller.ParentChildController;
import Transaction.demo.transactionDemo.model.entity.Child;
import Transaction.demo.transactionDemo.model.entity.Parent;
import Transaction.demo.transactionDemo.repository.ChildRepo;
import Transaction.demo.transactionDemo.repository.ParentRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParentChildControllerTest {
    @InjectMocks
    ParentChildController controller;
    @Mock
    ParentRepo parentRepo;

    @Mock
    ChildRepo child;

    @Test
    public void listAllParentDataTest(){
        Pageable pageable = PageRequest.of(2, 2, Sort.by("parent_id").ascending());
        Parent parent1 = new Parent(1L,"ABC","XYZ",200.0,null);
        Parent parent2 = new Parent(2L,"efg","www",20.0,null);
        List<Parent> parents = Arrays.asList(parent1,parent2);
        when(parentRepo.findPageableParentList(pageable)).thenReturn(parents);
        List<Parent> parentList = controller.listAllParentData();
        assertThat(parentList.size()).isEqualTo(2);
        assertThat(parentList.get(0).getId().equals(parent1.getId()));
    }

}
