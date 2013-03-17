
package com.practice.vaadin_spring;

import org.springframework.stereotype.Component;

@Component
public class TextLabelService {

    private static int instanceId = 0;

    public TextLabelService() {
        instanceId++;
    }

    public String getInstanceText() {
        return "TextLabelService instanceId: " + instanceId;
    }
}
