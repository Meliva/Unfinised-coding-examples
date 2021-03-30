import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the validation of the entity.
 */
public final class ValidatorUtil {

	private ValidatorUtil(){}

	/**
	 * Validation of the given entity annotations
	 * @param model
	 * @throws Exception
	 */
	public static void validateModel(Validated model) throws ValidatorException {
        String errorMessages = "";

        for (String error : validateAnnotatedFields(model))
            errorMessages += "\n\t- " + error;

        if (!errorMessages.equals(""))
            throw new ValidatorException("Validation Errors: " + errorMessages);
	} // validateModel

	/**
	 * Validates all the annotated field of the given model.
	 * @param model
	 * @return error string
	 */
	private static List<String> validateAnnotatedFields(Validated model) {
		List<String> errors = new ArrayList<String>();
		try {
            for (Field field : model.getClass().getDeclaredFields()) {

                // Required field
                final Required required = field.getAnnotation(Required.class);
                if (required != null) {
                    final Object fieldValue = PropertyUtils.getProperty(model, field.getName());
                    if (fieldValue == null || String.valueOf(fieldValue).length() == 0) {
                        errors.add("[" + field.getName() + "] Required.");
                    }
                }// Required

                // Max
                final Max max = field.getAnnotation(Max.class);
                if (max != null) {
                    final double fieldValue = new Double(PropertyUtils.getProperty(model, field.getName()).toString());
                    final boolean maxGuard = max.inclusive() ? max.value() < fieldValue : max.value() <= fieldValue;
                    if (maxGuard) {
                        final String maxInclusiveTxt = max.inclusive() ? ": " : " less than ";
                        errors.add("[" + field.getName() + ": " + fieldValue + "] value is too large. Minimum length is: " + maxInclusiveTxt + max.value());
                    }
                } // Max

                // Min
                final Min min = field.getAnnotation(Min.class);
                if (min != null) {
                    final double fieldValue = new Double(PropertyUtils.getProperty(model, field.getName()).toString());
                    final boolean minGuard = min.inclusive() ? min.value() > fieldValue : min.value() >= fieldValue;
                    if (minGuard) {
                        final String minInclusiveTxt = min.inclusive() ? ": " : " greater than ";
                        errors.add("[" + field.getName() + ": " + fieldValue + "] value is too small. Minimum length is" + minInclusiveTxt + min.value());
                    }
                } // Min

                // MaxLength
                final MaxLength maxLength = field.getAnnotation(MaxLength.class);
                if (maxLength != null) {
                    final Object fieldValue = PropertyUtils.getProperty(model, field.getName());
                    if (fieldValue instanceof String ) {
                        if (maxLength.value() < String.valueOf(fieldValue).length()) {
                            errors.add("[" + field.getName() + ": " + fieldValue + "] length is too large. Maximum length is: " + maxLength.value());
                        }
                    }
                }// MaxLength

                // MinLength
                final MinLength minLength = field.getAnnotation(MinLength.class);
                if (minLength != null) {
                    final Object fieldValue = PropertyUtils.getProperty(model, field.getName());
                    if (fieldValue instanceof String) {
                        if (minLength.value() > String.valueOf(fieldValue).length()) {
                            errors.add("[" + field.getName() + ": " + fieldValue + "] length is too small. Minimum length is: " + minLength.value());
                        }
                    }
                }// MinLength


            }//end-for
        } catch (Exception e) { e.printStackTrace(); }

		return errors;
	} // validateAnnotatedFields
}
