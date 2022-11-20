package com.xec.spring;

import com.xec.spring.interview.FileDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ImageController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


        @PostMapping(value = "/examplefileupload/withparameter",
                consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE} )
        public ResponseEntity<String> uploadFileWithParameter(@RequestParam MultipartFile file) {
            LOGGER.info("File upload with parameter:" + file.getOriginalFilename());
            return ResponseEntity.ok("Success");
        }

    @PostMapping(value = "/examplefileupload/withrequestpart",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<String> uploadFileWithRequestPart(@RequestPart MultipartFile file) {
        LOGGER.info("Request contains, File: " + file.getOriginalFilename());
        return ResponseEntity.ok("Success");
    }

    @PostMapping(value = "/examplefileupload/withrequestbody",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<String> uploadFileWithRequestBody(@RequestBody MultipartFile file) {
        LOGGER.info("Request file with request body" + file.getOriginalFilename());
        return ResponseEntity.ok("Success");
    }

    @PostMapping(value = "/examplefileupload/withrequestAsArray",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<String> uploadFileWithArray(MultipartFile[] files) {
        LOGGER.info("Request files as an array" + files.length);
        return ResponseEntity.ok("Success");
    }

    @PostMapping(value = "/examplefileupload/withrequestAsList",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public ResponseEntity<String> uploadFileWithList(List<MultipartFile> files) {
        LOGGER.info("Request files as list " + files.size());
        // Add your processing logic here
        return ResponseEntity.ok("Success");
    }

    @PostMapping(value = "/examplefileupload/withrequestasobject",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE} )
    public String uploadFilesExample7(FileDetails fileDetails) {
        LOGGER.info("File details " + fileDetails);
        return "success";
    }




    }


