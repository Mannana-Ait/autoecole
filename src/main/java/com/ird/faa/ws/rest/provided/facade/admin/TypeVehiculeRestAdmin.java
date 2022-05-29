package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.TypeVehiculeAdminService;

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
import com.ird.faa.bean.TypeVehicule;
import com.ird.faa.ws.rest.provided.converter.TypeVehiculeConverter;
import com.ird.faa.ws.rest.provided.vo.TypeVehiculeVo;

@Api("Manages typeVehicule services")
@RestController
@RequestMapping("api/admin/typeVehicule")
public class TypeVehiculeRestAdmin {

@Autowired
private TypeVehiculeAdminService typeVehiculeService;

@Autowired
private TypeVehiculeConverter typeVehiculeConverter;


            @ApiOperation("Updates the specified  typeVehicule")
            @PutMapping("/")
            public  TypeVehiculeVo update(@RequestBody  TypeVehiculeVo  typeVehiculeVo){
            TypeVehicule typeVehicule = typeVehiculeConverter.toItem(typeVehiculeVo);
            typeVehicule = typeVehiculeService.update(typeVehicule);
            return typeVehiculeConverter.toVo(typeVehicule);
            }

    @ApiOperation("Finds a list of all typeVehicules")
    @GetMapping("/")
    public List<TypeVehiculeVo> findAll(){
        return typeVehiculeConverter.toVo(typeVehiculeService.findAll());
    }

    @ApiOperation("Finds a typeVehicule with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public TypeVehiculeVo findByIdWithAssociatedList(@PathVariable Long id){
    return typeVehiculeConverter.toVo(typeVehiculeService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search typeVehicule by a specific criteria")
    @PostMapping("/search")
    public List<TypeVehiculeVo> findByCriteria(@RequestBody TypeVehiculeVo typeVehiculeVo){
        return typeVehiculeConverter.toVo(typeVehiculeService.findByCriteria(typeVehiculeVo));
        }

            @ApiOperation("Finds a typeVehicule by id")
            @GetMapping("/id/{id}")
            public TypeVehiculeVo findById(@PathVariable Long id){
            return typeVehiculeConverter.toVo(typeVehiculeService.findById(id));
            }

            @ApiOperation("Saves the specified  typeVehicule")
            @PostMapping("/")
            public TypeVehiculeVo save(@RequestBody TypeVehiculeVo typeVehiculeVo){
            TypeVehicule typeVehicule = typeVehiculeConverter.toItem(typeVehiculeVo);
            typeVehicule = typeVehiculeService.save(typeVehicule);
            return typeVehiculeConverter.toVo(typeVehicule);
            }

            @ApiOperation("Delete the specified typeVehicule")
            @DeleteMapping("/")
            public int delete(@RequestBody TypeVehiculeVo typeVehiculeVo){
            TypeVehicule typeVehicule = typeVehiculeConverter.toItem(typeVehiculeVo);
            return typeVehiculeService.delete(typeVehicule);
            }

            @ApiOperation("Deletes a typeVehicule by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return typeVehiculeService.deleteById(id);
            }




            }
