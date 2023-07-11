package org.example.HZ;

import java.util.Objects;
import java.util.Optional;

public class ObjectAS {

    private String asdasdad;
    private Integer sdfsadf;

    public ObjectAS() {


    }



    public String getAsdasdad() {
        return Optional.ofNullable(asdasdad).orElseGet(() -> "Пусто");
    }

    public void setAsdasdad(String asdasdad) {
        this.asdasdad = asdasdad;
    }

    public Integer getSdfsadf() {
        return sdfsadf;
    }

    public void setSdfsadf(Integer sdfsadf) {
        this.sdfsadf = sdfsadf;
    }

}
