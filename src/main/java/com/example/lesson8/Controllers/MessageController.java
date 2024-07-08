package com.example.lesson8.Controllers;


import com.example.lesson8.Entities.Message;
import com.example.lesson8.ServicesInterfaces.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Messages", description = "Working with the BD 'messages'")
@RestController
@RequestMapping(path="/messages", produces = MediaType.APPLICATION_JSON_VALUE)
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/create")
    public Message createMessage(@RequestParam String text, @RequestParam Long senderId) {
        return messageService.createMessage(text, senderId);
    }

    @GetMapping("/getMessages")
    public Iterable<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/getMessageById")
    public Message getMessageById(@RequestParam Long messageId) {
        return messageService.getMessageById(messageId);
    }

    @DeleteMapping("/delete")
    public void deleteMessage(@RequestParam Long messageId) {
        messageService.deleteMessage(messageId);
    }

//    @Operation(
//            summary = "Retrieve a Tutorial by Id",
//            description = "Get a Tutorial object by specifying its id. The response is Tutorial object with id, title, description and published status.",
//            tags = { "tutorials", "get" })
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Message.class), mediaType = "application/json") }),
//            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
//            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
}
