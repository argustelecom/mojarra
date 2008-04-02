/*
 * $Id: UISelectItemTestCase.java,v 1.6 2003/11/07 18:55:38 craigmcc Exp $
 */

/*
 * Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 * SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.faces.component;


import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.TestUtil;
import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;


/**
 * <p>Unit tests for {@link UISelectItem}.</p>
 */

public class UISelectItemTestCase extends ValueHolderTestCaseBase {


    // ------------------------------------------------------------ Constructors


    /**
     * Construct a new instance of this test case.
     *
     * @param name Name of the test case
     */
    public UISelectItemTestCase(String name) {
        super(name);
    }


    // ---------------------------------------------------- Overall Test Methods


    // Set up instance variables required by this test case.
    public void setUp() {
        super.setUp();
        component = new UISelectItem();
        expectedRendererType = null;
    }

    
    // Return the tests included in this test case.
    public static Test suite() {
        return (new TestSuite(UISelectItemTestCase.class));
    }


    // Tear down instance variables required by ths test case
    public void tearDown() {
        super.tearDown();
    }


    // ------------------------------------------------- Individual Test Methods


    // Test attribute-property transparency
    public void testAttributesTransparency() {

        super.testAttributesTransparency();
        UISelectItem selectItem = (UISelectItem) component;

        assertEquals(selectItem.getItemDescription(),
                     (String) selectItem.getAttributes().get("itemDescription"));
        selectItem.setItemDescription("foo");
        assertEquals("foo", (String) selectItem.getAttributes().get("itemDescription"));
        selectItem.setItemDescription(null);
        assertNull((String) selectItem.getAttributes().get("itemDescription"));
        selectItem.getAttributes().put("itemDescription", "bar");
        assertEquals("bar", selectItem.getItemDescription());
        selectItem.getAttributes().put("itemDescription", null);
        assertNull(selectItem.getItemDescription());

        assertEquals(selectItem.getItemLabel(),
                     (String) selectItem.getAttributes().get("itemLabel"));
        selectItem.setItemLabel("foo");
        assertEquals("foo", (String) selectItem.getAttributes().get("itemLabel"));
        selectItem.setItemLabel(null);
        assertNull((String) selectItem.getAttributes().get("itemLabel"));
        selectItem.getAttributes().put("itemLabel", "bar");
        assertEquals("bar", selectItem.getItemLabel());
        selectItem.getAttributes().put("itemLabel", null);
        assertNull(selectItem.getItemLabel());

        assertEquals(selectItem.getItemValue(),
                     (String) selectItem.getAttributes().get("itemValue"));
        selectItem.setItemValue("foo");
        assertEquals("foo", (String) selectItem.getAttributes().get("itemValue"));
        selectItem.setItemValue(null);
        assertNull((String) selectItem.getAttributes().get("itemValue"));
        selectItem.getAttributes().put("itemValue", "bar");
        assertEquals("bar", selectItem.getItemValue());
        selectItem.getAttributes().put("itemValue", null);
        assertNull(selectItem.getItemValue());

    }


    // Test a pristine UISelectItem instance
    public void testPristine() {

        super.testPristine();
        UISelectItem selectItem = (UISelectItem) component;

        assertNull("no itemDescription", selectItem.getItemDescription());
        assertNull("no itemLabel", selectItem.getItemLabel());
        assertNull("no itemValue", selectItem.getItemValue());

    }


    // Test setting properties to invalid values
    public void testPropertiesInvalid() throws Exception {

        super.testPropertiesInvalid();
        UISelectItem selectItem = (UISelectItem) component;

    }


    // Test setting properties to valid values
    public void testPropertiesValid() throws Exception {

        super.testPropertiesValid();
        UISelectItem selectItem = (UISelectItem) component;

        selectItem.setItemDescription("foo");
        assertEquals("foo", selectItem.getItemDescription());
        selectItem.setItemDescription(null);
        assertNull(selectItem.getItemDescription());

        selectItem.setItemLabel("foo");
        assertEquals("foo", selectItem.getItemLabel());
        selectItem.setItemLabel(null);
        assertNull(selectItem.getItemLabel());

        selectItem.setItemValue("foo");
        assertEquals("foo", selectItem.getItemValue());
        selectItem.setItemValue(null);
        assertNull(selectItem.getItemValue());

    }


    public void testValueBindings() {

	super.testValueBindings();
	UISelectItem test = (UISelectItem) component;

	// "itemDescription" property
	request.setAttribute("foo", "bar");
	test.setItemDescription(null);
	assertNull(test.getItemDescription());
	test.setValueBinding("itemDescription", application.getValueBinding("#{foo}"));
	assertNotNull(test.getValueBinding("itemDescription"));
	assertEquals("bar", test.getItemDescription());
	test.setItemDescription("baz");
	assertEquals("baz", test.getItemDescription());
	test.setItemDescription(null);
	assertEquals("bar", test.getItemDescription());
	test.setValueBinding("itemDescription", null);
	assertNull(test.getValueBinding("itemDescription"));
	assertNull(test.getItemDescription());

	// "itemLabel" property
	request.setAttribute("foo", "bar");
	test.setItemLabel(null);
	assertNull(test.getItemLabel());
	test.setValueBinding("itemLabel", application.getValueBinding("#{foo}"));
	assertNotNull(test.getValueBinding("itemLabel"));
	assertEquals("bar", test.getItemLabel());
	test.setItemLabel("baz");
	assertEquals("baz", test.getItemLabel());
	test.setItemLabel(null);
	assertEquals("bar", test.getItemLabel());
	test.setValueBinding("itemLabel", null);
	assertNull(test.getValueBinding("itemLabel"));
	assertNull(test.getItemLabel());

	// "itemValue" property
	request.setAttribute("foo", "bar");
	test.setItemValue(null);
	assertNull(test.getItemValue());
	test.setValueBinding("itemValue", application.getValueBinding("#{foo}"));
	assertNotNull(test.getValueBinding("itemValue"));
	assertEquals("bar", test.getItemValue());
	test.setItemValue("baz");
	assertEquals("baz", test.getItemValue());
	test.setItemValue(null);
	assertEquals("bar", test.getItemValue());
	test.setValueBinding("itemValue", null);
	assertNull(test.getValueBinding("itemValue"));
	assertNull(test.getItemValue());

    }


    // --------------------------------------------------------- Support Methods


    // Check that the properties on the specified components are equal
    protected void checkProperties(UIComponent comp1, UIComponent comp2) {

        super.checkProperties(comp1, comp2);
        UISelectItem si1 = (UISelectItem) comp1;
        UISelectItem si2 = (UISelectItem) comp2;
        assertEquals(si1.getItemDescription(), si2.getItemDescription());
        assertEquals(si1.getItemLabel(), si2.getItemLabel());
        assertEquals(si1.getItemValue(), si2.getItemValue());

    }


    // Create a pristine component of the type to be used in state holder tests
    protected UIComponent createComponent() {
        UIComponent component = new UISelectItem();
        component.setRendererType(null);
        return (component);
    }


    // Populate a pristine component to be used in state holder tests
    protected void populateComponent(UIComponent component) {
        super.populateComponent(component);
        UISelectItem si = (UISelectItem) component;
        si.setItemDescription("item description");
        si.setItemLabel("item label");
        si.setItemValue("item value");
    }


}
