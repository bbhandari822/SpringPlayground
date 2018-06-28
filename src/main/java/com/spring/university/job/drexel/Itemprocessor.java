package com.spring.university.job.drexel;

import com.spring.university.domain.DrexelDomain;
import com.spring.outputFileDomain.HeadersField;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Binod Bhandari on 6/19/18.
 */

public class Itemprocessor implements ItemProcessor<DrexelDomain, HeadersField> {

    @Override
    public HeadersField process(DrexelDomain item) throws Exception {

        HeadersField headersField = new HeadersField();
        headersField.setItemOne(item.getItemOne());
        headersField.setItemTwo(item.getItemTwo());
        headersField.setItemFive(item.getItemFive());
        return headersField;
    }
}
