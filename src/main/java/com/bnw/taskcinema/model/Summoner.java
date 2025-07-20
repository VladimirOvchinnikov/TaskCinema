package com.bnw.taskcinema.model;

import com.bnw.taskcinema.model.common.StringFieldValue;
import com.bnw.taskcinema.model.common.converter.EchoFieldValueConverter;
import com.bnw.taskcinema.model.common.converter.StringFieldValueConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "summoners")
public class Summoner extends AbstractEntity {

    @Column(name = "name")
    @Convert(converter = StringFieldValueConverter.class)
    private StringFieldValue name = new StringFieldValue();


//    @Column(name = "echo_id")
//    private Integer echoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "echo_id")
    @Convert(converter = EchoFieldValueConverter.class)
    private Echo echo;

    @PostPersist
    public void iii(){
        System.out.println("asdadasd");
    }


    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public Echo getEcho() {
        return echo;
    }

    public void setEcho(Echo echo) {
        this.echo = echo;
    }
}
