package com.caldabeast.commander;

import java.lang.annotation.*;

/**
 * @author CalDaBeast
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Subcommand {

	String name() default "";

	String[] alias() default {};

	String permission() default "";

}
