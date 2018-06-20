package com.spring.processor;

import com.spring.domain.FileHeaders;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by Binod Bhandari on 6/19/18.
 */

public class Itemprocessor implements ItemProcessor<FileHeaders, Itemprocessor> {

    @Override
    public Itemprocessor process(FileHeaders item) throws Exception {
        Itemprocessor itemprocessor = new Itemprocessor();

        return itemprocessor;
    }


}
