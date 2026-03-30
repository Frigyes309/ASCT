

/*
WARNING: THIS FILE IS AUTO-GENERATED. DO NOT MODIFY.

This file was generated from .idl 
using RTI Code Generator (rtiddsgen) version 4.3.0.
The rtiddsgen tool is part of the RTI Connext DDS distribution.
For more information, type 'rtiddsgen -help' at a command shell
or consult the Code Generator User's Manual.
*/

package hu.bme.mit.inf.cps.demopublisher.shape;

import com.rti.dds.infrastructure.*;
import com.rti.dds.infrastructure.Copyable;
import java.io.Serializable;
import com.rti.dds.cdr.CdrHelper;
// Depending on the type represented in the IDL, we may perform some redundant
// casts, we are suppressing that warning
@SuppressWarnings("cast")
public class ShapeType   implements Copyable, Serializable{

    private static final long serialVersionUID = -832135678L;

    public String color= (String)""; /* maximum length = (128) */
    public int x = (int)0;
    public int y = (int)0;
    public int shapesize = (int)0;

    public ShapeType() {

    }
    public ShapeType (ShapeType other) {

        this();
        copy_from(other);
    }

    public static java.lang.Object create() {

        ShapeType self;
        self = new  ShapeType();
        self.clear();
        return self;

    }

    public void clear() {

        color = (String)"";
        x = (int)0;
        y = (int)0;
        shapesize = (int)0;
    }

    @Override
    public boolean equals(java.lang.Object o) {

        if (o == null) {
            return false;
        }        

        if(getClass() != o.getClass()) {
            return false;
        }

        ShapeType otherObj = (ShapeType)o;

        if(!this.color.equals(otherObj.color)) {
            return false;
        }
        if(this.x != otherObj.x) {
            return false;
        }
        if(this.y != otherObj.y) {
            return false;
        }
        if(this.shapesize != otherObj.shapesize) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int __prime = 31;
        int __result = 1;
        __result = __prime * __result + color.hashCode(); 
        __result = __prime * __result + (int)x;
        __result = __prime * __result + (int)y;
        __result = __prime * __result + (int)shapesize;
        return __result;
    }

    /**
    * This is the implementation of the <code>Copyable</code> interface.
    * This method will perform a deep copy of <code>src</code>
    * This method could be placed into <code>ShapeTypeTypeSupport</code>
    * rather than here by using the <code>-noCopyable</code> option
    * to rtiddsgen.
    * 
    * @param src The Object which contains the data to be copied.
    * @return Returns <code>this</code>.
    * @exception NullPointerException If <code>src</code> is null.
    * @exception ClassCastException If <code>src</code> is not the 
    * same type as <code>this</code>.
    * @see com.rti.dds.infrastructure.Copyable#copy_from(java.lang.Object)
    */
    public java.lang.Object copy_from(java.lang.Object src) {

        ShapeType typedSrc = (ShapeType) src;
        ShapeType typedDst = this;

        typedDst.color = typedSrc.color;
        typedDst.x = typedSrc.x;
        typedDst.y = typedSrc.y;
        typedDst.shapesize = typedSrc.shapesize;

        return this;
    }

    @Override
    public java.lang.String toString(){
        return toString("", 0);
    }

    public java.lang.String toString(java.lang.String desc, int indent) {
        java.lang.StringBuffer strBuffer = new java.lang.StringBuffer();

        if (desc != null) {
            CdrHelper.printIndent(strBuffer, indent);
            strBuffer.append(desc).append(":\n");
        }

        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("color: ").append(this.color).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("x: ").append(this.x).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("y: ").append(this.y).append("\n");  
        CdrHelper.printIndent(strBuffer, indent+1);        
        strBuffer.append("shapesize: ").append(this.shapesize).append("\n");  

        return strBuffer.toString();
    }

}
