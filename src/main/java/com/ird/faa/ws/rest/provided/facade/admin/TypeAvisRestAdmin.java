package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.TypeAvisAdminService;

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
import com.ird.faa.bean.TypeAvis;
import com.ird.faa.ws.rest.provided.converter.TypeAvisConverter;
import com.ird.faa.ws.rest.provided.vo.TypeAvisVo;

@Api("Manages typeAvis services")
@RestController
@RequestMapping("api/admin/typeAvis")
public class TypeAvisRestAdmin {

@Autowired
private TypeAvisAdminService typeAvisService;

@Autowired
private TypeAvisConverter typeAvisConverter;


            @ApiOperation("Updates the specified  typeAvis")
            @PutMapping("/")
            public  TypeAvisVo update(@RequestBody  TypeAvisVo  typeAvisVo){
            TypeAvis typeAvis = typeAvisConverter.toItem(typeAvisVo);
            typeAvis = typeAvisService.update(typeAvis);
            return typeAvisConverter.toVo(typeAvis);
            }

    @ApiOperation("Finds a list of all typeAviss")
    @GetMapping("/")
    public List<TypeAvisVo> findAll(){
        return typeAvisConverter.toVo(typeAvisService.findAll());
    }

    @ApiOperation("Finds a typeAvis with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeAvisVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeAvisConverter.toVo(typeAvisService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeAvis by a specific criteria")
    @PostMapping("/search")
    public List<TypeAvisVo> findByCriteria(@RequestBody TypeAvisVo typeAvisVo){
        return typeAvisConverter.toVo(typeAvisService.findByCriteria(typeAvisVo));
        }

            @ApiOperation("Finds a typeAvis by id")
            @GetMapping("/id/{id}")
            public TypeAvisVo findById(@PathVariable Long id){
            return typeAvisConverter.toVo(typeAvisService.findById(id));
            }

            @ApiOperation("Saves the specified  typeAvis")
            @PostMapping("/")
            public TypeAvisVo save(@RequestBody TypeAvisVo typeAvisVo){
            TypeAvis typeAvis = typeAvisConverter.toItem(typeAvisVo);
            typeAvis = typeAvisService.save(typeAvis);
            return typeAvisConverter.toVo(typeAvis);
            }

            @ApiOperation("Delete the specified typeAvis")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeAvisVo typeAvisVo){
            TypeAvis typeAvis = typeAvisConverter.toItem(typeAvisVo);
            return typeAvisService.delete(typeAvis);
            }

            @ApiOperation("Deletes a typeAvis by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeAvisService.deleteById(id);
            }




            }
