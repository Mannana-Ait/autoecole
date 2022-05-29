package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.CategoriePermisAdminService;

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
import com.ird.faa.bean.CategoriePermis;
import com.ird.faa.ws.rest.provided.converter.CategoriePermisConverter;
import com.ird.faa.ws.rest.provided.vo.CategoriePermisVo;

@Api("Manages categoriePermis services")
@RestController
@RequestMapping("api/admin/categoriePermis")
public class CategoriePermisRestAdmin {

@Autowired
private CategoriePermisAdminService categoriePermisService;

@Autowired
private CategoriePermisConverter categoriePermisConverter;


            @ApiOperation("Updates the specified  categoriePermis")
            @PutMapping("/")
            public  CategoriePermisVo update(@RequestBody  CategoriePermisVo  categoriePermisVo){
            CategoriePermis categoriePermis = categoriePermisConverter.toItem(categoriePermisVo);
            categoriePermis = categoriePermisService.update(categoriePermis);
            return categoriePermisConverter.toVo(categoriePermis);
            }

    @ApiOperation("Finds a list of all categoriePermiss")
    @GetMapping("/")
    public List<CategoriePermisVo> findAll(){
        return categoriePermisConverter.toVo(categoriePermisService.findAll());
    }

    @ApiOperation("Finds a categoriePermis with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public CategoriePermisVo findByIdWithAssociatedList(@PathVariable Long id){
    return categoriePermisConverter.toVo(categoriePermisService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search categoriePermis by a specific criteria")
    @PostMapping("/search")
    public List<CategoriePermisVo> findByCriteria(@RequestBody CategoriePermisVo categoriePermisVo){
        return categoriePermisConverter.toVo(categoriePermisService.findByCriteria(categoriePermisVo));
        }

            @ApiOperation("Finds a categoriePermis by id")
            @GetMapping("/id/{id}")
            public CategoriePermisVo findById(@PathVariable Long id){
            return categoriePermisConverter.toVo(categoriePermisService.findById(id));
            }

            @ApiOperation("Saves the specified  categoriePermis")
            @PostMapping("/")
            public CategoriePermisVo save(@RequestBody CategoriePermisVo categoriePermisVo){
            CategoriePermis categoriePermis = categoriePermisConverter.toItem(categoriePermisVo);
            categoriePermis = categoriePermisService.save(categoriePermis);
            return categoriePermisConverter.toVo(categoriePermis);
            }

            @ApiOperation("Delete the specified categoriePermis")
            @DeleteMapping("/")
            public int delete(@RequestBody CategoriePermisVo categoriePermisVo){
            CategoriePermis categoriePermis = categoriePermisConverter.toItem(categoriePermisVo);
            return categoriePermisService.delete(categoriePermis);
            }

            @ApiOperation("Deletes a categoriePermis by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return categoriePermisService.deleteById(id);
            }




            }
