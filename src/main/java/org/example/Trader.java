package org.example;

import javax.xml.bind.annotation.*;
import java.util.List;


@XmlRootElement(name = "Trader")
@XmlType(propOrder = {"npc", "shop", "markup"})
public class Trader {

    @XmlAttribute
    private int npc;
    @XmlAttribute
    private int shop;
    @XmlAttribute
    private int markup;

}
