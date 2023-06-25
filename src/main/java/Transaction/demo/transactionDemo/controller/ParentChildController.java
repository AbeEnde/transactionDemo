package Transaction.demo.transactionDemo.controller;

import Transaction.demo.transactionDemo.model.DataMapper;
import Transaction.demo.transactionDemo.model.DataMapperChild;
import Transaction.demo.transactionDemo.model.entity.Child;
import Transaction.demo.transactionDemo.model.entity.Parent;
import Transaction.demo.transactionDemo.repository.ChildRepo;
import Transaction.demo.transactionDemo.repository.ParentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParentChildController {
    /**
     * for simplicity not explicit service class
     * directly autowired repositories.
     */
    @Autowired
    ParentRepo parentRepo;

    @Autowired
    ChildRepo childRepo;

    /**
     * url = /api/parents
     * lis all parent data
     * @return
     */
    @GetMapping("/parents")
    public List<Parent> listAllParentData() {
        Pageable pageable = PageRequest.of(2, 2, Sort.by("parent_id").ascending());
        return parentRepo.findPageableParentList(pageable);
    }

    /**
     * url = /api/children
     * list all child data
     * @return
     */
    @GetMapping("/children")
    public List<Child> listChildrenData() {
        Pageable pageable = PageRequest.of(2, 2, Sort.by("child_id").ascending());
        return childRepo.findPageableChildList(pageable);
    }

    /**
     * post api to store list of parent data
     * @param data
     * @return
     */
    @PostMapping("/add")
    public List<Parent> addAllParentData(@RequestBody DataMapper data) {
       return parentRepo.saveAll(data.getData());
    }

    /**
     * post api to store list of child data
     * @param data
     * @return
     */
    @PostMapping("/addChildren")
    public List<Child> addChildrenData(@RequestBody DataMapperChild data) {
        return childRepo.saveAll(data.getData());
    }

}
