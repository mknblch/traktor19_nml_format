package de.mknblch.nml.common;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by mknblch on 06.09.2015.
 */
public class ObjectDump {

    public static final ObjectDump INSTANCE = new ObjectDump();

    public static String NL = "\n";

    private final ObjectScanner scanner;
    private final StringBuilder builder;
    private boolean showType = false;
    private int indent = 3;

    public ObjectDump() {
        scanner = new ObjectScanner()
                .setPrimitiveVisitor(this::visitPrimitive)
                .setCollectionVisitor(this::visitCollection)
                .setElementVisitor(this::visitElement)
                .setObjectVisitor(this::visitObject);

        builder = new StringBuilder();
    }

    public ObjectDump setShowType(boolean showType) {
        this.showType = showType;
        return this;
    }

    private boolean visitElement(Collection<?> collection, Object element, int index, int depth) {
        return true;
    }

    private boolean visitObject(Field field, Object o, int depth) {
        if (null == field) {
            builder.append(space(depth));
            if (showType) {
                builder.append("<")
                        .append(o.getClass().getSimpleName())
                        .append("> ");
            }
            builder.append(o);
            builder.append(NL);
        } else {
            builder.append(space(depth));
            if (showType) {
                builder.append("<")
                        .append(field.getType().getSimpleName())
                        .append("> ");
            }
            builder.append(field.getName())
                    .append(" = ")
                    .append(o)
                    .append(NL);
        }
        return true;
    }

    private boolean visitCollection(Field field, Collection<?> objects, int depth) {
        if (null == field) {
            builder.append(space(depth))
                    .append(objects.getClass())
                    .append(" [")
                    .append(objects.size())
                    .append("]")
                    .append(NL);
        } else if (null == objects) {
            builder.append(space(depth));
            if (showType) {
                builder.append("<")
                        .append(field.getType().getSimpleName())
                        .append("> ");
            }
            builder.append(field.getName())
                    .append(" : null")
                    .append(NL);
        } else {
            builder.append(space(depth));
            if (showType) {
                builder.append("<")
                        .append(field.getType().getSimpleName())
                        .append("> ");
            }
            builder.append(field.getName())
                    .append(" [")
                    .append(objects.size())
                    .append("]")
                    .append(NL);
        }
        return true;
    }

    private void visitPrimitive(Field field, Object o, int depth) {
        if (null == field) {
            builder.append(space(depth));
            if (showType && o != null) {
                builder.append("<")
                        .append(o.getClass().getSimpleName())
                        .append("> ");
            }
            builder.append(formatPrimitive(o))
                    .append(NL);
        } else {
            builder.append(space(depth));
            if (showType) {
                builder.append("<")
                        .append(field.getType().getSimpleName())
                        .append("> ");
            }
            builder.append(field.getName())
                    .append(" = ")
                    .append(formatPrimitive(o))
                    .append(NL);
        }
    }

    private String formatPrimitive(Object o) {
        return o instanceof String ? String.format("'%s'", o) : String.valueOf(o);
    }

    private String space(int n) {
        return IntStream.range(0, n * indent).mapToObj(i -> " ").collect(Collectors.joining());
    }

    public ObjectDump setIndent(int indent) {
        this.indent = indent;
        return this;
    }

    public ObjectDump scan(Object... os) {
        for (Object o : os) {
            scanner.scan(o);
        }
        return this;
    }

    public String getDump() {
        return builder.toString();
    }

    public ObjectDump reset() {
        builder.setLength(0);
        return this;
    }

    public ObjectDump printDump() {
        System.out.println(getDump());
        return this;
    }

    public static void dump(Object... objects) {
        INSTANCE.reset()
                .scan(objects)
                .printDump();
    }
}
