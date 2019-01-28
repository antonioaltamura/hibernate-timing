import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface EventBody {

	/**
	 * Value.
	 *
	 * @return the string
	 */
	String value() default "";
}
