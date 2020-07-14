package demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;

@Entity
@Table(name = "phones")
public class Phone implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //phương thức xác định class này được Validate
    @Override
    public boolean supports(Class<?> clazz) {
        return Phone.class.isAssignableFrom(clazz);
    }

    //là phương thức dùng để xác minh cho đối tượng và trả về lỗi trong errors nếu có
    @Override
    public void validate(Object target, Errors errors) {
        Phone phone = (Phone) target;
        String number = phone.getNumber();
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length() > 11 || number.length() < 10) {
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")) {
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("number", "number.matches");
        }
    }
}
