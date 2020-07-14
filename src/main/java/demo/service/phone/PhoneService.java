package demo.service.phone;

import demo.model.Phone;
import demo.repository.IPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PhoneService implements IPhoneService{
    @Autowired
    private IPhoneRepository phoneRepository;

    @Override
    public Iterable<Phone> findAll() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone findById(Long id) {
        return phoneRepository.findOne(id);
    }

    @Override
    public void save(Phone model) {
        phoneRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        phoneRepository.delete(id);
    }
}
