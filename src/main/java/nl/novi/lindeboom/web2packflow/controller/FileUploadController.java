package nl.novi.lindeboom.web2packflow.controller;

import nl.novi.lindeboom.web2packflow.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "/api/v1/storage")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;


    private static final String storageLocation = System.getProperty("user.dir") + "/uploads/";


    @PostMapping("/upload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        return fileUploadService.fileUpload(file);
    }

//    @ResponseBody
//    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
//        String filename = file.getOriginalFilename();
//        file.transferTo(new File(storageLocation + filename));
//        return "File successfully uploaded!";
//        }

   }


