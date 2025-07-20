package com.bnw.taskcinema.model;

import com.bnw.taskcinema.model.common.*;
import com.bnw.taskcinema.model.common.converter.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "echo")
public class Echo extends AbstractEntity {

    @Column(name = "name")
    @Convert(converter = StringFieldValueConverter.class)
    private StringFieldValue name = new StringFieldValue();
    @Column(name = "is_loves_Narcissus")
    @Convert(converter = BooleanFieldValueConverter.class)
    private BooleanFieldValue isLovesNarcissus = new BooleanFieldValue();
    @Column(name = "birthday")
    @Convert(converter = LocalDateFieldValueConverter.class)
    private LocalDateFieldValue birthday = new LocalDateFieldValue();
    @Column(name = "start_check")
    @Convert(converter = LocalTimeFieldValueConverter.class)
    private LocalTimeFieldValue startCheck = new LocalTimeFieldValue();
    @Column(name = "repeat")
    @Convert(converter = IntegerFieldValueConverter.class)
    private IntegerFieldValue repeat = new IntegerFieldValue();



    public String getName() {
        return name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public Boolean getIsLovesNarcissus() {
        return isLovesNarcissus.getValue();
    }

    public void setIsLovesNarcissus(Boolean lovesNarcissus) {
        isLovesNarcissus.setValue(lovesNarcissus);
    }

    public LocalDate getBirthday() {
        return birthday.getValue();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.setValue(birthday);
    }

    public LocalTime getStartCheck() {
        return startCheck.getValue();
    }

    public void setStartCheck(LocalTime startCheck) {
        this.startCheck.setValue(startCheck);
    }


    public Integer getRepeat() {
        return repeat.getValue();
    }

    public void setRepeat(Integer repeat) {
        this.repeat.setValue(repeat);
    }
}
