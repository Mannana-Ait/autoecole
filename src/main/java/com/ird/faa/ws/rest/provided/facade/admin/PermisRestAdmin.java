package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.PermisAdminService;

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
import com.ird.faa.bean.Permis;
import com.ird.faa.ws.rest.provided.converter.PermisConverter;
import com.ird.faa.ws.rest.provided.vo.PermisVo;

@Api("Manages permis services")
@RestController
@RequestMapping("api/admin/permis")
public class PermisRestAdmin {

@Autowired
private PermisAdminService permisService;

@Autowired
private PermisConverter permisConverter;


            @ApiOperation("Updates the specified  permis")
            @PutMapping("/")
            public  PermisVo update(@RequestBody  PermisVo  permisVo){
            Permis permis = permisConverter.toItem(permisVo);
            permis = permisService.update(permis);
            return permisConverter.toVo(permis);
            }

    @ApiOperation("Finds a list of all permiss")
    @GetMapping("/")
    public List<PermisVo> findAll(){
        return permisConverter.toVo(permisService.findAll());
    }

    @ApiOperation("Finds a permis with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public PermisVo findByIdWithAssociatedList(@PathVariable Long id){
    return permisConverter.toVo(permisService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search permis by a specific criteria")
    @PostMapping("/search")
    public List<PermisVo> findByCriteria(@RequestBody PermisVo permisVo){
        return permisConverter.toVo(permisService.findByCriteria(permisVo));
        }

            @ApiOperation("Finds a permis by id")
            @GetMapping("/id/{id}")
            public PermisVo findById(@PathVariable Long id){
            return permisConverter.toVo(permisService.findById(id));
            }

            @ApiOperation("Saves the specified  permis")
            @PostMapping("/")
            public PermisVo save(@RequestBody PermisVo permisVo){
            Permis permis = permisConverter.toItem(permisVo);
            permis = permisService.save(permis);
            return permisConverter.toVo(permis);
            }

            @ApiOperation("Delete the specified permis")
            @DeleteMapping("/")
            public int delete(@RequestBody PermisVo permisVo){
            Permis permis = permisConverter.toItem(permisVo);
            return permisService.delete(permis);
            }

            @ApiOperation("Deletes a permis by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return permisService.deleteById(id);
            }
        @ApiOperation("find by categoriePermis reference")
        @GetMapping("/categoriePermis/reference/{reference}")
        public List<Permis> findByCategoriePermisReference(@PathVariable String reference){
        return permisService.findByCategoriePermisReference(reference);
        }

        @ApiOperation("delete by categoriePermis reference")
        @DeleteMapping("/categoriePermis/reference/{reference}")
        public int deleteByCategoriePermisReference(@PathVariable String reference){
        return permisService.deleteByCategoriePermisReference(reference);
        }

        @ApiOperation("find by categoriePermis id")
        @GetMapping("/categoriePermis/id/{id}")
        public List<Permis> findByCategoriePermisId(@PathVariable Long id){
        return permisService.findByCategoriePermisId(id);
        }

        @ApiOperation("delete by categoriePermis id")
        @DeleteMapping("/categoriePermis/id/{id}")
        public int deleteByCategoriePermisId(@PathVariable Long id){
        return permisService.deleteByCategoriePermisId(id);
        }





            }
