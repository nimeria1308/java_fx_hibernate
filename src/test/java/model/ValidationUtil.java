package model;

import org.junit.Assert;
import org.junit.function.ThrowingRunnable;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidationUtil {

    private static final ValidatorFactory FACTORY = Validation.buildDefaultValidatorFactory();

    public static <T> void validate(T value) {
        Set<ConstraintViolation<T>> violations = FACTORY.getValidator().validate(value);

        for (ConstraintViolation<T> violation : violations) {
            System.out.println(violation.getMessage());
        }

        if (!violations.isEmpty()) {
            throw new ValidationException("Validation failed");
        }
    }

    public static <T> void assertValidationFails(final T value) {
        Assert.assertThrows(ValidationException.class, new ThrowingRunnable() {
            public void run() throws Throwable {
                validate(value);
            }
        });
    }
}
