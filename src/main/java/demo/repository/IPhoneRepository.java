package demo.repository;

import demo.model.Phone;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IPhoneRepository extends PagingAndSortingRepository<Phone,Long> {
}
