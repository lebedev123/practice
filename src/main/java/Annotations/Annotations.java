package Annotations;


@MyAnnotation(testBoolean = true)
public class Annotations {

}



//Объявление

@interface MyAnnotation{
    boolean testDefaultBoolean() default false;
    boolean testBoolean() ;

}