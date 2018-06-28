package com.spring;

import com.spring.outputFileDomain.HeadersField;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

/**
 * Created by Binod Bhandari on 6/19/18.
 */
@Configuration
public class SpringSharedConfig {


    public int CHUNk_SIZE = 10;
    private StepBuilderFactory stepBuilderFactory;

    private final String OUTPUT_FILE = "outputFile_Drexel_Record" + LocalDateTime.now() + ".csv";

    @Autowired
    public SpringSharedConfig(StepBuilderFactory stepBuilderFactory) {
        this.stepBuilderFactory = stepBuilderFactory;
    }

    public ItemWriter<? super HeadersField> positionWriter() {
        return null;
    }

    @Bean
    public Step sftpStep() {
        return  stepBuilderFactory.get("sftpStep")
                .tasklet(binodSftpTasklet())
                .build();
    }

    @ConfigurationProperties("sftp.mft")
    @Bean
    public Tasklet binodSftpTasklet() {
        //sftpTasklet a = new ---
        //a .setLocalFiles(files: + file_name"

        return null;
    }
}
