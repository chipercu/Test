package org.example.MonitoringRefactoring;

public class Q {

    public static void main(String[] args) {
        System.out.println(ControlType.BUTTON.value);
    }

    enum ControlType{
        BUTTON("Button"),
        RADIO_BUTTON("RadioButton"),
        MENU_ITEM("MenuItem"),
        CHECK_BOX("CheckBox"),
        TITLE_BAR("TitleBar"),
        HYPERLINK("Hyperlink"),
        LIST_ITEM("ListItem"),
        LIST("List"),
        COMBO_BOX("ComboBox"),
        TREE_ITEM("TreeItem"),
        GROUP("Group"),
        TEXT("Text"),
        EDIT("Edit"),
        IMAGE("Image"),
        PANE("Pane"),
        TOOL_BAR("ToolBar"),
        DATA_ITEM("DataItem"),
        DOCUMENT("Document"),
        TAB_ITEM("TabItem"),
        WINDOW("Window");


        final String value;

        ControlType(String window) {
            this.value = window;
        }
    }


}
