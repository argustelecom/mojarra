/*
 * $Id: ImageRenderer.java,v 1.46 2006/05/17 19:00:48 rlubke Exp $
 */

/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 * 
 * You can obtain a copy of the License at
 * https://javaserverfaces.dev.java.net/CDDL.html or
 * legal/CDDLv1.0.txt. 
 * See the License for the specific language governing
 * permission and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at legal/CDDLv1.0.txt.    
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * [Name of File] [ver.__] [Date]
 * 
 * Copyright 2005 Sun Microsystems Inc. All Rights Reserved
 */

// ImageRenderer.java

package com.sun.faces.renderkit.html_basic;

import com.sun.faces.util.MessageUtils;
import com.sun.faces.RIConstants;
import com.sun.faces.renderkit.RenderKitUtils;

import java.util.logging.Level;

import javax.faces.component.UIComponent;
import javax.faces.component.UIGraphic;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import java.io.IOException;

/**
 * <B>ImageRenderer</B> is a class that handles the rendering of the graphic
 * ImageTag
 *
 * @version $Id: ImageRenderer.java,v 1.46 2006/05/17 19:00:48 rlubke Exp $
 */

public class ImageRenderer extends HtmlBasicRenderer {

    //
    // Protected Constants
    //
   
    //
    // Class Variables
    //

    //
    // Instance Variables
    //

    // Attribute Instance Variables


    // Relationship Instance Variables

    //
    // Constructors and Initializers    
    //

    public ImageRenderer() {
        super();
    }

    //
    // Class methods
    //

    //
    // General Methods
    //

    //
    // Methods From Renderer
    //

    public void encodeBegin(FacesContext context, UIComponent component)
        throws IOException {
        if (context == null) {
            throw new NullPointerException(
                MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID, "context"));
        }
        if (component == null) {
            throw new NullPointerException(
                MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID, "component"));
        }
    }


    public void encodeEnd(FacesContext context, UIComponent component)
        throws IOException {
        ResponseWriter writer = null;
        String styleClass = null;

        if (context == null) {
            throw new NullPointerException(
                MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID, "context"));
        }
        if (component == null) {
            throw new NullPointerException(
                MessageUtils.getExceptionMessageString(MessageUtils.NULL_PARAMETERS_ERROR_MESSAGE_ID, "component"));
        }

        if (logger.isLoggable(Level.FINER)) {
            logger.log(Level.FINER,"Begin encoding component " + component.getId());
        }
        // suppress rendering if "rendered" property on the component is
        // false.
        if (!component.isRendered()) {
            if (logger.isLoggable(Level.FINE)) {
                 logger.fine("End encoding component " +
                          component.getId() + " since " +
                          "rendered attribute is set to false ");
            }
            return;
        }

        writer = context.getResponseWriter();
        assert (writer != null);

        writer.startElement("img", component);
        writeIdAttributeIfNecessary(context, writer, component);
        writer.writeURIAttribute("src", src(context, component), "value");
	// if we're writing XHTML and we have a null alt attribute
	if (writer.getContentType().equals(RIConstants.XHTML_CONTENT_TYPE) && 
	    null == component.getAttributes().get("alt")) {
	    // write out an empty alt
	    writer.writeAttribute("alt", "", "alt");
	}

        RenderKitUtils.renderPassThruAttributes(context, writer, component); 
        RenderKitUtils.renderXHTMLStyleBooleanAttributes(writer, component);
        if (null != (styleClass = (String)
            component.getAttributes().get("styleClass"))) {
            writer.writeAttribute("class", styleClass, "styleClass");
        }
        writer.endElement("img");
        if (logger.isLoggable(Level.FINER)) {
            logger.log(Level.FINER,"End encoding component " + component.getId());
        }
    }


    private String src(FacesContext context, UIComponent component) {
        String value = (String) ((UIGraphic) component).getValue();
        if (value == null) {
            return "";
        }
        value = context.getApplication().getViewHandler().
            getResourceURL(context, value);
        return (context.getExternalContext().encodeResourceURL(value));
    }
    
    // The testcase for this class is TestRenderers_2.java 

} // end of class ImageRenderer


