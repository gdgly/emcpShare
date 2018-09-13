package Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Test1 {

    public static <T> Class<T> getClz(Class clz) {
        Type type = clz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType) type;
            Type[] types = ptype.getActualTypeArguments();
            for (Type t : types) {
                System.out.println(t.toString());
            }
            if (types.length > 0 && types[0] instanceof Class) {
                return (Class) types[0];
            }
        }
        return (Class) Object.class;
    }

}
