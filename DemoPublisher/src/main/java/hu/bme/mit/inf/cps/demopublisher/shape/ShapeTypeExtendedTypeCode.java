
/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl 
using RTI Code Generator (rtiddsgen) version 4.3.0.
The rtiddsgen tool is part of the RTI Connext DDS distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the Code Generator User's Manual.
*/

package hu.bme.mit.inf.cps.demopublisher.shape;

import com.rti.dds.typecode.*;

public class  ShapeTypeExtendedTypeCode {

    public static final TypeCode VALUE_WO_MEMBERS = getTypeCodeWOMembers();

    // We need a type code without member in case of recursion
    @SuppressWarnings("cast")
    public static TypeCode getTypeCodeWOMembers() {
        TypeCode tc = null;
        ValueMember sm[]=new ValueMember[0];
        Annotations annotation = new Annotations();
        annotation.allowed_data_representation_mask(5);
        tc = TypeCodeFactory.TheTypeCodeFactory.create_value_tc("ShapeTypeExtended",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY, VM_NONE.VALUE,hu.bme.mit.inf.cps.demopublisher.shape.ShapeTypeTypeCode.VALUE
        , sm , annotation);        return tc;
    }

    public static final TypeCode VALUE = getTypeCode();

    // Depending on the type represented in the IDL, we may perform some redundant
    // casts, we are suppressing that warning
    @SuppressWarnings("cast")
    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        ValueMember sm[]=new ValueMember[2];
        Annotations memberAnnotation;

        memberAnnotation = new Annotations();
        memberAnnotation.default_annotation(new AnnotationParameterValue(TCKind.TK_LONG, (int) (0)));
        memberAnnotation.min_annotation(AnnotationParameterValue.MIN_LONG);
        memberAnnotation.max_annotation(AnnotationParameterValue.MAX_LONG);
        sm[__i] = new  ValueMember("fillKind", false, (short)-1,  false,PUBLIC_MEMBER.VALUE, hu.bme.mit.inf.cps.demopublisher.shape.ShapeFillKindTypeCode.VALUE
        , 4, false, memberAnnotation);__i++;
        memberAnnotation = new Annotations();
        memberAnnotation.default_annotation(AnnotationParameterValue.ZERO_FLOAT);
        memberAnnotation.min_annotation(AnnotationParameterValue.MIN_FLOAT);
        memberAnnotation.max_annotation(AnnotationParameterValue.MAX_FLOAT);
        sm[__i] = new  ValueMember("angle", false, (short)-1,  false,PUBLIC_MEMBER.VALUE, TypeCode.TC_FLOAT, 5, false, memberAnnotation);__i++;

        Annotations annotation = new Annotations();
        annotation.allowed_data_representation_mask(5);

        tc = TypeCodeFactory.TheTypeCodeFactory.create_value_tc("ShapeTypeExtended",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY, VM_NONE.VALUE,hu.bme.mit.inf.cps.demopublisher.shape.ShapeTypeTypeCode.VALUE
        , sm , annotation);        
        return tc;
    }
}

