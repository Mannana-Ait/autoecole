package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.MessageAdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.ird.faa.bean.Message;
import com.ird.faa.ws.rest.provided.converter.MessageConverter;
import com.ird.faa.ws.rest.provided.vo.MessageVo;

@Api("Manages message services")
@RestController
@RequestMapping("api/admin/message")
public class MessageRestAdmin {

@Autowired
private MessageAdminService messageService;

@Autowired
private MessageConverter messageConverter;


            @ApiOperation("Updates the specified  message")
            @PutMapping("/")
            public  MessageVo update(@RequestBody  MessageVo  messageVo){
            Message message = messageConverter.toItem(messageVo);
            message = messageService.update(message);
            return messageConverter.toVo(message);
            }

    @ApiOperation("Finds a list of all messages")
    @GetMapping("/")
    public List<MessageVo> findAll(){
        return messageConverter.toVo(messageService.findAll());
    }

    @ApiOperation("Finds a message with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public MessageVo findByIdWithAssociatedList(@PathVariable Long id){
    return messageConverter.toVo(messageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search message by a specific criteria")
    @PostMapping("/search")
    public List<MessageVo> findByCriteria(@RequestBody MessageVo messageVo){
        return messageConverter.toVo(messageService.findByCriteria(messageVo));
        }

            @ApiOperation("Finds a message by id")
            @GetMapping("/id/{id}")
            public MessageVo findById(@PathVariable Long id){
            return messageConverter.toVo(messageService.findById(id));
            }

            @ApiOperation("Saves the specified  message")
            @PostMapping("/")
            public MessageVo save(@RequestBody MessageVo messageVo){
            Message message = messageConverter.toItem(messageVo);
            message = messageService.save(message);
            return messageConverter.toVo(message);
            }

            @ApiOperation("Delete the specified message")
            @DeleteMapping("/")
            public int delete(@RequestBody MessageVo messageVo){
            Message message = messageConverter.toItem(messageVo);
            return messageService.delete(message);
            }

            @ApiOperation("Deletes a message by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return messageService.deleteById(id);
            }
        @ApiOperation("find by etatMessage reference")
        @GetMapping("/etatMessage/reference/{reference}")
        public List<Message> findByEtatMessageReference(@PathVariable String reference){
        return messageService.findByEtatMessageReference(reference);
        }

        @ApiOperation("delete by etatMessage reference")
        @DeleteMapping("/etatMessage/reference/{reference}")
        public int deleteByEtatMessageReference(@PathVariable String reference){
        return messageService.deleteByEtatMessageReference(reference);
        }

        @ApiOperation("find by etatMessage id")
        @GetMapping("/etatMessage/id/{id}")
        public List<Message> findByEtatMessageId(@PathVariable Long id){
        return messageService.findByEtatMessageId(id);
        }

        @ApiOperation("delete by etatMessage id")
        @DeleteMapping("/etatMessage/id/{id}")
        public int deleteByEtatMessageId(@PathVariable Long id){
        return messageService.deleteByEtatMessageId(id);
        }





            }
