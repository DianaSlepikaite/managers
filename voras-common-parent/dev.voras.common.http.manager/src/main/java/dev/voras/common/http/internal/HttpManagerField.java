package dev.voras.common.http.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to annotate annotations that are to be used for Test Class fields. To be
 * populated by the Manager.
 *
 * @author William Yates
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface HttpManagerField {

}