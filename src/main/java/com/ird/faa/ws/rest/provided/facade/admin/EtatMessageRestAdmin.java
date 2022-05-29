package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.EtatMessageAdminService;

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
import com.ird.faa.bean.EtatMessage;
import com.ird.faa.ws.rest.provided.converter.EtatMessageConverter;
import com.ird.faa.ws.rest.provided.vo.EtatMessageVo;

@Api("Manages etatMessage services")
@RestController
@RequestMapping("api/admin/etatMessage")
public class EtatMessageRestAdmin {

@Autowired
private EtatMessageAdminService etatMessageService;

@Autowired
private EtatMessageConverter etatMessageConverter;


            @ApiOperation("Updates the specified  etatMessage")
            @PutMapping("/")
            public  EtatMessageVo update(@RequestBody  EtatMessageVo  etatMessageVo){
            EtatMessage etatMessage = etatMessageConverter.toItem(etatMessageVo);
            etatMessage = etatMessageService.update(etatMessage);
            return etatMessageConverter.toVo(etatMessage);
            }

    @ApiOperation("Finds a list of all etatMessages")
    @GetMapping("/")
    public List<EtatMessageVo> findAll(){
        return etatMessageConverter.toVo(etatMessageService.findAll());
    }

    @ApiOperation("Finds a etatMessage with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EtatMessageVo findByIdWithAssociatedList(@PathVariable Long id){
    return etatMessageConverter.toVo(etatMessageService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search etatMessage by a specific criteria")
    @PostMapping("/search")
    public List<EtatMessageVo> findByCriteria(@RequestBody EtatMessageVo etatMessageVo){
        return etatMessageConverter.toVo(etatMessageService.findByCriteria(etatMessageVo));
        }

            @ApiOperation("Finds a etatMessage by id")
            @GetMapping("/id/{id}")
            public EtatMessageVo findById(@PathVariable Long id){
            return etatMessageConverter.toVo(etatMessageService.findById(id));
            }

            @ApiOperation("Saves the specified  etatMessage")
            @PostMapping("/")
            public EtatMessageVo save(@RequestBody EtatMessageVo etatMessageVo){
            EtatMessage etatMessage = etatMessageConverter.toItem(etatMessageVo);
            etatMessage = etatMessageService.save(etatMessage);
            return etatMessageConverter.toVo(etatMessage);
            }

            @ApiOperation("Delete the specified etatMessage")
            @DeleteMapping("/")
            public int delete(@RequestBody EtatMessageVo etatMessageVo){
            EtatMessage etatMessage = etatMessageConverter.toItem(etatMessageVo);
            return etatMessageService.delete(etatMessage);
            }

            @ApiOperation("Deletes a etatMessage by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return etatMessageService.deleteById(id);
            }




            }
