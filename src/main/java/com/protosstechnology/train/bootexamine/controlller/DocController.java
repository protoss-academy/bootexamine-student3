package com.protosstechnology.train.bootexamine.controlller;
import com.protosstechnology.train.bootexamine.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import com.protosstechnology.train.bootexamine.entity.Document;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/document")

public class DocController {

    DocumentService documentService;

    @PostMapping
    public ResponseEntity<Document> addDocument(@RequestBody Document document){
        log.info("======== in Method addUser");
        documentService.create(document);

        log.info("User Id={}",document.getId());
        return ResponseEntity.ok().body(document);

    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Found the User",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Document.class))}),
            @ApiResponse(responseCode = "400",description = "Invalid id user",
                    content = @Content),
            @ApiResponse(responseCode = "404",description = "User Not Found",
                    content = @Content)
    })

    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocument(@PathVariable("id") String id){
        log.info("in GetDocument id={}",id);
        return ResponseEntity.ok().body(documentService.read(Long.parseLong(id)));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable("id") String id,
                                                   @RequestBody Document document){
        log.info("=========== in Method updateUser");
        document.setId(Long.parseLong(id));
        return ResponseEntity.ok().body(documentService.update(document));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable("id") String id){
        log.info("=========== in Method deleteUser");

        String responseStr = new String();
        try {
            documentService.delete(Long.parseLong("id"));

            responseStr = "Delete Document{\"+id+\"} Successful";
        }catch (Exception e) {
            responseStr = "Delete Document{\"+id+\"} Fail";
        }
        //userService.delete();
        return ResponseEntity.ok().body(responseStr);
    }
}

