package by.milosh.converting.impl;

import by.milosh.converting.DateToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@PropertySource(value = "classpath:util.properties")
public class DateToStringImpl implements DateToString {
    @Value("${dateFormat}")
    private String dateFormat;

    @Override
    public String execute(Date date) {
        DateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(date);
    }
}
