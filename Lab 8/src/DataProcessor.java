import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // Устанавливаем цикл жизни аннотации в рантайме
@Target(ElementType.METHOD) // Аннотация может быть применена только к методам
public @interface DataProcessor {
    String comment() default ""; // Описание аннотации, имеет параметр comment по умолчанию
}
