/*
 * Copyright 2000-2014 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.tests.components.grid.basicfeatures.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.vaadin.tests.components.grid.basicfeatures.GridBasicFeaturesTest;

public class GridEditorRowTest extends GridBasicFeaturesTest {

    @Before
    public void setUp() {
        openTestURL();
        selectMenuPath("Component", "Editor row", "Enabled");
    }

    @Test
    public void testKeyboardOpeningClosing() {

        getGridElement().getCell(4, 0).click();

        new Actions(getDriver()).sendKeys(Keys.ENTER).perform();

        assertNotNull(getEditorRow());

        new Actions(getDriver()).sendKeys(Keys.ESCAPE).perform();
        assertNull(getEditorRow());

        // Disable editor row
        selectMenuPath("Component", "Editor row", "Enabled");

        getGridElement().getCell(5, 0).click();
        new Actions(getDriver()).sendKeys(Keys.ENTER).perform();
        assertNull(getEditorRow());
    }
}
