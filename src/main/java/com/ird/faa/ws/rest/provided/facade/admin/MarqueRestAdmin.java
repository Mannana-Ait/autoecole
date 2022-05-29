package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.MarqueAdminService;

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
import com.ird.faa.bean.Marque;
import com.ird.faa.ws.rest.provided.converter.MarqueConverter;
import com.ird.faa.ws.rest.provided.vo.MarqueVo;

@Api("Manages marque services")
@RestController
@RequestMapping("api/admin/marque")
public class MarqueRestAdmin {

@Autowired
private MarqueAdminService marqueService;

@Autowired
private MarqueConverter marqueConverter;


            @ApiOperation("Updates the specified  marque")
            @PutMapping("/")
            public  MarqueVo update(@RequestBody  MarqueVo  marqueVo){
            Marque marque = marqueConverter.toItem(marqueVo);
            marque = marqueService.update(marque);
            return marqueConverter.toVo(marque);
            }

    @ApiOperation("Finds a list of all marques")
    @GetMapping("/")
    public List<MarqueVo> findAll(){
        return marqueConverter.toVo(marqueService.findAll());
    }

    @ApiOperation("Finds a marque with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public MarqueVo findByIdWithAssociatedList(@PathVariable Long id){
    return marqueConverter.toVo(marqueService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search marque by a specific criteria")
    @PostMapping("/search")
    public List<MarqueVo> findByCriteria(@RequestBody MarqueVo marqueVo){
        return marqueConverter.toVo(marqueService.findByCriteria(marqueVo));
        }

            @ApiOperation("Finds a marque by id")
            @GetMapping("/id/{id}")
            public MarqueVo findById(@PathVariable Long id){
            return marqueConverter.toVo(marqueService.findById(id));
            }

            @ApiOperation("Saves the specified  marque")
            @PostMapping("/")
            public MarqueVo save(@RequestBody MarqueVo marqueVo){
            Marque marque = marqueConverter.toItem(marqueVo);
            marque = marqueService.save(marque);
            return marqueConverter.toVo(marque);
            }

            @ApiOperation("Delete the specified marque")
            @DeleteMapping("/")
            public int delete(@RequestBody MarqueVo marqueVo){
            Marque marque = marqueConverter.toItem(marqueVo);
            return marqueService.delete(marque);
            }

            @ApiOperation("Deletes a marque by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return marqueService.deleteById(id);
            }




            }
