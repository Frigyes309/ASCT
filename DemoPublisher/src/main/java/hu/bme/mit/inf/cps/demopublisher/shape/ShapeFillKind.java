

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl 
using RTI Code Generator (rtiddsgen) version 4.3.0.
The rtiddsgen tool is part of the RTI Connext DDS distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the Code Generator User's Manual.
*/

package hu.bme.mit.inf.cps.demopublisher.shape;

import com.rti.dds.util.Enum;
import com.rti.dds.cdr.CdrHelper;
import java.util.Arrays;
import java.io.ObjectStreamException;
// Depending on the type represented in the IDL, we may perform some redundant
// casts, we are suppressing that warning
@SuppressWarnings("cast")
public class ShapeFillKind  extends Enum {

    private static final long serialVersionUID = -2015382602L;

    public static final ShapeFillKind SOLID_FILL = new ShapeFillKind("SOLID_FILL", 0);
    public static final int _SOLID_FILL = 0;
    public static final ShapeFillKind TRANSPARENT_FILL = new ShapeFillKind("TRANSPARENT_FILL", 1);
    public static final int _TRANSPARENT_FILL = 1;
    public static final ShapeFillKind HORIZONTAL_HATCH_FILL = new ShapeFillKind("HORIZONTAL_HATCH_FILL", 2);
    public static final int _HORIZONTAL_HATCH_FILL = 2;
    public static final ShapeFillKind VERTICAL_HATCH_FILL = new ShapeFillKind("VERTICAL_HATCH_FILL", 3);
    public static final int _VERTICAL_HATCH_FILL = 3;
    public static ShapeFillKind valueOf(int ordinal) {
        switch(ordinal) {

            case 0: return ShapeFillKind.SOLID_FILL;
            case 1: return ShapeFillKind.TRANSPARENT_FILL;
            case 2: return ShapeFillKind.HORIZONTAL_HATCH_FILL;
            case 3: return ShapeFillKind.VERTICAL_HATCH_FILL;

        }
        return null;
    }

    public static ShapeFillKind from_int(int __value) {
        return valueOf(__value);
    }

    public static int[] getOrdinals() {
        int i = 0;
        int[] values = new int[4];

        values[i] = SOLID_FILL.ordinal();
        i++;
        values[i] = TRANSPARENT_FILL.ordinal();
        i++;
        values[i] = HORIZONTAL_HATCH_FILL.ordinal();
        i++;
        values[i] = VERTICAL_HATCH_FILL.ordinal();
        i++;

        return values;
    }

    public int value() {
        return super.ordinal();
    }

    /**
    * Create a default instance
    */  
    public static ShapeFillKind create() {

        return valueOf(0);
    }

    /**
    * Print Method
    */     
    public java.lang.String toString(java.lang.String desc, int indent) {
        java.lang.StringBuffer strBuffer = new java.lang.StringBuffer();

        CdrHelper.printIndent(strBuffer, indent);

        if (desc != null) {
            strBuffer.append(desc).append(": ");
        }

        strBuffer.append(this);
        strBuffer.append("\n");              
        return strBuffer.toString();
    }

    private java.lang.Object readResolve() throws ObjectStreamException {
        return valueOf(ordinal());
    }

    private ShapeFillKind(java.lang.String name, int ordinal) {
        super(name, ordinal);
    }
}

