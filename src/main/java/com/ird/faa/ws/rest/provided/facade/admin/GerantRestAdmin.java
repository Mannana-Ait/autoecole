package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.GerantAdminService;

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
import com.ird.faa.bean.Gerant;
import com.ird.faa.ws.rest.provided.converter.GerantConverter;
import com.ird.faa.ws.rest.provided.vo.GerantVo;

@Api("Manages gerant services")
@RestController
@RequestMapping("api/admin/gerant")
public class GerantRestAdmin {

@Autowired
private GerantAdminService gerantService;

@Autowired
private GerantConverter gerantConverter;


            @ApiOperation("Updates the specified  gerant")
            @PutMapping("/")
            public  GerantVo update(@RequestBody  GerantVo  gerantVo){
            Gerant gerant = gerantConverter.toItem(gerantVo);
            gerant = gerantService.update(gerant);
            return gerantConverter.toVo(gerant);
            }

    @ApiOperation("Finds a list of all gerants")
    @GetMapping("/")
    public List<GerantVo> findAll(){
        return gerantConverter.toVo(gerantService.findAll());
    }

    @ApiOperation("Finds a gerant with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public GerantVo findByIdWithAssociatedList(@PathVariable Long id){
    return gerantConverter.toVo(gerantService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search gerant by a specific criteria")
    @PostMapping("/search")
    public List<GerantVo> findByCriteria(@RequestBody GerantVo gerantVo){
        return gerantConverter.toVo(gerantService.findByCriteria(gerantVo));
        }

            @ApiOperation("Finds a gerant by id")
            @GetMapping("/id/{id}")
            public GerantVo findById(@PathVariable Long id){
            return gerantConverter.toVo(gerantService.findById(id));
            }

            @ApiOperation("Saves the specified  gerant")
            @PostMapping("/")
            public GerantVo save(@RequestBody GerantVo gerantVo){
            Gerant gerant = gerantConverter.toItem(gerantVo);
            gerant = gerantService.save(gerant);
            return gerantConverter.toVo(gerant);
            }

            @ApiOperation("Delete the specified gerant")
            @DeleteMapping("/")
            public int delete(@RequestBody GerantVo gerantVo){
            Gerant gerant = gerantConverter.toItem(gerantVo);
            return gerantService.delete(gerant);
            }

            @ApiOperation("Deletes a gerant by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return gerantService.deleteById(id);
            }
        @ApiOperation("find by gender reference")
        @GetMapping("/gender/reference/{reference}")
        public List<Gerant> findByGenderReference(@PathVariable String reference){
        return gerantService.findByGenderReference(reference);
        }

        @ApiOperation("delete by gender reference")
        @DeleteMapping("/gender/reference/{reference}")
        public int deleteByGenderReference(@PathVariable String reference){
        return gerantService.deleteByGenderReference(reference);
        }

        @ApiOperation("find by gender id")
        @GetMapping("/gender/id/{id}")
        public List<Gerant> findByGenderId(@PathVariable Long id){
        return gerantService.findByGenderId(id);
        }

        @ApiOperation("delete by gender id")
        @DeleteMapping("/gender/id/{id}")
        public int deleteByGenderId(@PathVariable Long id){
        return gerantService.deleteByGenderId(id);
        }





            }
