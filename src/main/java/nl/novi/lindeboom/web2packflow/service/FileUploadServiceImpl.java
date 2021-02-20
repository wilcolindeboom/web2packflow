package nl.novi.lindeboom.web2packflow.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private static final String storageLocation = System.getProperty("user.dir") + "/uploads/";

    @Override
    @ResponseBody
    public String fileUpload(MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        file.transferTo(new File(storageLocation + filename));
        return "File successfully uploaded!";
     }

}
