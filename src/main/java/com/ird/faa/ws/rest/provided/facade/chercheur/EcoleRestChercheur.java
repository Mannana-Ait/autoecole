package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.EcoleChercheurService;

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
import com.ird.faa.bean.Ecole;
import com.ird.faa.ws.rest.provided.converter.EcoleConverter;
import com.ird.faa.ws.rest.provided.vo.EcoleVo;

@Api("Manages ecole services")
@RestController
@RequestMapping("api/chercheur/ecole")
public class EcoleRestChercheur {

@Autowired
private EcoleChercheurService ecoleService;

@Autowired
private EcoleConverter ecoleConverter;


            @ApiOperation("Updates the specified  ecole")
            @PutMapping("/")
            public  EcoleVo update(@RequestBody  EcoleVo  ecoleVo){
            Ecole ecole = ecoleConverter.toItem(ecoleVo);
            ecole = ecoleService.update(ecole);
            return ecoleConverter.toVo(ecole);
            }

    @ApiOperation("Finds a list of all ecoles")
    @GetMapping("/")
    public List<EcoleVo> findAll(){
        ecoleConverter.initList(false);
    List<EcoleVo> result= ecoleConverter.toVo(ecoleService.findAll());
    ecoleConverter.initList(true);
        return result;
    }

    @ApiOperation("Finds a ecole with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public EcoleVo findByIdWithAssociatedList(@PathVariable Long id){
    return ecoleConverter.toVo(ecoleService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search ecole by a specific criteria")
    @PostMapping("/search")
    public List<EcoleVo> findByCriteria(@RequestBody EcoleVo ecoleVo){
        return ecoleConverter.toVo(ecoleService.findByCriteria(ecoleVo));
        }

            @ApiOperation("Finds a ecole by id")
            @GetMapping("/id/{id}")
            public EcoleVo findById(@PathVariable Long id){
            return ecoleConverter.toVo(ecoleService.findById(id));
            }

            @ApiOperation("Saves the specified  ecole")
            @PostMapping("/")
            public EcoleVo save(@RequestBody EcoleVo ecoleVo){
            Ecole ecole = ecoleConverter.toItem(ecoleVo);
            ecole = ecoleService.save(ecole);
            return ecoleConverter.toVo(ecole);
            }

            @ApiOperation("Delete the specified ecole")
            @DeleteMapping("/")
            public int delete(@RequestBody EcoleVo ecoleVo){
            Ecole ecole = ecoleConverter.toItem(ecoleVo);
            return ecoleService.delete(ecole);
            }

            @ApiOperation("Deletes a ecole by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return ecoleService.deleteById(id);
            }
        @ApiOperation("find by ville reference")
        @GetMapping("/ville/reference/{reference}")
        public List<Ecole> findByVilleReference(@PathVariable String reference){
        return ecoleService.findByVilleReference(reference);
        }

        @ApiOperation("delete by ville reference")
        @DeleteMapping("/ville/reference/{reference}")
        public int deleteByVilleReference(@PathVariable String reference){
        return ecoleService.deleteByVilleReference(reference);
        }

        @ApiOperation("find by ville id")
        @GetMapping("/ville/id/{id}")
        public List<Ecole> findByVilleId(@PathVariable Long id){
        return ecoleService.findByVilleId(id);
        }

        @ApiOperation("delete by ville id")
        @DeleteMapping("/ville/id/{id}")
        public int deleteByVilleId(@PathVariable Long id){
        return ecoleService.deleteByVilleId(id);
        }

        @ApiOperation("find by gerant reference")
        @GetMapping("/gerant/reference/{reference}")
        public List<Ecole> findByGerantReference(@PathVariable String reference){
        return ecoleService.findByGerantReference(reference);
        }

        @ApiOperation("delete by gerant reference")
        @DeleteMapping("/gerant/reference/{reference}")
        public int deleteByGerantReference(@PathVariable String reference){
        return ecoleService.deleteByGerantReference(reference);
        }

        @ApiOperation("find by gerant id")
        @GetMapping("/gerant/id/{id}")
        public List<Ecole> findByGerantId(@PathVariable Long id){
        return ecoleService.findByGerantId(id);
        }

        @ApiOperation("delete by gerant id")
        @DeleteMapping("/gerant/id/{id}")
        public int deleteByGerantId(@PathVariable Long id){
        return ecoleService.deleteByGerantId(id);
        }





            }
