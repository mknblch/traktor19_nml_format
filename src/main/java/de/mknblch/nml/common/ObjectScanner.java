package de.mknblch.nml.common;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by mknblch on 05.09.2015.
 */
public class ObjectScanner {

    public interface PrimitiveVisitor {
        void visit(Field field, Object o, int depth);
    }

    public interface CollectionVisitor {
        boolean visit(Field field, Collection<?> collection, int depth);
    }

    public interface ElementVisitor {
        boolean visit(Collection<?> collection, Object element, int index, int depth);
    }

    public interface ObjectVisitor {
        boolean visit(Field field, Object o, int depth);
    }

    private PrimitiveVisitor primitiveVisitor = (field, o, depth) -> {};
    private CollectionVisitor collectionVisitor = (field, collection, depth) -> false;
    private ElementVisitor elementVisitor = (collection, element, index, depth) -> false;
    private ObjectVisitor objectVisitor = (field, o, depth) -> false;

    public ObjectScanner setPrimitiveVisitor(PrimitiveVisitor primitiveVisitor) {
        this.primitiveVisitor = primitiveVisitor;
        return this;
    }

    public ObjectScanner setObjectVisitor(ObjectVisitor objectVisitor) {
        this.objectVisitor = objectVisitor;
        return this;
    }

    public ObjectScanner setCollectionVisitor(CollectionVisitor collectionVisitor) {
        this.collectionVisitor = collectionVisitor;
        return this;
    }

    public ObjectScanner setElementVisitor(ElementVisitor elementVisitor) {
        this.elementVisitor = elementVisitor;
        return this;
    }

    public ObjectScanner scan(Object o) {
        scan(null, o, 0);
        return this;
    }

    private void scan(Field field, Object o, int depth) {
        final Class<?> clazz = getMostSignificantOf(field, o);
        if (isPrintable(clazz)) {
            primitiveVisitor.visit(field, o, depth);
        } else if (Collection.class.isAssignableFrom(clazz)) {
            scanCollection(field, (Collection) o, depth);
        } else {
            scanElement(field, o, depth, clazz);
        }
    }

    private void scanElement(Field field, Object o, int depth, Class<?> clazz) {
        if (!objectVisitor.visit(field, o, depth)) {
            return;
        }
        if (null == o) {
            return;
        }
        Arrays.stream(clazz.getDeclaredFields())
                .forEach(f -> {
                    try {
                        f.setAccessible(true);
                        scan(f, f.get(o), depth + 1);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    private void scanCollection(Field field, Collection collection, int depth) {
        if(!collectionVisitor.visit(field, collection, depth) || null == collection) {
            return;
        }
        int index = 0;
        for (Object element : collection) {
            if (elementVisitor.visit(collection, element, index++, depth))
            scan(null, element, depth+1);
        }
    }

    private Class<?> getMostSignificantOf(Field field, Object o) {
        final Class<?> clazz;
        if (null != field) clazz = field.getType();
        else if (null != o) clazz = o.getClass();
        else clazz = null;
        return clazz;
    }

    private boolean isPrintable(Class<?> clazz) {

        return null == clazz || Arrays.asList(
                    Class.class,
                    String.class,
                    Boolean.class, Boolean.TYPE,
                    Byte.class, Byte.TYPE,
                    Short.class, Short.TYPE,
                    Character.class, Character.TYPE,
                    Float.class, Float.TYPE,
                    Integer.class, Integer.TYPE,
                    Double.class, Double.TYPE,
                    Long.class, Long.TYPE,
                    BigInteger.class, BigDecimal.class)
                .stream()
                .anyMatch(c -> c.isAssignableFrom(clazz));
    }
}
