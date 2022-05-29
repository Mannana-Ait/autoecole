package  com.ird.faa.ws.rest.provided.facade.chercheur;

import com.ird.faa.service.chercheur.facade.JourChercheurService;

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
import com.ird.faa.bean.Jour;
import com.ird.faa.ws.rest.provided.converter.JourConverter;
import com.ird.faa.ws.rest.provided.vo.JourVo;

@Api("Manages jour services")
@RestController
@RequestMapping("api/chercheur/jour")
public class JourRestChercheur {

@Autowired
private JourChercheurService jourService;

@Autowired
private JourConverter jourConverter;


            @ApiOperation("Updates the specified  jour")
            @PutMapping("/")
            public  JourVo update(@RequestBody  JourVo  jourVo){
            Jour jour = jourConverter.toItem(jourVo);
            jour = jourService.update(jour);
            return jourConverter.toVo(jour);
            }

    @ApiOperation("Finds a list of all jours")
    @GetMapping("/")
    public List<JourVo> findAll(){
        return jourConverter.toVo(jourService.findAll());
    }

    @ApiOperation("Finds a jour with associated lists by id")
    @GetMapping("/detail/id/{id}")
    public JourVo findByIdWithAssociatedList(@PathVariable Long id){
    return jourConverter.toVo(jourService.findByIdWithAssociatedList(id));
    }

    @ApiOperation("Search jour by a specific criteria")
    @PostMapping("/search")
    public List<JourVo> findByCriteria(@RequestBody JourVo jourVo){
        return jourConverter.toVo(jourService.findByCriteria(jourVo));
        }

            @ApiOperation("Finds a jour by id")
            @GetMapping("/id/{id}")
            public JourVo findById(@PathVariable Long id){
            return jourConverter.toVo(jourService.findById(id));
            }

            @ApiOperation("Saves the specified  jour")
            @PostMapping("/")
            public JourVo save(@RequestBody JourVo jourVo){
            Jour jour = jourConverter.toItem(jourVo);
            jour = jourService.save(jour);
            return jourConverter.toVo(jour);
            }

            @ApiOperation("Delete the specified jour")
            @DeleteMapping("/")
            public int delete(@RequestBody JourVo jourVo){
            Jour jour = jourConverter.toItem(jourVo);
            return jourService.delete(jour);
            }

            @ApiOperation("Deletes a jour by id")
            @DeleteMapping("/id/{id}")
            public int deleteById(@PathVariable Long id){
            return jourService.deleteById(id);
            }




            }
