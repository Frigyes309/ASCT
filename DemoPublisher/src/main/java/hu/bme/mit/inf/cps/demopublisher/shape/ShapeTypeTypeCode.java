
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

public class  ShapeTypeTypeCode {

    public static final TypeCode VALUE_WO_MEMBERS = getTypeCodeWOMembers();

    // We need a type code without member in case of recursion
    @SuppressWarnings("cast")
    public static TypeCode getTypeCodeWOMembers() {
        TypeCode tc = null;
        StructMember sm[]=new StructMember[0];
        Annotations annotation = new Annotations();
        annotation.allowed_data_representation_mask(5);
        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("ShapeType",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm , annotation);        return tc;
    }

    public static final TypeCode VALUE = getTypeCode();

    // Depending on the type represented in the IDL, we may perform some redundant
    // casts, we are suppressing that warning
    @SuppressWarnings("cast")
    private static TypeCode getTypeCode() {
        TypeCode tc = null;
        int __i=0;
        StructMember sm[]=new StructMember[4];
        Annotations memberAnnotation;

        memberAnnotation = new Annotations();
        memberAnnotation.default_annotation(AnnotationParameterValue.EMPTY_STRING);
        sm[__i] = new  StructMember("color", false, (short)-1, true, new TypeCode(TCKind.TK_STRING,128), 0, false, memberAnnotation);__i++;
        memberAnnotation = new Annotations();
        memberAnnotation.default_annotation(AnnotationParameterValue.ZERO_LONG);
        memberAnnotation.min_annotation(AnnotationParameterValue.MIN_LONG);
        memberAnnotation.max_annotation(AnnotationParameterValue.MAX_LONG);
        sm[__i] = new  StructMember("x", false, (short)-1,  false, TypeCode.TC_LONG, 1, false, memberAnnotation);__i++;
        memberAnnotation = new Annotations();
        memberAnnotation.default_annotation(AnnotationParameterValue.ZERO_LONG);
        memberAnnotation.min_annotation(AnnotationParameterValue.MIN_LONG);
        memberAnnotation.max_annotation(AnnotationParameterValue.MAX_LONG);
        sm[__i] = new  StructMember("y", false, (short)-1,  false, TypeCode.TC_LONG, 2, false, memberAnnotation);__i++;
        memberAnnotation = new Annotations();
        memberAnnotation.default_annotation(AnnotationParameterValue.ZERO_LONG);
        memberAnnotation.min_annotation(AnnotationParameterValue.MIN_LONG);
        memberAnnotation.max_annotation(AnnotationParameterValue.MAX_LONG);
        sm[__i] = new  StructMember("shapesize", false, (short)-1,  false, TypeCode.TC_LONG, 3, false, memberAnnotation);__i++;

        Annotations annotation = new Annotations();
        annotation.allowed_data_representation_mask(5);

        tc = TypeCodeFactory.TheTypeCodeFactory.create_struct_tc("ShapeType",ExtensibilityKind.EXTENSIBLE_EXTENSIBILITY,  sm , annotation);        
        return tc;
    }
}

