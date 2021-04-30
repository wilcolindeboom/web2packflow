package nl.novi.lindeboom.web2packflow.controller;

import nl.novi.lindeboom.web2packflow.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
@RequestMapping(value = "/api/v1/storage")
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    @GetMapping("/index")
    public String index() {
//        model.addAttribute("message", "index");
        return "index";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        return fileUploadService.fileUpload(file);
    }

}


