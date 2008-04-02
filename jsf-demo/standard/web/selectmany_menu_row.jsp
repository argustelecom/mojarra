<!--
 Copyright 2003 Sun Microsystems, Inc. All rights reserved.
 SUN PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
-->

				<tr>
					<td>Multi-select menu:</td>
					<td><h:selectmany_menu id="ManyApples" >
						<f:selectitem itemValue="0" itemLabel="zero" />
						<f:selectitem itemValue="1" itemLabel="one" />
						<f:selectitem itemValue="2" itemLabel="two" />
						<f:selectitem itemValue="3" itemLabel="three" />
						<f:selectitem itemValue="4" itemLabel="four"  />
						<f:selectitem itemValue="5" itemLabel="five" />
						<f:selectitem itemValue="6" itemLabel="six" />
						<f:selectitem itemValue="7" itemLabel="seven" />
						<f:selectitem itemValue="8" itemLabel="eight" />
						<f:selectitem itemValue="9" itemLabel="nine" />
					</h:selectmany_menu></td>
				</tr>
				<tr>
					<td>Multi-select menumodel:</td>
					<td><h:selectmany_menu id="menumodel" >
						<f:selectitems id="menumodelitems"
							value="#{LoginBean.options}" />
					</h:selectmany_menu></td>
				</tr>

                                <tr>
					<td>Multi-select menumodel with options of the type java.lang.Long:</td>
					<td><h:selectmany_menu id="menuLongmodel"
                                               value="#{LoginBean.currentLongOptions}">
                                               
						<f:selectitems id="menumodelonglitems"
							value="#{LoginBean.longList}" />
					</h:selectmany_menu></td>
				</tr>

                                <tr>
					<td>Multi-select menumodel Group:</td>
					<td><h:selectmany_menu id="listGroup"
                                                value="#{LoginBean.currentOptions}">
						<f:selectitems id="menumodelitemsGroup"
							value="#{LoginBean.optionsGroup}" />
					</h:selectmany_menu></td>
				</tr>
