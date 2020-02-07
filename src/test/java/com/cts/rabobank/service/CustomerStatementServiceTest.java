package com.cts.rabobank.service;

import com.cts.rabobank.factory.FileValidationFactory;
import com.cts.rabobank.model.RequestRecord;
import com.cts.rabobank.service.CustomerStatementProcessorService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerStatementServiceTest {
    @InjectMocks
    CustomerStatementProcessorService customerStatementProcessorService;
    @Mock
    FileValidationFactory fileValidationFactory;
    @Mock
    MultipartFile multipartFile;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void processTest() {
        String contentType = "text/csv";
        when(fileValidationFactory.processFile(multipartFile, contentType)).thenReturn(null);
        List<RequestRecord> requestRecords = customerStatementProcessorService.process(multipartFile, contentType);
    System.out.println(requestRecords);
    }
}