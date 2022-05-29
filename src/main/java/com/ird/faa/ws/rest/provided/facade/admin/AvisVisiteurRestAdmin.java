package  com.ird.faa.ws.rest.provided.facade.admin;

import com.ird.faa.service.admin.facade.AvisVisiteurAdminService;

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
import com.ird.faa.bean.AvisVisiteur;
import com.ird.faa.ws.rest.provided.converter.AvisVisiteurConverter;
import com.ird.faa.ws.rest.provided.vo.AvisVisiteurVo;

@Api("Manages avisVisiteur services")
@RestController
@RequestMapping("api/admin/avisVisiteur")
public class AvisVisiteurRestAdmin {

@Autowired
private AvisVisiteurAdminService avisVisiteurService;

@Autowired
private AvisVisiteurConverter avisVisiteurConverter;


            @ApiOperation("Updates the specified  avisVisiteur")
            @PutMapping("/")
            public  AvisVisiteurVo update(@RequestBody  AvisVisiteurVo  avisVisiteurVo){
            AvisVisiteur avisVisiteur = avisVisiteurConverter.toItem(avisVisiteurVo);
            avisVisiteur = avisVisiteurService.update(avisVisiteur);
            return avisVisiteurConverter.toVo(avisVisiteur);
            }

    @ApiOperation("Finds a list of all avisVisiteurs")
    @GetMapping("/")
    public List<AvisVisiteurVo> findAll(){
        return avisVisiteurConverter.toVo(avisVisiteurService.findAll());
    }

    @ApiOperation("Finds a avisVisiteur with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public AvisVisiteurVo findByIdWithAssociatedList(@PathVariable Long id){
    return avisVisiteurConverter.toVo(avisVisiteurService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search avisVisiteur by a specific criteria")
    @PostMapping("/search")
    public List<AvisVisiteurVo> findByCriteria(@RequestBody AvisVisiteurVo avisVisiteurVo){
        return avisVisiteurConverter.toVo(avisVisiteurService.findByCriteria(avisVisiteurVo));
        }

            @ApiOperation("Finds a avisVisiteur by id")
            @GetMapping("/id/{id}")
            public AvisVisiteurVo findById(@PathVariable Long id){
            return avisVisiteurConverter.toVo(avisVisiteurService.findById(id));
            }

            @ApiOperation("Saves the specified  avisVisiteur")
            @PostMapping("/")
            public AvisVisiteurVo save(@RequestBody AvisVisiteurVo avisVisiteurVo){
            AvisVisiteur avisVisiteur = avisVisiteurConverter.toItem(avisVisiteurVo);
            avisVisiteur = avisVisiteurService.save(avisVisiteur);
            return avisVisiteurConverter.toVo(avisVisiteur);
            }

            @ApiOperation("Delete the specified avisVisiteur")
            @DeleteMapping("/")
            public int delete(@RequestBody AvisVisiteurVo avisVisiteurVo){
            AvisVisiteur avisVisiteur = avisVisiteurConverter.toItem(avisVisiteurVo);
            return avisVisiteurService.delete(avisVisiteur);
            }

            @ApiOperation("Deletes a avisVisiteur by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return avisVisiteurService.deleteById(id);
            }
        @ApiOperation("find by typeAvis reference")
        @GetMapping("/typeAvis/reference/{reference}")
        public List<AvisVisiteur> findByTypeAvisReference(@PathVariable String reference){
        return avisVisiteurService.findByTypeAvisReference(reference);
        }

        @ApiOperation("delete by typeAvis reference")
        @DeleteMapping("/typeAvis/reference/{reference}")
        public int deleteByTypeAvisReference(@PathVariable String reference){
        return avisVisiteurService.deleteByTypeAvisReference(reference);
        }

        @ApiOperation("find by typeAvis id")
        @GetMapping("/typeAvis/id/{id}")
        public List<AvisVisiteur> findByTypeAvisId(@PathVariable Long id){
        return avisVisiteurService.findByTypeAvisId(id);
        }

        @ApiOperation("delete by typeAvis id")
        @DeleteMapping("/typeAvis/id/{id}")
        public int deleteByTypeAvisId(@PathVariable Long id){
        return avisVisiteurService.deleteByTypeAvisId(id);
        }





            }
